package com.jianke.mall.aopRedisLock;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class RedisLockTest {
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(RedisLockTest.class);
		OrderService orderService = (OrderService) context.getBean("orderService");
		orderService.order("cgq", "apple");
	}
}