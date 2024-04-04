package com.example.controller;

import com.example.Mapper.ikunMapper;
import com.example.pojo.ikun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mybatis/ikun")
public class ikunController {
    @Autowired
    private ikunMapper heizi;
    @RequestMapping("show")
    public List<ikun> show(){
        return heizi.queryByPrice();
    }
}
