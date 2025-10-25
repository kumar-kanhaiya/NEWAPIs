package com.engagementtracker.demo.service.serviceimpl;

import com.engagementtracker.demo.DTO.StudentDTO;
import com.engagementtracker.demo.entity.Classroom;
import com.engagementtracker.demo.entity.Student;
import com.engagementtracker.demo.repository.ClassroomRepository;
import com.engagementtracker.demo.repository.StudentRepository;
import com.engagementtracker.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;


    private StudentDTO toDTO(Student s) {
        return StudentDTO.builder()
                .id(s.getId())
                .name(s.getName())
                .classIds(s.getClasses().stream().map(Classroom::getId).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public StudentDTO create(StudentDTO dto) {
        Set<Classroom> classrooms = dto.getClassIds() == null ? Set.of() :
                dto.getClassIds().stream()
                        .map(id->classroomRepository.findById(id).orElse(null))
                        .filter(c-> c!= null)
                        .collect(Collectors.toSet());

        Student student = Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .classes(classrooms)
                .build();


        return toDTO(studentRepository.save(student));
    }




}
