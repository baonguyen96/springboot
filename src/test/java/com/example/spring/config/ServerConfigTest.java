package com.example.spring.config;

import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DefaultProfile
class ServerConfigTest {
    @Autowired
    private ServerConfig serverConfig;

    @Test
    void getApplication() {
        Map<String, String> application = serverConfig.getApplication();
        assertEquals("InjectMapFromYAML", application.get("name"));
        assertEquals("https://injectmapfromyaml.dev", application.get("url"));
        assertEquals("How To Inject a map from a YAML File in Spring Boot", application.get("description"));
    }

    @Test
    void getConfig() {
        Map<String, List<String>> application = serverConfig.getConfig();
        assertEquals(4, application.get("ips").size());
        assertEquals(3, application.get("filesystem").size());
    }

    @Test
    void getUsers() {
        assertEquals(2, serverConfig.getUsers().size());
    }
}