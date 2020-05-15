package com.jianke.mall.dynamicproxy.AnnotationAop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
 
/**
 *
 *  @Aspect + @Pointcut()这两个注解就相当于之前配置文件里下边的内容
 *  <aop:config>
 *		<aop:pointcut expression="execution(* com.cj.study.spring.aop.*.*(..))" id="perform"/>
 *  </aop:config>
 *  
 *  @Before()这个注解就相当于之前配置文件里
 *  <aop:aspect ref="myTransaction">
 *		<aop:before method="beginTransaction" pointcut-ref="perform"/>
 *	</aop:aspect>
 *  
 * @author caoju
 *
 */
//切面类
@Component
@Aspect
public class MyTransaction {
	
	//这个 aaa() 方法没有其他作用，仅仅是用它来标明一下切入点表达式
	@Pointcut("execution(* com.jianke.mall.dynamicproxy.AnnotationAop..*.*(..))")
	public void aaa(){

	}
	
	//切面里的通知方法
	@Before("aaa()")
	public void beginTransaction(){
		System.out.println("开启事务 ");
	}
	
	//切面里的通知方法
	@After("aaa()")
	public void commit(){
		System.out.println("提交事务");
	}
	
}