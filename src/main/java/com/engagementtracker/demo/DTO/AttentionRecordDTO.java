package com.engagementtracker.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttentionRecordDTO {

    private Long id;
    private UUID studentId;
    private String studentName;
    private UUID sessionId;
    private String subject;
    private int score;
    private LocalDateTime timeStamp;
}
