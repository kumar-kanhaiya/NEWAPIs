package com.engagementtracker.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttentionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attention_seq")
    @SequenceGenerator(name = "attention_seq", sequenceName = "attention_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // performance optimization
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    private Classroom session;

    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private int score;

    private LocalDateTime timeStamp;
}

