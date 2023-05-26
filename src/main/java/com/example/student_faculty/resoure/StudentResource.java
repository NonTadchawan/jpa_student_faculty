package com.example.student_faculty.resoure;

import com.example.student_faculty.model.Student;
import com.example.student_faculty.repo.StudentRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentResource {
    StudentRepo repo;

    public StudentResource(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Student> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC,"grad"));
    }
    @GetMapping("{id}")
    Optional<Student> findById(@PathVariable Integer id){
        return repo.findById(id);
    }
    @PostMapping
    void save(@RequestBody Student st){
        repo.save(st);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
