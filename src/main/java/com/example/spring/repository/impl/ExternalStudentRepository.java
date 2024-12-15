package com.example.spring.repository.impl;

import com.example.spring.config.StudentConfig;
import com.example.spring.entity.Student;
import com.example.spring.exception.EntityNotFoundException;
import com.example.spring.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("!default")
public class ExternalStudentRepository implements StudentRepository {
    private final StudentConfig studentConfig;

    public ExternalStudentRepository(StudentConfig studentConfig) {
        this.studentConfig = studentConfig;
    }

    @Override
    public List<Student> findAll() {
        return studentConfig.getStudents();
    }

    @Override
    public List<Student> findByName(String name) {
        return studentConfig.getStudents().stream().filter(student -> student.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Student findById(int id) {
        return studentConfig.getStudents().stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean save(Student student) {
        return studentConfig.getStudents().add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentConfig.getStudents().removeIf(student -> student.getId() == id);
    }

    @Override
    public Student update(Student student) {
        if (findById(student.getId()) == null) {
            throw new EntityNotFoundException("Cannot find student " + student);
        }

        return StudentRepository.super.update(student);
    }
}
