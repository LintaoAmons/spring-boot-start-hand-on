package com.example.marketing.web;

import com.example.user.api.feign.UserFallbackFactory;
import com.example.user.api.feign.UserFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public FallbackFactory<UserFeignClient> fallbackFactory() {
        return new UserFallbackFactory();
    }
}
