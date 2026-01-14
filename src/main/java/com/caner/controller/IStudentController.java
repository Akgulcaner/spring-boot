package com.caner.controller;

import java.util.List;

import com.caner.entities.Student;

public interface IStudentController {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    List<Student> getStudenstByPageNo(Integer pageNo, Integer pageSize,String sortBy,String sortDir);
}
