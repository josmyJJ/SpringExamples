package com.example.lesson14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

  @Autowired
  OwnerRepository ownerRepository;

  @RequestMapping("/")
  public String index(Model model){
    // First let's create a owner
    Owner owner = new Owner();
    owner.setName("Stephen Bullock");

    // Now let's create a pet
    Pet pet = new Pet();
    pet.setName("Mia");
    pet.setAge(2);
    pet.setType("Cat");

    // Add the pet to an empty list
    Set<Pet> pets = new HashSet<Pet>();
    pets.add(pet);

    pet = new Pet();
    pet.setName("Luis");
    pet.setAge(11);
    pet.setType("Dog");
    pets.add(pet);

    // Add the list of pets to the owner's pet list
    owner.setPets(pets);

    // Save the owner to the database
    ownerRepository.save(owner);

    // Grad all the directors from the database and send them to
    // the template
    model.addAttribute("directors", ownerRepository.findAll());
    return "index";
  }
}
