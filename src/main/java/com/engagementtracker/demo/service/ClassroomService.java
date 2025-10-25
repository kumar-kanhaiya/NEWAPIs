package com.engagementtracker.demo.service;

import com.engagementtracker.demo.DTO.ClassroomDTO;

import java.util.List;


public interface ClassroomService {

    public ClassroomDTO create(ClassroomDTO dto);

    public ClassroomDTO getById(Long id);

    public List<ClassroomDTO> getAll();

    public void delete(Long id);

    public ClassroomDTO updateClassroom(Long id, ClassroomDTO body);
}
