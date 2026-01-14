package com.caner.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.caner.entities.Student;
import com.caner.repository.StudentRepository;
import com.caner.services.IStudentService;


@Service
public class StudentServiceImpl implements  IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public List<Student> getStudenstByPageNo(PageRequest pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

}
