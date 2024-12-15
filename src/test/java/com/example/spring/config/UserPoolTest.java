package com.example.spring.config;

import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.jupiter.api.Assertions.*;

@DefaultProfile
class UserPoolTest {
    @Autowired
    @Qualifier("root")
    private ServerConfig.User root;

    @Autowired
    @Qualifier("guest")
    private ServerConfig.User guest;

    @Test
    void root() {
        assertEquals("root", root.getUsername());
        assertEquals("rootpass", root.getPassword());
    }

    @Test
    void guest() {
        assertEquals("guest", guest.getUsername());
        assertEquals("guestpass", guest.getPassword());
    }
}