package com.example.spring.controller;

import com.example.spring.entity.Student;
import com.example.spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/student/v1")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/all")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "id")
    public ResponseEntity<Student> findStudentById(@RequestParam int id) {
        Student student = studentService.findById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/students", params = "name")
    public ResponseEntity<List<Student>> findStudentByName(@RequestParam String name) {
        List<Student> students = studentService.findByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.save(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.update(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
