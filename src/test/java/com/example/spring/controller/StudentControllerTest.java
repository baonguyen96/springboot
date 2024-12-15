package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.profiles.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DefaultProfile
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Test
    void findAllStudents() {
        ResponseEntity<List<Student>> response = studentController.findAllStudents();
        assertEquals(4, Objects.requireNonNull(response.getBody()).size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findStudentById() {
        ResponseEntity<Student> response = studentController.findStudentById(4);
        assertEquals("Jay", Objects.requireNonNull(response.getBody()).getName());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void findStudentByName() {
        ResponseEntity<List<Student>> response = studentController.findStudentByName("John");
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}