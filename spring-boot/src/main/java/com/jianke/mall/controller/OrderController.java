package com.jianke.mall.controller;

import com.jianke.mall.aop.RedisLock;
import com.jianke.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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

    @GetMapping(value = "order")
    @RedisLock(key = "#accountId + ':' + #skuCode")
    public ResponseEntity order(@RequestParam("accountId") String accountId,
                                @RequestParam("skuCode") String skuCode) throws Exception {
        orderService.order(accountId, skuCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "cancelOrder")
    @RedisLock(key = "#accountId + ':' + #orderCode")
    public ResponseEntity cancelOrder(@RequestParam("accountId") String accountId,
                                @RequestParam("orderCode") String orderCode) throws Exception {
        orderService.cancel(accountId, orderCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
