package com.jianke.mall.aopRedisLock;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Override
    @RedisLock(key = "aaa  #accountId")
    public String order(String accountId, String product) {
        System.out.println("用户[" + accountId + "]下单了商品[" + product + "]");
        return null;
    }

    @Override
    public boolean cancelOrder(String accountId, String ordersCode) {
        System.out.println("用户[" + accountId + "]取消了订单[" + ordersCode + "]");
        return false;
    }
}
