package com.engagementtracker.demo.controller;

import com.engagementtracker.demo.DTO.StudentDTO;
import com.engagementtracker.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDTO create(@RequestBody StudentDTO studentDTO){
       return service.create(studentDTO);
    }

}
