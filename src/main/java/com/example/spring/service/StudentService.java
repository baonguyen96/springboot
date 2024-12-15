package com.example.spring.service;

import com.example.spring.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    List<Student> findByName(String name);
    Student findById(int id);
    Student save(Student student);
    boolean deleteById(int id);
    Student update(Student student);
}
