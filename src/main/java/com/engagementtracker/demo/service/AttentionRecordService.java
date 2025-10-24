package com.engagementtracker.demo.service;

import com.engagementtracker.demo.entity.AttentionRecord;

import java.util.List;
import java.util.UUID;


public interface AttentionRecordService {

    public String uploadBatch(List<AttentionRecord> records);

    public List<AttentionRecord> getBySession(UUID sessionId);

    public List<AttentionRecord> getByStudentAndSession(UUID studentId, UUID sessionId);
}
