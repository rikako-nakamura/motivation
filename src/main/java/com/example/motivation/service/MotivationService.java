package com.example.motivation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.motivation.dao.MotivationMapper;
import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.dto.MotivationUpdateRequest;
import com.example.motivation.entity.Motivation;

@Service
@Transactional
public class MotivationService {

  @Autowired
  private MotivationMapper motivationMapper;

  //全てのリストを返す(満足度はDESCで)
  public List<Motivation> findAll(Sort by) {
    return motivationMapper.findAll(Sort.by(Sort.Direction.DESC, "rate"));
  }

  //編集時にIdを呼び出すため
  public Motivation findById(Long id){
    return motivationMapper.findById(id);
  }

  //データを保存するため
  public void save(MotivationAddRequest motivationAddRequest) {
    motivationMapper.save(motivationAddRequest);
  }

  //データの更新時に使用
  public void update(MotivationUpdateRequest motivationUpdateRequest){
    motivationMapper.update(motivationUpdateRequest);
  }

  //削除機能
  public void delete(Long id){
    motivationMapper.delete(id);
  }

}
