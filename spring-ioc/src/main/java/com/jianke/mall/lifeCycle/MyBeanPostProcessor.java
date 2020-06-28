package com.jianke.mall.lifeCycle;

import org.springframework.beans.BeansException;
 import org.springframework.beans.factory.config.BeanPostProcessor;  
   
 public class MyBeanPostProcessor implements BeanPostProcessor {  
   
     public MyBeanPostProcessor() {  
        super();  
        System.out.println("这是BeanPostProcessor实现类构造器！！");           
    }  
  
    @Override  
    public Object postProcessAfterInitialization(Object arg1, String arg2)
            throws BeansException {  
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");  
        return arg1;
    }  
  
    @Override  
    public Object postProcessBeforeInitialization(Object arg1, String arg2)
            throws BeansException {  
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");  
        return arg1;
    }  
}  