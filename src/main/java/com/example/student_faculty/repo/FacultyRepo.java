package com.example.student_faculty.repo;

import com.example.student_faculty.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo extends JpaRepository <Faculty,Integer>{
}
