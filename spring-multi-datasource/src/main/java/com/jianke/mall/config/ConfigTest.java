package com.jianke.mall.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mall.settlement")
public class ConfigTest {

    private Map<String, String> postageDelivery;
}
