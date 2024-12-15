package com.example.spring.service.impl;

import com.example.spring.entity.Student;
import com.example.spring.repository.StudentRepository;
import com.example.spring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<Student> findByName(String name) {
        return this.studentRepository.findByName(name);
    }

    @Override
    public Student findById(int id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        this.studentRepository.save(student);
        return this.studentRepository.findById(student.getId());
    }

    @Override
    public boolean deleteById(int id) {
        return this.studentRepository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.update(student);
    }
}
