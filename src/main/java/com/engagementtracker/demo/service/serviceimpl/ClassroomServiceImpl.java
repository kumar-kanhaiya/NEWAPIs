package com.engagementtracker.demo.service.serviceimpl;

import com.engagementtracker.demo.DTO.ClassroomDTO;
import com.engagementtracker.demo.entity.Classroom;
import com.engagementtracker.demo.entity.Student;
import com.engagementtracker.demo.repository.ClassroomRepository;
import com.engagementtracker.demo.repository.StudentRepository;
import com.engagementtracker.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    private ClassroomDTO toDTO(Classroom c){
        return ClassroomDTO.builder()
                .id(c.getId())
                .subject(c.getSubject())
                .studentIds(c.getStudents().stream().map(Student::getId).collect(Collectors.toSet()))
                .build();
    }

    @Override
    public ClassroomDTO create(ClassroomDTO dto) {
        Set<Student> studentSet = dto.getStudentIds() == null ? Set.of() :
                dto.getStudentIds().stream()
                        .map(id -> studentRepository.findById(id).orElse(null))
                        .filter(s -> s != null)
                        .collect(Collectors.toSet());

        Classroom classroom = Classroom.builder()
                .students(studentSet)
                .id(dto.getId())
                .subject(dto.getSubject())
                .build();

        return toDTO(classroomRepository.save(classroom));
    }

    @Override
    public ClassroomDTO getById(Long id) {
        return classroomRepository.findById(id).map(this::toDTO)
                .orElseThrow(() ->new RuntimeException("Please enter valid id "));
    }

    @Override
    public List<ClassroomDTO> getAll() {
        return classroomRepository.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public void delete(Long id) {
        if(classroomRepository.findById(id) != null){
            classroomRepository.deleteById(id);
            System.out.println("successfully deleted");
        }
        else{
            System.out.println("Please enter valid id");
        }
    }

    @Override
    public ClassroomDTO updateClassroom(Long id, ClassroomDTO body) {
        Classroom existing = classroomRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("classroom not found "));

        if(existing.getSubject() != null && body.getSubject() != null){
            existing.setSubject(body.getSubject());
        }

        return toDTO(classroomRepository.save(existing));
    }


}
