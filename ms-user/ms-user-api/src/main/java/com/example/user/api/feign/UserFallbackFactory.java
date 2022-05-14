package com.example.user.api.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackFactory implements FallbackFactory<UserFeignClient> {
    private final Logger logger = LoggerFactory.getLogger(UserFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return userId -> {
            logger.error("Error occurred when call ms-user", cause);
            return null;
        };
    }
}
