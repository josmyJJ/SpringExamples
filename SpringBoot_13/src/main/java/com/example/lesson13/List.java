package com.example.lesson13;

import javax.persistence.*;
import java.util.Set;

@Entity
public class List {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String name;
  private int quantity;

  @ManyToMany
  private Set<Category> cast;

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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Set<Category> getCast() {
    return cast;
  }

  public void setCast(Set<Category> cast) {
    this.cast = cast;
  }
}