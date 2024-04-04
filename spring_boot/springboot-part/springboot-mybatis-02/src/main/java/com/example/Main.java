package com.example;

import com.example.service.ikunService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.Mapper")//TODO：指定Mapper接口的位置！
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Spring Boot!!!");
        SpringApplication.run(Main.class,args);
        new ikunService().delete();
    }
}