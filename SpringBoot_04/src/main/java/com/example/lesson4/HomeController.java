package com.example.lesson4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @RequestMapping("/loadform")
  public String loadFormPage(){
    return "form";
  }

  @RequestMapping("/processform")
  public String loadFormPage(@RequestParam("name") String login, Model model){
    model.addAttribute("loginName", login); // "loginName" is the value
    return "confirm";
  }

}
