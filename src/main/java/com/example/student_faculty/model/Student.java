package com.example.student_faculty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderBy;

import java.util.Objects;

@Entity
public class Student {
    @Id
    private Integer id;
    private String name;

    private Double grad;
    @ManyToOne
    private Faculty faculty;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Integer id, String name, Faculty faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }


    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrad() {
        return grad;
    }

    public void setGrad(Double grad) {
        this.grad = grad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
