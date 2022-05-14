package com.example.user.api.feign;

import com.example.user.api.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "ms-user", url = "${cnmemset.ms-user.url:127.0.0.1:8080}",
        fallbackFactory = UserFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/get/{userId}")
    // TODO: 这个 responseBody 加在这里有什么用
    @ResponseBody
    User getUserById(@PathVariable("userId") long userId);

}
