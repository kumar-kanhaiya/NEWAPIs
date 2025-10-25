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
import java.util.UUID;

@Service
public class AttentionRecordServiceImpl implements AttentionRecordService {

    @Autowired
    private AttentionRecordRepository attentionRecordRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public String uploadBatch(AttentionRecordDTO dto) {
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

        attentionRecordRepository.save(record);

        return "Succefully insert ";

    }

    @Override
    public List<AttentionRecord> getBySession(UUID sessionId) {
        return attentionRecordRepository.findBySessionId(sessionId);
    }

    @Override
    public List<AttentionRecord> getByStudentAndSession(UUID studentId, UUID sessionId) {
        return attentionRecordRepository.findByStudentIdAndSessionId(studentId,sessionId);
    }

}
