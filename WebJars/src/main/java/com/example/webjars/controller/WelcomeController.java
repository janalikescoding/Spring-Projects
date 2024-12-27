package com.example.webjars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

  @GetMapping("/welcome")
  public String displayWelcome(){
    return "welcome";
  }
}