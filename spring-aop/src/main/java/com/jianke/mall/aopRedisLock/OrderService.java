package com.jianke.mall.aopRedisLock;

public interface OrderService {

    String order(String accountId, String product);

    boolean cancelOrder(String accountId, String ordersCode);
}
