package com.example.motivation.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MotivationAddRequest implements Serializable {
  
  //バリデーションを追加
  @NotEmpty(message = "タイトルを入力してください")
  private String title;

  @Size(min= 1, message = "集中した時間は1以上で入力してください")
  private String time;

  private String rate;

  private String memo;

}
