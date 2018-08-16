package com.example.lesson13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

  @Autowired
  CategoryRepository categoryRepository;

  @Autowired
  ListRepository listRepository;

  @RequestMapping("/")
  public String index(Model model){

    // First let's create category
    Category category = new Category();
    category.setCategory("Produce");

    Category category1 = new Category();
    category1.setCategory("Frozen Food");

    // Now let's create a list
    List list = new List();
    list.setName("Orange");
    list.setQuantity(2);

    List list1 = new List();
    list1.setName("Apple");
    list1.setQuantity(5);

    List list2 = new List();
    list2.setName("Onion");
    list2.setQuantity(1);

    List list3 = new List();
    list3.setName("Vegetables");
    list3.setQuantity(2);

    List list4 = new List();
    list4.setName("Ice Cream");
    list4.setQuantity(2);

    // Add the list to an empty list
    Set<List> lists = new HashSet<List>();
    lists.add(list);
    lists.add(list1);
    lists.add(list2);

    Set<List> lists1 = new HashSet<List>();
    lists1.add(list3);
    lists1.add(list4);

    // Add the list of lists to the category's list list
    category.setLists(lists);
    category1.setLists(lists1);
    // Save the category to the database
    categoryRepository.save(category);
    categoryRepository.save(category1);

    // Grad all the actors from the database and send them to
    // the template
    model.addAttribute("grocery", categoryRepository.findAll());
    return "index";
  }
}