package com.example.motivation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.motivation.dto.MotivationAddRequest;
import com.example.motivation.dto.MotivationUpdateRequest;
import com.example.motivation.entity.Motivation;
import com.example.motivation.service.MotivationService;

@Controller
public class MotivationController {

  @Autowired
  private MotivationService motivationService;
  
  //リスト一覧を表示
  @GetMapping(value = "/motivation/index")
  public String index(Model model) {
    List<Motivation> motivationList = motivationService.findAll();
    model.addAttribute("motivationlist", motivationList);
    return "motivation/index";
  }

  //登録する画面を表示
  @GetMapping(value = "/motivation/new")
    public String displayAdd(Model model) {
      model.addAttribute("motivationAddRequest", new MotivationAddRequest());
      return "motivation/new";
    }

  //登録する
  @RequestMapping(value = "/motivation/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute MotivationAddRequest motivationRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "motivation/new";
    }
    // リストの登録
    motivationService.save(motivationRequest);
    return "redirect:/motivation/index";
  }

  //編集する画面を表示
  @GetMapping("/motivation/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model){
    Motivation motivation = motivationService.findById(id);
    MotivationUpdateRequest motivationUpdateRequest = new MotivationUpdateRequest();
    motivationUpdateRequest.setId(motivation.getId());
    motivationUpdateRequest.setTitle(motivation.getTitle());
    motivationUpdateRequest.setTime(motivation.getTime());
    motivationUpdateRequest.setMemo(motivation.getMemo());
    model.addAttribute("motivationUpdateRequest", motivationUpdateRequest);
    return "motivation/edit";
  }

  //編集する
  @RequestMapping(value = "/motivation/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute MotivationUpdateRequest motivationUpdateRequest, BindingResult result, Model model){
    if(result.hasErrors()){
      List<String> errorList = new ArrayList<String>();
      for(ObjectError error : result.getAllErrors()){
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "motivation/edit";
    }
    motivationService.update(motivationUpdateRequest);
    return "redirect:/motivation/index";
  }
}
