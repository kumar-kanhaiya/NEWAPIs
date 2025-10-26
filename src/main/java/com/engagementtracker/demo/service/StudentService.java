package com.engagementtracker.demo.service;

import com.engagementtracker.demo.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    public StudentDTO create(StudentDTO studentDTO);

    public StudentDTO getStudentById(Long id);

    public List<StudentDTO> getAllStudents();

    public StudentDTO update(Long id, StudentDTO studentDTO);

    public void deleteById(Long id);
}
