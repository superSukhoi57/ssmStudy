package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//加了这个注解就代表这个类是启动类，运行工程的入口！！
/*
    这个类是一个整合的注解，包含1.配置类@SpringBootConfigur；
    2.EnableAutoConfiguration自动加载其他配置类；
    3.@ComponentScan默认扫描当前类所在的包和子包。

 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class,args);//自动创建ioc容器，启动tomcat服务器。
    }
}