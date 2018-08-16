package com.example.lesson12;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
  @Autowired
  FoodRepository foodRepository;

  @Autowired
  CloudinaryConfig cloudc;

  @RequestMapping("/")
  public String listFood(Model model){
    model.addAttribute("allFood", foodRepository.findAll());
    return "list";
  }

  @GetMapping("/add")
  public String addFood(Model model){
    model.addAttribute("food", new Food());
    return "form";
  }

  @PostMapping("/add")
  public String processFood(@ModelAttribute Food food,
                             @RequestParam("file")MultipartFile file){
    if (file.isEmpty()){
      return "redirect:/add";
    }
    try {
      Map uploadResult =  cloudc.upload(file.getBytes(),
              ObjectUtils.asMap("resourcetype", "auto"));
      food.setFoodImage(uploadResult.get("url").toString());
      foodRepository.save(food);
    } catch (IOException e){
      e.printStackTrace();
      return "redirect:/add";
    }
    return "redirect:/";
  }
}
