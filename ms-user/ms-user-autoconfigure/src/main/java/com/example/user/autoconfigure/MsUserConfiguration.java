package com.example.user.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false) // TODO 这里的 proxyBeanMethods 是什么作用
@ConfigurationProperties(prefix = "cnmemset.ms-user")
public class MsUserConfiguration {
    private String url = "127.0.0.1:8888";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
