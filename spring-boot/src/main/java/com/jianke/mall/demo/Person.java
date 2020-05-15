package com.jianke.mall.demo;

public class Person {

    //在成员变量定义⼀个监听器对象
    private PersonListener personListener;

    //在事件源中定义两个⽅法
    public void Eat() {

        //当事件源调⽤了Eat⽅法时，应该触发监听器的⽅法，调⽤监听器的⽅法并把事件对象传递
        personListener.doEat();
    }

    public void sleep() {

        //当事件源调⽤了Eat⽅法时，应该触发监听器的⽅法，调⽤监听器的⽅法并把事件对象传递
        personListener.doSleep(new Event(this));
    }

    //注册监听器，该类没有监听器对象啊，那么就传递进来吧。
    public void registerLister(PersonListener personListener) {
        this.personListener = personListener;
    }

}