package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserPool {
    private ServerConfig serverConfig;

    public UserPool(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }

    @Bean("root")
    public ServerConfig.User root() {
        return this.serverConfig.getUsers().get("root");
    }

    @Bean("guest")
    public ServerConfig.User guest() {
        return this.serverConfig.getUsers().get("guest");
    }
}
