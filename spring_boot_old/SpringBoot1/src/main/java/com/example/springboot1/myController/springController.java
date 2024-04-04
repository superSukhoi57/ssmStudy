package com.example.springboot1.myController;

import com.example.springboot1.service.service_test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//————————————这里写自己导入的包————————————
import outerScan.*;

//————————————————这里结束————————————————


@RestController
public class springController {

    @Autowired//依赖注入，运行时IOC容器会给这个类提供Bean对象并赋值。
    private service_test propose;
    private cantScan out;
    @RequestMapping("/the_request")
    public String the_request(){
        return propose.server()+out.canScan();
    }
}
