package com.caner.services;



import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.caner.dto.DtoStudent;
import com.caner.dto.DtoStudentIU;
import com.caner.entities.Student;

@Service
public interface IStudentService  {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public List<Student> getStudenstByPageNo(PageRequest pageable);
    public DtoStudent getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);

}
