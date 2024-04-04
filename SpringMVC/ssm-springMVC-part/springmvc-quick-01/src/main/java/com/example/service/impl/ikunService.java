package com.example.service.impl;

import com.example.mapper.ikun;
import com.example.pojo.Heizi;
import com.example.service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ikunService implements service {

    @Autowired
    private  ikun ikunService;
    /*
    已经在配置类 mapperScannerConfigurer.setBasePackage("com.example.mapper");//mapper接口和mapper.xml文件所在的包
    所以大胆调用
     */
    @Override
    public Heizi find() {

        return ikunService.queryByPrice();
    }
}
