package com.example.springtestnoalternativeavailable.entities;

import org.springframework.stereotype.Component;

@Component
public class Royals implements Team{

  @Override
  public String getName() {
    return "Kansas City Royals";
  }
}
