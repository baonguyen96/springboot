package com.example.spring.entity;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Track {
    private int id;
    private List<String> courses;
}
