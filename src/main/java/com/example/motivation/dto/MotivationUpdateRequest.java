package com.example.motivation.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class MotivationUpdateRequest extends MotivationAddRequest implements Serializable{
  
  @NotNull
  private Long id;

}
