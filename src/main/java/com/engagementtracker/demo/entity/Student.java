package com.engagementtracker.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "student_class",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id"

            ),
            inverseJoinColumns = @JoinColumn(name = "class_id",
                    referencedColumnName = "id"
            )

    )
    private Set<Classroom> classes;
}
