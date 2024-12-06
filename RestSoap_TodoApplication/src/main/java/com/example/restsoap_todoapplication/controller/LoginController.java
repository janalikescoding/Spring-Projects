package com.example.restsoap_todoapplication.controller;

import com.example.restsoap_todoapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") //The model attributes which are stored in the session
public class LoginController {

  @Autowired
  LoginService loginService;

  @RequestMapping(path = {"","/","/login"}, method = RequestMethod.GET)
  public String loginPage(ModelMap modelMap){ //ModelMap is shared across the application (?)
    return "login";
  }

  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public String validateLogin(ModelMap modelMap, @RequestParam String name, @RequestParam String password){
    boolean valid = loginService.validateUser(name, password);
    if(!valid){
      modelMap.put("error", "Authentication Failed");
      return "login";
    }

    modelMap.put("name", name);
    modelMap.put("password", password);

    return "welcome";
  }
}
