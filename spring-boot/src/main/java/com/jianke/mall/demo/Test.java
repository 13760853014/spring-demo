package com.jianke.mall.demo;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        //注册监听器()
        person.registerLister(new PersonListener() {
            @Override
            public void doEat(Event event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在吃饭呢！");
            }

            @Override
            public void doEat() {
                System.out.println("ttttt  正在吃饭呢！");
            }
            @Override
            public void doSleep(Event event) {
                Person person1 = event.getResource();
                System.out.println(person1 + "正在睡觉呢！");
            }
        });
        person.Eat();
    }
}
