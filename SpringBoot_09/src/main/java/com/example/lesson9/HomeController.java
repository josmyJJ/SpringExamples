package com.example.lesson9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

  @Autowired
  ListRepository listRepository;

  @RequestMapping("/")
  public String listJobs(Model model){
    model.addAttribute("lists", listRepository.findAll());
    return "list";
  }

  @GetMapping("/add")
  public String jobForm(Model model){
    model.addAttribute("list", new List());
    return "listform";
  }

  @PostMapping("/process")
  public String processForm(@Valid List list, BindingResult result){
    if (result.hasErrors()){
      return "listform";
    }
    listRepository.save(list);
    return "redirect:/";
  }
}
