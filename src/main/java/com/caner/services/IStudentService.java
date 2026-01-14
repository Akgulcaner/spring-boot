package com.caner.services;



import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.caner.entities.Student;

@Service
public interface IStudentService  {

    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public List<Student> getStudenstByPageNo(PageRequest pageable);



}
