package com.example.lesson15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @Autowired
  PersonRepository personRepository;

  @RequestMapping("/")
  public String index(Model model){
    // First let's create an person
    Person person = new Person();
    person.setName("Stephen Bullock");
    person.setSsn("555-12-1234");

    // Now let's create a passport
    Passport passport = new Passport();
    passport.setPassportNumber(786756556);
    passport.setName("Davide Hills");
    passport.setExpirationDate("12-4-2020");


    // Add the passport to the person
    person.setPassport(passport);

    // Save the person to the database
    personRepository.save(person);

    // Grab all the employees from the database and send them to
    // the template
    model.addAttribute("persons", personRepository.findAll());
    return "index";
  }
}