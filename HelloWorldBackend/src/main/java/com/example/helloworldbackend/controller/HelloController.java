package com.example.helloworldbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {

    @GetMapping(value = "/getHelloMessage")
    public ResponseEntity<String> getHelloMessage() {
        return new ResponseEntity<>("Hello, welcome to the world!", HttpStatus.OK);
    }
}
