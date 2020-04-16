package com.jianke.mall.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 操作日志记录切点类
 * @author CGQ
 */
@Aspect
@Component
public class LogAspect {

	// Service层切点
	@Pointcut("@annotation(com.jianke.mall.annotation.ServiceLog)")
	public void serviceAspect() {
	}
	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint 切点
	 */
	@Before("serviceAspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("注解类型前置通知");
		getLog(joinPoint, null);
	}


	public void getLog(JoinPoint joinPoint, Throwable e) {
		System.out.println("start log:" + joinPoint.getSignature().getName());
		System.out.println("end log:" + joinPoint.getSignature().getName());
	}

}