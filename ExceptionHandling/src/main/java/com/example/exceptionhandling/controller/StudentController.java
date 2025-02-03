package com.example.exceptionhandling.controller;

import com.example.exceptionhandling.exception.StudentNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @GetMapping("/students/{id}")
    public Object retrieveStudent(@PathVariable int id) {
        throw new StudentNotFoundException("Student Not Found");
    }
}
