package com.example.lab2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut ("@annotation(com.example.lab2.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    @Before("executionTimeAnnotation()")
    public void beforeExecutionTime(JoinPoint joinPoint){


    }

    @After("executionTimeAnnotation()")
    public void afterExecutionTime(JoinPoint joinPoint){

    }
}
