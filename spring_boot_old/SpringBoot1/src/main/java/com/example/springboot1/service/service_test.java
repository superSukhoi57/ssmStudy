package com.example.springboot1.service;

import org.springframework.stereotype.Component;

@Component//表示将当前类交给IOC容器管理！成为IOC容器的Bean
public class service_test {
    private String str;
    public String server(){
        System.out.println("Hello!How can I help you?");
        return "Please wait!";
    }
}
