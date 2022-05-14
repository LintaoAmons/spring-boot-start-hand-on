package com.example.marketing.web.controllers;

import com.example.user.api.dto.User;
import com.example.user.api.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final UserFeignClient userFeignClient;

    @Autowired
    public GreetingController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/hello/{userId}")
    public String sayHi(@PathVariable("userId") long userId) {
        User user = userFeignClient.getUserById(userId);

        if (user == null || !StringUtils.hasLength(user.getName())) {
            return "Hello, 匿名者";
        }

        return "Hello, " + user.getName();
    }
}
