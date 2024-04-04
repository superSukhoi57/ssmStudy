package com.example.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Mapper.ikunMapper;
import com.example.pojo.修仙book;
import com.example.service.IkunService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceEnhance {
    @Autowired
    private IkunService service;

    @Test
    public void test_save(){
        List<修仙book> books=new ArrayList<>();
        修仙book book1=new 修仙book();
        book1.setState("失踪");
        book1.setName("Three-Body");
        book1.setClassnumber("5");
        book1.setNumber("6");
        book1.setTotal("-∞");

        修仙book book2=new 修仙book();
        book2.setState("被借");
        book2.setName("量子力学");
        book2.setClassnumber("7");
        book2.setNumber("68");
        book2.setTotal("+∞");


        //将他们加入列表中，为插入数据做准备
        books.add(book1);
        books.add(book2);

        //用saveBatch的service增强方法来批量插入：
        boolean s=service.saveBatch(books);
        System.out.println("Is it insert successfully?  "+s);
    }





}
