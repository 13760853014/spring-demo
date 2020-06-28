package com.jianke.mall;

import com.jianke.mall.buz.SmartBoss;
import com.jianke.mall.service.BookingService;
import com.jianke.mall.service.FlyPigBookingServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Objects;

@Configuration
@ComponentScan
public class SpringIocAppliaction {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SpringIocAppliaction.class);
        SmartBoss boss = context.getBean(SmartBoss.class);
        boss.goSomeWhere();
    }

//    @Bean
//    public BookingService flyPigBookingServiceImpl11() {
//        return new FlyPigBookingServiceImpl();
//    }


}
