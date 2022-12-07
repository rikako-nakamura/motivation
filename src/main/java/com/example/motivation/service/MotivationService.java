package com.example.motivation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motivation.dao.MotivationMapper;
import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.entity.Motivation;

@Service
public class MotivationService {

  @Autowired
  private MotivationMapper motivationMapper;

  public List<Motivation> findAll() {
    return motivationMapper.findAll();
  }
  public void save(MotivationAddRequest motivationAddRequest) {
    motivationMapper.save(motivationAddRequest);
  }
}
