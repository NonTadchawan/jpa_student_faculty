package com.example.student_faculty.resoure;

import com.example.student_faculty.model.Faculty;
import com.example.student_faculty.model.Student;
import com.example.student_faculty.repo.FacultyRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class FacultyResource {
    FacultyRepo repo;

    public FacultyResource(FacultyRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    List<Faculty> findAll(){
        return repo.findAll();
    }
    @GetMapping("{id}")
    Optional<Faculty> findByID(@PathVariable Integer id){
        return repo.findById(id);
    }
    @PostMapping
    void save(@RequestBody Faculty ft){
        repo.save(ft);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        repo.deleteById(id);
    }
    @PatchMapping("{id}")
    @Transactional
    void addStudent(@PathVariable Integer id, @RequestBody List<Student> st) {
        Optional<Faculty> ft = repo.findById(id);
        if (ft.isPresent()) {
            Faculty ft2 = ft.get();
            List<Student> list = ft2.getStudents();
            list.addAll(st);
        }
    }
}
