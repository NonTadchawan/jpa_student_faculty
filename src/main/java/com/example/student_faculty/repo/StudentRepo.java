package com.example.student_faculty.repo;

import com.example.student_faculty.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
