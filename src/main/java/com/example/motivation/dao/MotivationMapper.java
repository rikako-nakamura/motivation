package com.example.motivation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.dto.MotivationUpdateRequest;
import com.example.motivation.entity.Motivation;

@Mapper
public interface MotivationMapper {

  List<Motivation> findAll();

  Motivation findById(Long id);

  void save(MotivationAddRequest motivationRequest);

  void update(MotivationUpdateRequest motivationUpdateRequest);
}
