package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
    Logger logger = LoggerFactory.getLogger(MethodExecutionCalculationAspect.class);

    @Around("@annotation(com.example.aop.aspect.TrackTime)")//Execute this aspect wherever the given annotation is found
    public String around(ProceedingJoinPoint joinPoint) throws Throwable { //Notice a different type of JointPoint used here
        long startTime = System.currentTimeMillis();

        String returns = (String)joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("time taken by {} is {}", joinPoint, timeTaken);
        return returns;
    }
}
