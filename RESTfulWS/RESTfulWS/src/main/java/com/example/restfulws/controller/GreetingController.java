package com.example.restfulws.controller;

import com.example.restfulws.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController // Difference between traditional MVC controller and REST controller is that it does not rely on a view technology to perform server-side rendering of data to HTML, RESTful web service controller returns a Greeting object which is written directly to HTTP response as JSON.
public class GreetingController {

  private static final String template = "Hello %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }



}
