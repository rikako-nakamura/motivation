package com.example.motivation.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Motivation implements Serializable{

  //ID
  private Long id;

  //集中したこと
  private String title;

  //集中した時間
  private String time;

  //満足度
  private String rate;

  //内容
  private String memo;
}
