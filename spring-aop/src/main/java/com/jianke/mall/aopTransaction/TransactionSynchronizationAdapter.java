package com.jianke.mall.aopTransaction;

import org.springframework.core.Ordered;
import org.springframework.transaction.support.TransactionSynchronization;

public abstract class TransactionSynchronizationAdapter implements TransactionSynchronization, Ordered {

	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	public void suspend() {
	}

	public void resume() {
	}

	public void flush() {
	}

	public void beforeCommit(boolean readOnly) {
	}

	public void beforeCompletion() {
	}

	public void afterCommit() {
	}

	public void afterCompletion(int status) {
	}

}