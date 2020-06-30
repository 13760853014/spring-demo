package com.jianke.mall.service;

public interface OrderTestService {

    String order(String accountId, String skuCode) throws Exception;

    String order1(String accountId, String skuCode);
}
