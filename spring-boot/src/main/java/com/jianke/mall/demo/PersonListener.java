package com.jianke.mall.demo;

/**
 * 事件监听器
 * <p>
 * 监听Person事件源的eat和sleep⽅法
 */
interface PersonListener {

    void doEat(Event event);

    void doEat();

    void doSleep(Event event);
}