package com.example.motivation.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.entity.Motivation;

@Mapper
public interface MotivationMapper {

  List<Motivation> findAll();

  void save(MotivationAddRequest motivationRequest);

}
