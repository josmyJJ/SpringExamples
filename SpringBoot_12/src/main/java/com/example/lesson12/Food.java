package com.example.lesson12;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private String cuisine;

  private String description;

  private String foodImage;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCuisine() {
    return cuisine;
  }

  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFoodImage() {
    return foodImage;
  }

  public void setFoodImage(String foodImage) {
    this.foodImage = foodImage;
  }
}