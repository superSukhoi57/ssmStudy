package com.example.controller;


//TODO:在启动类所在包及其子包下的controller就会被自动扫描。

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//=ResponBody+@Controller
@RequestMapping("first")
public class firstController {
    @GetMapping("hello")
    public String hello(){
        return "Hello springBoot3.18!";
    }
}
