package com.caner.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caner.controller.IStudentController;
import com.caner.dto.DtoStudent;
import com.caner.dto.DtoStudentIU;
import com.caner.entities.Student;
import com.caner.services.IStudentService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements  IStudentController{

    @Autowired
    private IStudentService studentService;

    @PostMapping(path="/save")    
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }

    @Override
    @GetMapping(path="/list")    
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    
    @Override
    @Transactional(readOnly=true)
    @GetMapping(path="/list/byPageNo")  
    public List<Student> getStudenstByPageNo(@RequestParam(required=false,defaultValue="1") Integer pageNo,
                                    @RequestParam(required=false,defaultValue="5") Integer pageSize,
                                    @RequestParam(required=false) String sortBy,
                                    @RequestParam(required=false) String sortDir){
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("ASC")){
            sort = Sort.by(sortBy).ascending();
        } else {
            sort = Sort.by(sortBy).descending();
        }
    return studentService.getStudenstByPageNo(PageRequest.of(pageNo-1,pageSize,sort));
    }

    @Override
    @GetMapping(path="/list/{id}")
    public DtoStudent getStudentById(@PathVariable(name="id") Integer id) {
        return studentService.getStudentById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    @DeleteMapping(path="/delete/{id}")
    public void deleteStudent(@PathVariable(name="id") Integer id) {
        studentService.deleteStudent(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    @PutMapping(path="/update/{id}")
    public DtoStudent updateStudent( @PathVariable(name="id") Integer id,@RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.updateStudent(id, dtoStudentIU);
    }



}

