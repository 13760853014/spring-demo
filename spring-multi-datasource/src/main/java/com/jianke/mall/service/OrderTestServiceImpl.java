package com.jianke.mall.service;

import com.alibaba.fastjson.JSON;
import com.jianke.mall.aopTransaction.AfterCommit;
import com.jianke.mall.entity.ActivityCoupon;
import com.jianke.mall.mapper.ActivityCouponMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OrderTestServiceImpl implements OrderTestService {

    @Autowired
    private ActivityCouponMapper activityCouponMapper;

    @Override
    @AfterCommit
    @Transactional(rollbackFor = Exception.class)
    public String order(String accountId, String skuCode) throws Exception {
        ActivityCoupon activityCoupon = new ActivityCoupon();
        activityCoupon.setCouponName(accountId + "--test");
        activityCouponMapper.insert(activityCoupon);
        if (accountId.equals("1")) {
            throw new Exception("error");
        }
        return JSON.toJSONString(activityCoupon);
    }

    @Override
    public String order1(String accountId, String skuCode) {
        ActivityCoupon activityCoupon = new ActivityCoupon();
        activityCoupon.setCouponName(accountId);
        activityCouponMapper.insert(activityCoupon);
        return JSON.toJSONString(activityCoupon);
    }
}
