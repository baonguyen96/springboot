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
public class Student implements Cloneable {
    private int id;
    private String name;
    private Map<String, Integer> courses;

    @Override
    public Student clone() {
        try {
            return (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
