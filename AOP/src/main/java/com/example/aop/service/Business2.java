package com.example.aop.service;

import com.example.aop.aspect.TrackTime;
import com.example.aop.repository.Dao2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
    Logger logger = LoggerFactory.getLogger(Business2.class);

    @Autowired
    Dao2 dao2;

    @TrackTime
    public String calculateSomething(){
        return dao2.retrieveSomething();
    }
}
