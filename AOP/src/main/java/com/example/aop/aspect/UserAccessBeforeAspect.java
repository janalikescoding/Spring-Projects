package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessBeforeAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.aop.repository.*.*(..))")
    public void before(JoinPoint joinPoint) {
        logger.info("Check user access");
        logger.info("Allowed execution for {}",joinPoint);
    }
}
