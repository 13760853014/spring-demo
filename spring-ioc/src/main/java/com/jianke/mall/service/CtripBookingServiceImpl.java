package com.jianke.mall.service;

import org.springframework.stereotype.Component;

@Component
public class CtripBookingServiceImpl implements BookingService {

    public CtripBookingServiceImpl() {
        System.out.println("start CtripBookingServiceImpl .....");
    }

    public void bookFlight() {
        System.out.println("携程网订机票");
    }
}
