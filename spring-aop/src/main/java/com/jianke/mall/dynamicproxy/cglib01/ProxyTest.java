package com.jianke.mall.dynamicproxy.cglib01;

public class ProxyTest {

	public static void main(String[] args) {
		test();
	}

	public static void test(){
		Object target = new PersonServiceImpl();
		MyTransaction myTransaction = new MyTransaction();
		PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);
		PersonService personService =(PersonService) interceptor.createProxy();
		String returnValue = (String)personService.savePerson();
		System.out.println(returnValue);
	}
}