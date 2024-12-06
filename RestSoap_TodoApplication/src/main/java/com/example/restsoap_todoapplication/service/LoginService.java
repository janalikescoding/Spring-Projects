package com.example.restsoap_todoapplication.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

  public boolean validateUser(String name, String password){
    return "user".equalsIgnoreCase(name) && "password".equalsIgnoreCase(password);
  }
}
