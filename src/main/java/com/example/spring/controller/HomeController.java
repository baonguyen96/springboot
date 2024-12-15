package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "Welcome to " + appName + " in " + activeProfile;
    }
}
