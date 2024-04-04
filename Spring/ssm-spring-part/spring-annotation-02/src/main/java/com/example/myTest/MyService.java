package com.example.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    //依赖的自动织入！！
    @Autowired(required = false)//非佛系装配
    @Qualifier(value="MyDao")//当一个接口多个实现时指定类
    private  MyDao dao;
    public void autowired(){
        System.out.println("自动织入成功！");
    }
}
