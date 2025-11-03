package com.engagementtracker.demo.repository;

import com.engagementtracker.demo.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Optional<Classroom> findBySubject(String subject);
}
