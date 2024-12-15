package com.example.spring.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "server")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ServerConfig {
    private Map<String, String> application;
    private Map<String, List<String>> config;
    private Map<String, User> users;

    @Setter
    @Getter
    public static class User {
        private String username;
        private String password;
    }
}
