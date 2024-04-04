package com.example.service;

import org.springframework.stereotype.Component;

@Component
public interface Calculator {
    int add(int i,int j);
    int diff(int i,int j);
    int mul(int i,int j);
    int  div(int i, int j);
}
