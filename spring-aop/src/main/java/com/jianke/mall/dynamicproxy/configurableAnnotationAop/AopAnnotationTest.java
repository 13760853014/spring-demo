package com.jianke.mall.dynamicproxy.configurableAnnotationAop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class AopAnnotationTest {
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(AopAnnotationTest.class);
		PersonService proxyPersonService = (PersonService) context.getBean("personServiceImpl");
		proxyPersonService.savePerson();
		System.out.println();
		proxyPersonService.updatePerson();

	}
}