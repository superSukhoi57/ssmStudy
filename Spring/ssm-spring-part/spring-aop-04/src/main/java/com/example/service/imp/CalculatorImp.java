package com.example.service.imp;

import com.example.service.Calculator;
import org.springframework.stereotype.Component;

/*
AOP只针对ioc容器对象！创建代理对象并将代理对象储存到IOC容器。
 */
@Component
public class CalculatorImp implements Calculator {
    @Override
    public int add(int i, int j) {

        return i+j;
    }

    @Override
    public int diff(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
