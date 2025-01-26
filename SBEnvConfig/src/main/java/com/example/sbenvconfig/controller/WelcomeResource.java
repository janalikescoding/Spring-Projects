package com.example.sbenvconfig.controller;

import com.example.sbenvconfig.component.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeResource {
    @Value("${welcome.message}")
    private String welcomeMessage;

    @Autowired
    private BasicConfiguration basicConfiguration;

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        return welcomeMessage;
    }

    @GetMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        Map map = new HashMap();
        map.put("message", basicConfiguration.getMessage());
        map.put("number", basicConfiguration.getNumber());
        map.put("value",basicConfiguration.isValue());
        return map;
    }

}
