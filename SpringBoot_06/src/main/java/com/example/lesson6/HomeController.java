package com.example.lesson6;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

//  You are creating routes for both GET and POST requests to the songform
//  endpoint (“/songform”). @GetMapping processes the GET requests,
//  and @PostMapping processes post requests.

  @GetMapping("/songform")
  public String loadSongForm(Model model){
    model.addAttribute("song", new Song()); //This creates an
    // ‘empty copy' of the Song class named “song”
    // which can be accessed by the songform html template
    return "songform";
  }

  @PostMapping("/songform")
  public String processSongForm(@ModelAttribute Song song, Model model){
    model.addAttribute("song", song); // a model attribute of type Song which
    // will be referred to as song in the method will be used.
    // song is a Song object containing the values that were entered by the user
    // into songform.html
    return "confirmsong";
  }

}
