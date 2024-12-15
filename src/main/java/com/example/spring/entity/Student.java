package com.example.spring.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    private int id;
    private String name;
    private Map<String, Integer> courses;
}
