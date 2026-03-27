package com.agam.rest_example.Repository;

import com.agam.rest_example.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
