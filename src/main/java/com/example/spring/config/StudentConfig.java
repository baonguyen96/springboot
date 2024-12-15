package com.example.spring.config;

import com.example.spring.entity.Student;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("!default")
@ConfigurationProperties(prefix = "students-config")
@Getter
public class StudentConfig {
    private final List<Student> students;

    public StudentConfig(List<Student> students) {
        this.students = students;
    }
}
