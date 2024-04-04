package com.example.springboot1.myController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//请求处理类的注解！
public class sayHello {
@RequestMapping("/hello")//处理的请求路径！
    public String say(){
        System.out.println("Hello word!");
        return "Hello word!";

    }
}
