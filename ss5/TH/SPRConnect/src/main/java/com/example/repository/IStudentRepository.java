package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> getAll();
    void Save(Student student);
    Student findById(Integer id);
}
