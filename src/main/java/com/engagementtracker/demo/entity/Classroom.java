package com.engagementtracker.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String subject;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToMany(mappedBy = "classes")
    private Set<Student> student;
}
