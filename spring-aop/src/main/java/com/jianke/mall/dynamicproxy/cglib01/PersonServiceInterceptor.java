package com.jianke.mall.dynamicproxy.cglib01;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
 
public class PersonServiceInterceptor implements MethodInterceptor{
	//目标类
	private Object target;
	//增强类
	private MyTransaction myTransaction;
	//构造函数注入目标类和增强类
	public PersonServiceInterceptor(Object target,MyTransaction myTransaction){
		this.target = target;
		this.myTransaction = myTransaction;
	}
	
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(this.target.getClass());
		return enhancer.create();
	}
 
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		myTransaction.beginTransaction();
		Object returnValue = arg1.invoke(this.target, arg2);
		myTransaction.commit();
		return returnValue;
	}
	
}