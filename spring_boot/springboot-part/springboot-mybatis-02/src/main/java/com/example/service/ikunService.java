package com.example.service;

import com.example.Mapper.ikunMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ikunService {
    @Autowired
    private ikunMapper heizi;

    @Transactional
    public void delete(){

        System.out.println(1/0);
    }

}
