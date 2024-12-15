package com.example.spring.repository;

import com.example.spring.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    List<Student> findByName(String name);

    Student findById(int id);

    boolean save(Student student);

    boolean deleteById(int id);

    default Student update(Student student) {
        Student old = findById(student.getId());
        old = student.clone();
        return findById(student.getId());
    }
}
