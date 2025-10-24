package com.engagementtracker.demo.controller;

import com.engagementtracker.demo.entity.AttentionRecord;
//import com.engagementtracker.demo.service.Service;
import com.engagementtracker.demo.service.AttentionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@Controller
@RestController
public class AttentionController {

    @Autowired
    private AttentionRecordService attentionRecordService;

    @PostMapping("/batch")
    public String uploadBatch(@RequestBody List<AttentionRecord> records) {
        return attentionRecordService.uploadBatch(records);
    }

    @GetMapping("/session/{sessionId}")
    public List<AttentionRecord> getBySession(@PathVariable UUID sessionId) {
        return attentionRecordService.getBySession(sessionId);
    }

    @GetMapping("/student/{studentId}/session/{sessionId}")
    public List<AttentionRecord> getByStudentAndSession(@PathVariable UUID studentId ,
                                                        @PathVariable UUID sessionId){
        return attentionRecordService.getByStudentAndSession(studentId , sessionId);
    }
}
