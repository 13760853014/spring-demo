package com.jianke.mall.controller;

import com.jianke.mall.config.ConfigTest;
import com.jianke.mall.service.OrderService;
import com.jianke.mall.service.OrderTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: mall-share
 * @description: ${description}
 * @author: chenguiquan
 * @create: 2019-08-12 20:23
 **/

@RestController
@RequestMapping("/svc")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderTestService orderTestService;

    @Autowired
    private ConfigTest configTest;

    @GetMapping(value = "order")
    public ResponseEntity order(@RequestParam("accountId") String accountId,
                                @RequestParam("skuCode") String skuCode) throws Exception {
        String result = orderService.order(accountId, skuCode);
        Map<String, String> map = configTest.getPostageDelivery();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "orderTest")
    public ResponseEntity order1(@RequestParam("accountId") String accountId,
                                @RequestParam("skuCode") String skuCode) throws Exception {
        String result = orderTestService.order(accountId, skuCode);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }



}
