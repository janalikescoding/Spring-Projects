package com.example.spring28jdbc.model;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
  protected float hourlyWage;

  public float getHourlyWage() {
    return hourlyWage;
  }

  public void setHourlyWage(float hourlyWage) {
    this.hourlyWage = hourlyWage;
  }
}
