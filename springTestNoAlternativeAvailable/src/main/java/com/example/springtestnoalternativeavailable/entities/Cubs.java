package com.example.springtestnoalternativeavailable.entities;

import org.springframework.stereotype.Component;

@Component
public class Cubs implements Team{
  @Override
  public String getName() {
    return "Chicago Cubs";
  }
}
