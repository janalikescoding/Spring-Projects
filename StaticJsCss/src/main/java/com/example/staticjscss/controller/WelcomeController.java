package com.example.staticjscss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

  @GetMapping(path={"/","/welcome"})
  public String displayWelcome(){
    return "welcome";
  }

//  @GetMapping("/error")
//  public String errorPage(){
//    return "error";
//  }
}
