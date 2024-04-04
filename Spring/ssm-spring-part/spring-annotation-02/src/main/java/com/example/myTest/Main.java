package com.example.myTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
       ApplicationContext applicationContext=new ClassPathXmlApplicationContext("scan.xml");
        Mycomponent component= (Mycomponent) applicationContext.getBean(Mycomponent.class);
    }
}
