package com.jianke.mall.dynamicproxy.configurableAnnotationAop;

import org.springframework.stereotype.Service;

//目标类
@Service
public class PersonServiceImpl implements PersonService {
	
	//目标方法
	@TransactionLog
	public String savePerson() {
		System.out.println("添加");
		return "返回  保存成功！";
	}
 
	//目标方法
    @TransactionLog
	public void updatePerson() {
		System.out.println("修改");
	}
 
	//目标方法
	public void deletePerson() {
		System.out.println("删除");
	}
 
}