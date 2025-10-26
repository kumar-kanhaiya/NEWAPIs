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

    @PostMapping("/session")
    public ClassroomDTO create(@RequestBody ClassroomDTO dto){
        return service.create(dto);
    }

    @GetMapping("session/{id}")
    public ClassroomDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping("sessions")
    public List<ClassroomDTO> getAll(){
        return service.getAll();
    }

    @DeleteMapping("session/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("session/{id}")
    public ClassroomDTO update(@PathVariable Long id , @RequestBody ClassroomDTO body){
        return service.updateClassroom(id,body);
    }

}
