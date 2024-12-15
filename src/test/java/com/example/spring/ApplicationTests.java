package com.example.spring;

import com.example.spring.config.StudentConfig;
import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DefaultProfile
@SpringBootTest
class ApplicationTests {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextLoads() {
        assertEquals("HelloWorld", applicationContext.getId());
        assertThrows(Exception.class, () -> applicationContext.getBean(StudentConfig.class));
    }
}
