package com.example.lab2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Pointcut("@annotation(com.example.lab2.aspect.annotation.LogMe)")
    public void logMeAnnotation(){
    }
    @Pointcut("execution(* com.example.lab2.controller.*.*(..)) ")
    public void logMe(){
    }
    @Before("logMe() || logMeAnnotation()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before the method:" +joinPoint.getSignature().getName());
    }

    @After("logMe()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Log After the method:" +joinPoint.getSignature().getName());
    }
    @AfterReturning("logMe()")
    public void logAfterReturning(JoinPoint joinPoint){
        System.out.println("Log AfterReturning the method:" +joinPoint.getSignature().getName());
    }
    @AfterThrowing("logMe()")
    public void logAfterThrowing(JoinPoint joinPoint){
        System.out.println("Log AfterThrowing the method:" +joinPoint.getSignature().getName());
    }

    @Around("logMe()")
    public void logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Log Around the method:" +proceedingJoinPoint.getSignature().getName());
    }

}
