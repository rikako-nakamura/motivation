package com.example.motivation.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Motivation implements Serializable{

  //ID
  private Long id;

  //集中したこと
  public String title;

  //集中した時間
  private String time;

  //満足度
  public String rate;

  //内容
  private String memo;

  //作成日時
  private Date createDate;
}
