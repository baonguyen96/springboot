package com.example.spring.repository.impl;

import com.example.spring.entity.Student;
import com.example.spring.repository.StudentRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile("default")
public class DefaultStudentRepository implements StudentRepository {
    private static final List<Student> students;

    static {
        students = new ArrayList<>();
        students.addAll(List.of(
                new Student(1, "John", null),
                new Student(2, "John", new HashMap<>() {{
                    put("Science", 0);
                    put("English", 10);
                }}),
                new Student(3, "Jonathan", new HashMap<>() {{
                    put("Math", 100);
                    put("English", 100);
                }}),
                new Student(4, "Jay", new HashMap<>() {{
                    put("Math", 100);
                    put("English", 100);
                }})
            )
        );
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public List<Student> findByName(String name) {
        return students.stream().filter(student -> student.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Student findById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean save(Student student) {
        return students.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}
