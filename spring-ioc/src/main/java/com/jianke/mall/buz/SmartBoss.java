package com.jianke.mall.buz;

import com.jianke.mall.annotation.ServiceLog;
import com.jianke.mall.service.BookingService;
import com.jianke.mall.service.FlyPigBookingServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Data
@Component
public class SmartBoss {

    @Autowired
    private BookingService bookingService;

    @PostConstruct
    public void start() {
        System.out.println("开始执行：PostConstruct");
        bookingService.bookFlight();
    }


    public SmartBoss(BookingService bookingService) {
        System.out.println("start SmartBoss .....");
        this.bookingService = bookingService;
    }


    public SmartBoss() {
        System.out.println("start SmartBoss .....");
    }

    public void SetBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @ServiceLog
    public void goSomeWhere() {
        bookingService.bookFlight();
    }
}
