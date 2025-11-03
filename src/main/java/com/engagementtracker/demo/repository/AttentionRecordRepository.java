package com.engagementtracker.demo.repository;

import com.engagementtracker.demo.entity.AttentionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttentionRecordRepository extends JpaRepository<AttentionRecord, Long> {
}
