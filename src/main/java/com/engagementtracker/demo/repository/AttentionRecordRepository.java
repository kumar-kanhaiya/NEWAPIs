package com.engagementtracker.demo.repository;

import com.engagementtracker.demo.entity.AttentionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttentionRecordRepository extends JpaRepository<AttentionRecord , Long> {
    List<AttentionRecord> findByStudent_Id(Long studentId);


}
