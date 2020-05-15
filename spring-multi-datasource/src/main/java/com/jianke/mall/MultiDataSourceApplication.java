package com.jianke.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.jianke.mall.mapper")
public class MultiDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class, args);
    }
}
