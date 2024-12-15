package com.example.spring.repository.impl;

import com.example.spring.entity.Student;
import com.example.spring.exception.EntityNotFoundException;
import com.example.spring.profiles.MockLocalProfile;
import com.example.spring.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MockLocalProfile
class ExternalStudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        assertEquals(3, students.size());
    }

    @Test
    void findByName() {
        List<Student> students = studentRepository.findByName("One");
        assertEquals(1, students.size());

        students = studentRepository.findByName("Random");
        assertEquals(0, students.size());
    }

    @Test
    void findById() {
        Student student = studentRepository.findById(2);
        assertEquals("Two", student.getName());
        assertNull(studentRepository.findById(0));
    }

    @Test
    void save() {
        Student student = new Student(5, "New Student", null);
        studentRepository.save(student);
        Student savedStudent = studentRepository.findById(student.getId());
        assertEquals("New Student", savedStudent.getName());
    }

    @Test
    void deleteById() {
        assertNotNull(studentRepository.findById(3));
        studentRepository.deleteById(3);
        assertNull(studentRepository.findById(3));
    }

    @Test
    void update() {
        Student student = new Student(4, "Jay", new HashMap<>(){{ put("history", 20); }});
        Student updated = studentRepository.update(student);
        assertEquals(20, updated.getCourses().get("history"));
    }

    @Test
    void update_failed() {
        Student student = new Student(40, "Jay", new HashMap<>(){{ put("history", 20); }});
        assertThrows(EntityNotFoundException.class, () -> studentRepository.update(student));
    }
}