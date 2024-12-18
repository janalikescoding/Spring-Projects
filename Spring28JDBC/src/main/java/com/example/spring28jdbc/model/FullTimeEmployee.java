package com.example.spring28jdbc.model;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
  protected Integer salary;

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }
}
