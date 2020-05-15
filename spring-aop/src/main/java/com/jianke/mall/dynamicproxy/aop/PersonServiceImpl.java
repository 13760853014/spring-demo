package com.jianke.mall.dynamicproxy.aop;

public class PersonServiceImpl implements PersonService{
 
	@Override
	public String savePerson() {
		System.out.println("添加");
		return "返回： 保存成功！";
	}
 
	@Override
	public void updatePerson() {
		System.out.println("修改");
	}
 
	@Override
	public void deletePerson() {
		System.out.println("删除");
	}
 
}