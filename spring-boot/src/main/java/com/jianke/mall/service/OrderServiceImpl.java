package com.jianke.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public String order(String accountId, String skuCode) {
        log.info("用户[" + accountId + "]下单了商品[" + skuCode + "]");
        return null;
    }

    @Override
    public Boolean cancel(String accountId, String ordersCode) {
        log.info("用户[" + accountId + "]取消了订单[" + ordersCode + "]");
        return null;
    }
}
