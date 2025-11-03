package com.engagementtracker.demo.repository;

import com.engagementtracker.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can search by student name if needed:
    // Optional<Student> findByName(String name);
}
