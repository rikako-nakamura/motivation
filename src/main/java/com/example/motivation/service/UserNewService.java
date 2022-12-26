package com.example.motivation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.motivation.dao.UserRepository;
import com.example.motivation.entity.User;

@Service
public class UserNewService {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  public void userNew(String username, String password){

    //パスワードはハッシュ化する
    String hashedPassword = passwordEncoder.encode(password);

    userRepository.saveAndFlush(new User(username, hashedPassword, "GENERAL"));

  }
}
