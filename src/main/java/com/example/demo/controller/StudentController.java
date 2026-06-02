package com.example.demo.controller;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private Map<Long, Student> studentDB = new HashMap<>();

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        studentDB.put(student.getId(), student);
        return student;
    }

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentDB.values();
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentDB.remove(id);
        return "Student deleted";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentDB.put(id, student);
        return student;
    }
}
