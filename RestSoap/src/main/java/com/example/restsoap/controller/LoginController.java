package com.example.restsoap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showLoginPage(ModelMap model){
    model.put("name","RestSoap");
    return "welcome";
  }
}
