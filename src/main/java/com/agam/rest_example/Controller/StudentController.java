package com.agam.rest_example.Controller;

import com.agam.rest_example.Model.Student;
import com.agam.rest_example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Get all students
    @GetMapping("/get-all")
    public List<Student> getStudents() {
        return service.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    // Add new student
    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // UPDATE student
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int id) {
        return service.deleteStudentById(id);
    }
}