package com.caner.controller;

import java.util.List;

import com.caner.dto.DtoStudent;
import com.caner.dto.DtoStudentIU;
import com.caner.entities.Student;

public interface IStudentController {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    List<Student> getStudenstByPageNo(Integer pageNo, Integer pageSize,String sortBy,String sortDir);
    public DtoStudent getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU);
}
