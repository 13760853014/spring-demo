package com.jianke.mall.dynamicproxy.jdk01;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		test();
	}
	public static void test(){
		Object target = new PersonServiceImpl();
		MyTransaction myTransaction = new MyTransaction();
		PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);
		PersonService personService = (PersonService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),interceptor);
		String returnValue = personService.savePerson();
		System.out.println(returnValue);
	}
}