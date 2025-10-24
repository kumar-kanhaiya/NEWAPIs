package com.engagementtracker.demo.service.serviceimpl;

import com.engagementtracker.demo.entity.AttentionRecord;
import com.engagementtracker.demo.repository.AttentionRecordRepository;
import com.engagementtracker.demo.service.AttentionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AttentionRecordServiceImpl implements AttentionRecordService {

    @Autowired
    private AttentionRecordRepository attentionRecordRepository;

    @Override
    public String uploadBatch(List<AttentionRecord> records) {
        attentionRecordRepository.saveAll(records);
        return "Saved " + records.size() + " records";
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
