package com.example.motivation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.motivation.dto.UserNewForm;
import com.example.motivation.service.UserNewService;

@Controller
public class UserController {
  @Autowired
  private UserNewService userNewService;

  //ユーザー登録
  @GetMapping("/user/new")
  public String userNew(@ModelAttribute("form") UserNewForm form){
    return "user/newUser";
  }

  @PostMapping("/user/new")
  public String userRegistration(@Valid @ModelAttribute("form") UserNewForm form, BindingResult result){
    if(result.hasErrors()){
      return "user/newUser";
    }
    userNewService.userNew(form.getUsername(), form.getPassword());
    return "redirect:/user/login";
  }

  //ログイン
  @GetMapping("/user/login")
  public String login(){
    return "user/login";
  }
}
