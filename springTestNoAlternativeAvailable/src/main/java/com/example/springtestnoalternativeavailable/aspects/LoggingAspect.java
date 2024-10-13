package com.example.springtestnoalternativeavailable.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect //Signals that this is an Aspect
@Component //Turn on component scan so that its easier to detect the bean
public class LoggingAspect {
  private Logger logger = Logger.getLogger(getClass().getName());

//  @Before("execution(void com.example..*.set*(*))") //AspectJ Pointcut expression language. Meaning in this instance: Before setter is called do the following 'execution' - apply this aspect to all setter methods with 0 arguments and void return in com.example package, before they are called.
//  //*represents, .. represents any number of arguments, .. after com.example denotes the class/method can be nested however deep, * (other than at argument) is a wildcard. execution - execution designator, there are others as well.
//  //execution - pointcut designator
//  public void callSetters(JoinPoint jointPoint){
//    String method = jointPoint.getSignature().getName();
//    String arg = jointPoint.getArgs()[0].toString();
//    logger.info("Called method " + method + " with arg " + arg + " on " + jointPoint.getTarget());
//  }
//}

@Around("execution(String playGame())")
public Object checkForRain(ProceedingJoinPoint pjp) throws Throwable {
    boolean rain = Math.random() < 0.5;
    Object result = null;
    if(rain){
      logger.info(pjp.getTarget() + " rained out");
    } else {
      result = pjp.proceed();
      logger.info(result.toString());
    }
    return result;
  }
}

//Types of advice
//Before - do this before calling the (?)pointcut
//After Returning - After there is a successful return from the method, execute the (?)advice
//After Throwing - Only when there is an exception thrown (eg. doRecoveryActions). Also, can use throwing keyword to "catch" the exception.
//After - Execute the aspect regardless of the PointCut "output"
//Around - before or after or does it execute at all? (eg. security, transaction operations, etc.) (Argument - ProceedingJointPoint). Use "ProceedingJointPoint.proceed()" for pre-processing, post-processing and PointCut returns' execution

//Around - only kind of aspect(called aspect because, in this case imagine the around advice applied to the PointCut(?)) which lets you decide if you can go ahead with an operation or not


//Remember:
//Joinpoints are options on the menu and Pointcuts are items you select.
// A Joinpoint is an opportunity within code for you to apply an aspect...just an opportunity. Once you take that opportunity and select one or more Joinpoints and apply an aspect to them, you've got a Pointcut.

//Also remember:
//A Joinpoint is a point in the control flow of a program where the control flow can arrive via two different paths(IMO : that's why call joint).
//Advice describes a class of functions which modify other functions
//A Pointcut is a matching Pattern of Joinpoint i.e. set of join points.

//Downside to AOP - difficult to see what methods are being invoked. We have IDE support, but without it and just by looking at the RunDemo, we can't see what methods are invoked or how many aspects are applied.
