package com.jianke.mall.dynamicproxy.aop;

//切面类
public class MyTransaction {
	//切面里的通知方法
	public void beginTransaction(){
		System.out.println("开启事务 ");
	}
	//切面里的通知方法
	public void commit(){
		System.out.println("提交事务");
	}
}