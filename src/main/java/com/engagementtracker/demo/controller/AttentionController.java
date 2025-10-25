package com.engagementtracker.demo.controller;

import com.engagementtracker.demo.DTO.AttentionRecordDTO;
import com.engagementtracker.demo.entity.AttentionRecord;
//import com.engagementtracker.demo.service.Service;
import com.engagementtracker.demo.service.AttentionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@Controller
@RestController
public class AttentionController {

    @Autowired
    private AttentionRecordService attentionRecordService;

    @PostMapping("/")
    public AttentionRecordDTO uploadBatch(@RequestBody AttentionRecordDTO records) {
        return attentionRecordService.uploadBatch(records);
    }

    @GetMapping("/{id}")
    public AttentionRecordDTO getById(@PathVariable Long id){
        return attentionRecordService.getById(id);
    }

    @GetMapping
    public List<AttentionRecordDTO> getAll(){
        return attentionRecordService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        attentionRecordService.deleteById(id);

    }
}
