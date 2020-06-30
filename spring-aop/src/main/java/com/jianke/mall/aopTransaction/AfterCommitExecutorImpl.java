package com.jianke.mall.aopTransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AfterCommitExecutorImpl extends TransactionSynchronizationAdapter implements AfterCommitExecutor {
    private static final ThreadLocal<List<Runnable>> RUNNABLES = new ThreadLocal<List<Runnable>>();
 
    @Override
    public void execute(Runnable runnable) {
        log.info("Submitting new runnable {"+runnable+"} to run after commit");
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            log.info("Transaction synchronization is NOT ACTIVE. Executing right now runnable {"+runnable+"}");
            runnable.run();
            return;
        }
        List<Runnable> threadRunnables = RUNNABLES.get();
        if (threadRunnables == null) {
            threadRunnables = new ArrayList<Runnable>();
            RUNNABLES.set(threadRunnables);
            TransactionSynchronizationManager.registerSynchronization(this);
        }
        threadRunnables.add(runnable);
    }
 
    @Override
    public void afterCommit() {
        List<Runnable> threadRunnables = RUNNABLES.get();
        log.info("Transaction successfully committed, executing {"+threadRunnables.size()+"} runnables" );
        for (int i = 0; i < threadRunnables.size(); i++) {
            Runnable runnable = threadRunnables.get(i);
            log.info("Executing runnable {"+runnable+"}");
            try {
                runnable.run();
            } catch (RuntimeException e) {
                log.error("Failed to execute runnable " + runnable, e);
            }
        }
    }
 
    @Override
    public void afterCompletion(int status) {
        log.info("Transaction completed with status {"+(status == STATUS_COMMITTED ? "COMMITTED" : "ROLLED_BACK")+"}");
        RUNNABLES.remove();
    }
 
}