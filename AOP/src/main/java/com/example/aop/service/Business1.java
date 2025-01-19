package com.example.aop.service;

import com.example.aop.aspect.TrackTime;
import com.example.aop.repository.Dao1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {

    Logger logger = LoggerFactory.getLogger(Business1.class);

    @Autowired
    Dao1 dao1;

    @TrackTime
    public String calculateSomething(){
        return dao1.retrieveSomething();
    }
}
