package com.example.motivation.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthorizationTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  public void accessWithNoAuthentication() throws Exception{
    mockMvc.perform(get("/motivation/index"))
          .andExpect(status().isFound());
  }

  @Test
  @WithMockUser
  public void accessWithUserHasNotRole() throws Exception{
    mockMvc.perform(get("/motivation/index"))
          .andExpect(status().isOk());
  }

}
