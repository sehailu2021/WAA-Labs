package com.example.lab2.aspect;

import com.example.lab2.domain.Logger;
import com.example.lab2.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    LoggerRepo loggerRepo;

    public double timeBefore,timeAfter;
    @Pointcut ("@annotation(com.example.lab2.aspect.annotation.ExecutionTime)")
    public void executionTimeAnnotation(){
    }

    @Pointcut ("execution(* com.example.lab2.controller.*.*(..))")
    public void logger(){
    }
    @After("logger()")
    public void loggerAspect(JoinPoint joinPoint){
        Logger log1 = new Logger();
        String local =""+ LocalDateTime.now();
        String date = local.substring(0,10);
        String time= local.substring(11);
        log1.setDate(date);
        log1.setTime(time);
        log1.setOperation(joinPoint.getSignature().getName());
        log1.setPrinciple(joinPoint.getKind());
        loggerRepo.save(log1);

    }


    @Before("executionTimeAnnotation()")
    public void beforeExecutionTime(JoinPoint joinPoint){
         timeBefore= LocalDateTime.now().getNano();

    }

    @After("executionTimeAnnotation()")
    public void afterExecutionTime(JoinPoint joinPoint){
        LocalDateTime x = LocalDateTime.now();
        timeAfter = LocalDateTime.now().getNano();

    }
    @AfterReturning("executionTimeAnnotation()")
    public void duration(){
        System.out.println(timeAfter-timeBefore);

    }
}
