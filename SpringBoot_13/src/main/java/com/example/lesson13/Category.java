package com.example.lesson13;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String category;

  @ManyToMany(mappedBy = "cast")
  private Set<List> lists;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Set<List> getLists() {
    return lists;
  }

  public void setLists(Set<List> lists) {
    this.lists = lists;
  }
}


