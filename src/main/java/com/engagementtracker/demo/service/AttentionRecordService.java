package com.engagementtracker.demo.service;

import com.engagementtracker.demo.DTO.AttentionRecordDTO;

import java.util.List;


public interface AttentionRecordService {

    public AttentionRecordDTO uploadBatch(AttentionRecordDTO records);


    public AttentionRecordDTO getById(Long id);

    public List<AttentionRecordDTO> getAll();

   public void deleteById(Long id);
}
