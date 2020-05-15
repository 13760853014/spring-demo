package com.jianke.mall.service;

import com.alibaba.fastjson.JSON;
import com.jianke.mall.datasource.TargetDataSource;
import com.jianke.mall.entity.ActivityCoupon;
import com.jianke.mall.mapper.ActivityCouponMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ActivityCouponMapper activityCouponMapper;

    @Override
    @TargetDataSource("db2")
    public String order(String accountId, String skuCode) {
        ActivityCoupon activityCoupon = new ActivityCoupon();
        activityCoupon.setCouponName(accountId + "--dev");
        activityCouponMapper.insert(activityCoupon);
        log.info("save to dev");
        return JSON.toJSONString(activityCoupon);
    }

    @Override
    public String order1(String accountId, String skuCode) {
        ActivityCoupon activityCoupon = new ActivityCoupon();
        activityCoupon.setCouponName(accountId);
        activityCouponMapper.insert(activityCoupon);
        log.info("save to dev");
        return JSON.toJSONString(activityCoupon);
    }
}
