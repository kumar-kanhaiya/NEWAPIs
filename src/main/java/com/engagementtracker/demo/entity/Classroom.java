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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classroom_seq")
    @SequenceGenerator(name = "classroom_seq", sequenceName = "classroom_seq", allocationSize = 1)
    private Long id;

    private String subject;

    @ManyToMany(mappedBy = "classes", fetch = FetchType.LAZY)
    private Set<Student> students;
}
