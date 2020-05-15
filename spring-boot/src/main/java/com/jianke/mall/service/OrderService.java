package com.jianke.mall.service;

public interface OrderService {

    String order(String accountId, String skuCode);

    Boolean cancel(String accountId, String ordersCode);
}
