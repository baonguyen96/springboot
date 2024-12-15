package com.example.spring.controller;

import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@DefaultProfile
class HomeControllerTest {
    @Autowired
    private HomeController homeController;

    @Test
    void home() {
        assertEquals("Welcome to HelloWorld in ", homeController.home());
    }
}