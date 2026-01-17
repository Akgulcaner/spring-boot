package com.caner.services.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.caner.dto.DtoStudent;
import com.caner.dto.DtoStudentIU;
import com.caner.entities.Student;
import com.caner.repository.StudentRepository;
import com.caner.services.IStudentService;


@Service
public class StudentServiceImpl implements  IStudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllActiveStudents();
        for (Student student : studentList) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student, dto);
            dtoStudentList.add(dto);
        }
        return dtoStudentList;
    }

    @Override
    public List<Student> getStudenstByPageNo(PageRequest pageable) {
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            Student dbStudent = optional.get();
            BeanUtils.copyProperties(dbStudent, dto);
        }
        return dto;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.softDelete(id);
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> optional = studentRepository.findById(id);
        DtoStudent dto = new DtoStudent();
        if(optional.isPresent()){
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setAge(dtoStudentIU.getAge());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());
            dbStudent.setPassword(dtoStudentIU.getPassword());
            Student updatedStudent =  studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, dto);
            return dto;
        }
        return null;
    }

}
