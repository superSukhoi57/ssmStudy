package com.example.myTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//注解配置组件t，id默认值为类名而且首字母你小写。
public class Mycomponent {
    @PostConstruct
    public void run(){
        System.out.println("使用注解配置成功！");
    }
}
