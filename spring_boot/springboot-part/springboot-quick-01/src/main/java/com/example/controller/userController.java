package com.example.controller;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class userController {
    @Autowired
    private User user;
    @GetMapping("show")
    public User user(){
        return user;
    }
}
