package com.jianke.mall.dynamicproxy.AnnotationAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class AopAnnotationTest {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
		PersonService proxyPersonService = (PersonService) context.getBean("personService");
		proxyPersonService.savePerson();
		System.out.println();
		proxyPersonService.updatePerson();

	}
}