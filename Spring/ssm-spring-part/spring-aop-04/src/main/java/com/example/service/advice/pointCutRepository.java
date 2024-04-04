package com.example.service.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class pointCutRepository {
    @Pointcut("execution(* com.example.service.imp.*.*(..))")
    public void repoPc(){}
}
