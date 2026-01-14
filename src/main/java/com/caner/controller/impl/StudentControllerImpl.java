package com.caner.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caner.controller.IStudentController;
import com.caner.entities.Student;
import com.caner.services.IStudentService;




@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements  IStudentController{

    @Autowired
    private IStudentService studentService;

    @PostMapping(path="/save")    
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @Override
    @GetMapping(path="/list")    
    public List<Student> getAllStudents() {
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



}

