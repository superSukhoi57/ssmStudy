package com.example.controller;
//TODO：方式二 springMVC整合mybatis数据库连接测试端口配置。
import com.example.pojo.Heizi;
import com.example.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ikun")//在类上加注解，要在每个handlerMapping的路径前加！
public class MybatisIkun {


    @Autowired
    private service Service;

    @RequestMapping("find")
    @ResponseBody
    public Heizi lookFor(){

        return Service.find();
    }
}
