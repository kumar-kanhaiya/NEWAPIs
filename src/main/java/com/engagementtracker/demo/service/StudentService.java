package com.engagementtracker.demo.service;

import com.engagementtracker.demo.DTO.StudentDTO;
import org.springframework.stereotype.Service;


public interface StudentService {

    public StudentDTO create(StudentDTO studentDTO);
}
