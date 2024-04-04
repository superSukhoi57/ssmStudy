package com.example.springboot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//————————————这里写自己导入的包————————————


//————————————————这里结束————————————————


//java的启动类————用来启动springboot的入口

@ComponentScan({"outerScan","com.example.springboot1"})
//这是一个指定IOC去哪里扫描Bean的注解。
// 如果在这里写了下面的默认注解就会失效，所以除了要指定其他包，默认原来的包也要写的进去！

@SpringBootApplication
//里面包含ComponentScan，默认扫描当前包及其子包。（在这里就是指com.emample.springboot1这个包和它的子包！）
public class SpringBoot1Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringBoot1Application.class, args);

    }

}
