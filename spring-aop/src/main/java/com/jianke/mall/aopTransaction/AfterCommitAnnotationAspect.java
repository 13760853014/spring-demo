package com.jianke.mall.aopTransaction;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Aspect
@Slf4j
public class AfterCommitAnnotationAspect {

    private final AfterCommitExecutor afterCommitExecutor;

    @Autowired
    public AfterCommitAnnotationAspect(AfterCommitExecutor afterCommitExecutor) {
        this.afterCommitExecutor = afterCommitExecutor;
    }

    @Around(value = "@annotation(com.jianke.mall.aopTransaction.AfterCommit)", argNames = "pjp")
    public Object aroundAdvice(final ProceedingJoinPoint pjp) {
        afterCommitExecutor.execute(new PjpAfterCommitRunnable(pjp));
        return null;
    }

    private static final class PjpAfterCommitRunnable implements Runnable {
        private final ProceedingJoinPoint pjp;

        public PjpAfterCommitRunnable(ProceedingJoinPoint pjp) {
            this.pjp = pjp;
        }

        @Override
        public void run() {
            try {
                log.info("start run PjpAfterCommitRunnable run... ");
                pjp.proceed();
            } catch (Throwable e) {
                log.error("Exception while invoking pjp.proceed()", e);
                throw new RuntimeException(e);
            }
        }

        @Override
        public String toString() {
            String typeName = pjp.getTarget().getClass().getSimpleName();
            String methodName = pjp.getSignature().getName();
            return "PjpAfterCommitRunnable[type=" + typeName + ", method=" + methodName + "]";
        }
    }
}
 
