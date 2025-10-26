package com.engagementtracker.demo.controller;

import com.engagementtracker.demo.DTO.StudentDTO;
import com.engagementtracker.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/student")
    public StudentDTO create(@RequestBody StudentDTO studentDTO){
       return service.create(studentDTO);
    }

    @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents(){
        return service.getAllStudents();
    }

    @PutMapping("student/{id}")
    public StudentDTO update(@PathVariable Long id , @RequestBody StudentDTO studentDTO){
        return service.update(id,studentDTO);
    }

    @DeleteMapping("student/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }



}
