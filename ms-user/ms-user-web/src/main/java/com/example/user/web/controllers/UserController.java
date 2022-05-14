package com.example.user.web.controllers;

import com.example.user.api.dto.User;
import com.example.user.api.feign.UserFeignClient;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserFeignClient {
    private static final Map<Long, User> users = new HashMap<>();

    static {
        users.put(1L, new User(1, "lintao"));;
        users.put(2L, new User(2, "haha"));
    }

    @Override
    public User getUserById(long userId) {
        return users.get(userId);
    }
}
