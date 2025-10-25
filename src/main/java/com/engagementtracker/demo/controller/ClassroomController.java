package com.engagementtracker.demo.controller;

import com.engagementtracker.demo.DTO.ClassroomDTO;
import com.engagementtracker.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClassroomController {

    @Autowired
    private ClassroomService service;

    @PostMapping
    public ClassroomDTO create(@RequestBody ClassroomDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public ClassroomDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    public List<ClassroomDTO> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ClassroomDTO update(@PathVariable Long id , @RequestBody ClassroomDTO body){
        return service.updateClassroom(id,body);
    }

}
