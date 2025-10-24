package com.engagementtracker.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassroomDTO {

    private UUID id;
    private String subject;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Set<UUID> studentIds;
}
