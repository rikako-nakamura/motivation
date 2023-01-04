package com.example.motivation.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
  
  private Map<String, String> rate;

  //ラジオボタン用意
  private Map<String, String> initrate(){
    Map<String, String> radio = new LinkedHashMap<>();
    radio.put("1","🌟");
    radio.put("2","🌟🌟");
    radio.put("3","🌟🌟🌟");
    radio.put("4","🌟🌟🌟🌟");
    radio.put("5","🌟🌟🌟🌟🌟");
    return radio;
  }

  //リスト一覧を表示
  @GetMapping("/motivation/index")
  public String index(Model model) {
    List<Motivation> motivationList = motivationService.findAll(Sort.by(Sort.Direction.DESC, "rate"));
    model.addAttribute("motivationlist", motivationList);
    return "motivation/index";
  }

  //グラフを表示
  @GetMapping("/motivation/graph")
  public String graph(Model model){
    List<Motivation> motivationList = motivationService.findAll(Sort.by(Sort.Direction.DESC, "rate"));
    model.addAttribute("motivationlist", motivationList);
    return "motivation/graph";
  }

  //登録する画面を表示
  @GetMapping("/motivation/new")
    public String displayAdd(Model model){
      model.addAttribute("motivationAddRequest", new MotivationAddRequest());
      //ラジオボタン呼ぶ
      rate = initrate();
      //指定されたrateに指定されたrateを追加
      model.addAttribute("rate", rate);
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
      rate = initrate();
      model.addAttribute("rate", rate);
      return "motivation/new";
    }
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
    motivationUpdateRequest.setRate(motivation.getRate());
    motivationUpdateRequest.setMemo(motivation.getMemo());
    model.addAttribute("motivationUpdateRequest", motivationUpdateRequest);
    rate = initrate();
    model.addAttribute("rate", rate);
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
      rate = initrate();
      model.addAttribute("rate", rate);
      return "motivation/edit";
    }
    motivationService.update(motivationUpdateRequest);
    return "redirect:/motivation/index";
  }

  //削除する
  @GetMapping("/motivation/{id}/delete")
  public String delete(@PathVariable Long id, Model model){
    motivationService.delete(id);
    return "redirect:/motivation/index";
  }
}
