package com.engagementtracker.demo.service.serviceimpl;

import com.engagementtracker.demo.DTO.AttentionRecordDTO;
import com.engagementtracker.demo.entity.AttentionRecord;
import com.engagementtracker.demo.entity.Classroom;
import com.engagementtracker.demo.entity.Student;
import com.engagementtracker.demo.repository.AttentionRecordRepository;
import com.engagementtracker.demo.repository.ClassroomRepository;
import com.engagementtracker.demo.repository.StudentRepository;
import com.engagementtracker.demo.service.AttentionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionRecordServiceImpl implements AttentionRecordService {

    @Autowired
    private AttentionRecordRepository attentionRecordRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public AttentionRecordDTO uploadBatch(AttentionRecordDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(()-> new RuntimeException("Student not found"));

        Classroom classroom = classroomRepository.findById(dto.getSessionId())
                .orElseThrow(()-> new RuntimeException("Classroom not found"));

        AttentionRecord record = AttentionRecord.builder()
                .student(student)
                .session(classroom)
                .score(dto.getScore())
                .timeStamp(dto.getTimeStamp())
                .build();

        return toDTO(attentionRecordRepository.save(record));

    }

    @Override
    public AttentionRecordDTO getById(Long id) {
        return attentionRecordRepository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    @Override
    public List<AttentionRecordDTO> getAll() {
        return attentionRecordRepository.findAll()
                .stream().map(this::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        if(attentionRecordRepository.findById(id) != null){
            attentionRecordRepository.deleteById(id);
            System.out.println("Successfully deleted");
        }
        else{
            System.out.println("please enter valid id");
        }

    }

    @Override
    public List<Integer> getAllScores(Long studentId) {
        return attentionRecordRepository.findByStudent_Id(studentId)
                .stream()
                .map(AttentionRecord::getScore)
                .toList();
    }



    private AttentionRecordDTO toDTO(AttentionRecord r) {
        return AttentionRecordDTO.builder()
                .studentId(r.getStudent().getId())
                .sessionId(r.getSession().getId())
                .score(r.getScore())
                .timeStamp(r.getTimeStamp())
                .build();
    }





}
