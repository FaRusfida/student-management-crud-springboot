package com.agam.rest_example.Service;

import com.agam.rest_example.Model.Student;
import com.agam.rest_example.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @SuppressWarnings("deprecation")
    public Student getStudentById(int id) {
        return repository.getById(id);
    }

    public ResponseEntity<HttpStatus> deleteStudentById(int id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    // ✅ UPDATE STUDENT
    public Student updateStudent(int id, Student student) {

        Student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setCourse(student.getCourse());

            return repository.save(existingStudent);
        }

        return null;
    }
}