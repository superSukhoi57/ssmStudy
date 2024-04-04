package com.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//TODO:整合AOP,配置切面。
@Component
@Aspect
@Order(5)
public class Aop {
    @Before("execution(* com..service.*.*(..))")
    public void  before(JoinPoint point){
        String className=point.getTarget().getClass().getSimpleName();
        String methodName=point.getSignature().getName();
        System.out.println(className+"  "+methodName);
    }
}
