package com.example.motivation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.motivation.dao.MotivationMapper;
import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.dto.MotivationUpdateRequest;
import com.example.motivation.entity.Motivation;

@Service
public class MotivationService {

  @Autowired
  private MotivationMapper motivationMapper;

  public List<Motivation> findAll() {
    return motivationMapper.findAll();
  }

  public Motivation findById(Long id){
    return motivationMapper.findById(id);
  }
  public void save(MotivationAddRequest motivationAddRequest) {
    motivationMapper.save(motivationAddRequest);
  }

  public void update(MotivationUpdateRequest motivationUpdateRequest){
    motivationMapper.update(motivationUpdateRequest);
  }
}
