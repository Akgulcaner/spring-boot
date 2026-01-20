package com.caner.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caner.controller.IHomeController;
import com.caner.dto.DtoHome;
import com.caner.services.IHomeService;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController{
    @Autowired
    private IHomeService homeService;

    @Override
    @GetMapping(path="/list/{id}")
    public DtoHome findHomeById(@PathVariable(name="id") Long id) {
        return homeService.findHomeById(id);
    }
    
}
