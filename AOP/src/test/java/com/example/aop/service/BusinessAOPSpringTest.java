package com.example.aop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessAOPSpringTest {
    Logger logger = LoggerFactory.getLogger(BusinessAOPSpringTest.class);

    @Autowired
    Business1 business1;

    @Autowired
    Business2 business2;

    @Test
    public void invokeAOP(){
        logger.info(business1.calculateSomething());
        logger.info(business2.calculateSomething());
    }
}
