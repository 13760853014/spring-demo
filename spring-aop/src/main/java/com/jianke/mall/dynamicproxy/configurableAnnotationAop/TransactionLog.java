package com.jianke.mall.dynamicproxy.configurableAnnotationAop;

import java.lang.annotation.*;

/**
 * Service层日志拦截注解
 * @author CGQ
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface TransactionLog {

	String value() default "";
	int type() default 1;
	
}
