package com.example.motivation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class MotivationControllerTest {
  
  @Autowired
  private MockMvc mockmvc;

  @Test
  void init処理が走って200が返る() throws Exception{
    mockmvc.perform(
      MockMvcRequestBuilders.get("/user/new")
    )
    .andExpect(MockMvcResultMatchers.status().isOk());

    mockmvc.perform(
      MockMvcRequestBuilders.get("/user/login")
    )
    .andExpect(MockMvcResultMatchers.status().isOk());
/* 
    mockmvc.perform(
      MockMvcRequestBuilders.get("/motivation/index")
    )
    .andExpect(MockMvcResultMatchers.status().isOk());

    mockmvc.perform(
      MockMvcRequestBuilders.get("/motivation/graph")
    )
    .andExpect(MockMvcResultMatchers.status().isOk());

    mockmvc.perform(
      MockMvcRequestBuilders.get("/motivation/new")
    )
    .andExpect(MockMvcResultMatchers.status().isOk());
    */
  }

}
