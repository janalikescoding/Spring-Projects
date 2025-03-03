package com.example.calculatorbackend.controller;

import com.example.calculatorbackend.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OperationsController {

    @Autowired
    OperationsService service;

    @GetMapping("/add")
    public double add(@RequestParam double a,@RequestParam double b) {
        return service.add(a,b);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double a,@RequestParam double b) {
        return service.subtract(a,b);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double a,@RequestParam double b) {
        return service.multiply(a,b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a,@RequestParam double b) {
        return service.divide(a,b);
    }
}
