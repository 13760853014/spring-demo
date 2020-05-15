package com.jianke.mall.dynamicproxy.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class AopTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonService proxyPersonService = (PersonService) context.getBean("personService");
		String returnValue = proxyPersonService.savePerson();
		System.out.println(returnValue);
	}
}