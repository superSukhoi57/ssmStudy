package com.example.controller;

import com.example.pojo.ikun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ikun")
public class ikunController {

    @Autowired
    private JdbcTemplate jdbcTemplate;//启动类的，直接时使用！
    @GetMapping("show")
    public List<ikun> show(){
        String sql="select name,price from 修仙book where price=25 or price=22;";
        List<ikun> result=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ikun.class));
        return result;
    }
}
