package com.engagementtracker.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttentionRecordDTO {

    private Long id;
    private Long studentId;
    private Long sessionId;
    private int score;
    private LocalDateTime timeStamp;
}
