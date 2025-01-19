package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAOPAspect {
    Logger log = LoggerFactory.getLogger(AfterAOPAspect.class);

    @AfterReturning(value = "execution(* com.example.aop.repository.*.* (..))", returning="result")
    public void afterReturning(JoinPoint joinPoint, String result) {
        log.info("{} returned value {}", joinPoint, result);
    }

    @After("execution(* com.example.aop.repository.*.* (..))")
    public void after(JoinPoint joinPoint) {
        log.info("{} after execution", joinPoint);
    }
}
