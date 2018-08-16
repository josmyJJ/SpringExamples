package com.example.lesson15;

import javax.persistence.*;

@Entity
public class Passport {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  private long passportNumber;
  private String expirationDate;

  @OneToOne(mappedBy = "passport")
  private Person person;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(long passportNumber) {
    this.passportNumber = passportNumber;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}
