package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Dao.*;

@Service
public class service {

    @Autowired
    private  dao mydao;

    public void updatePrice(){
        mydao.fix();
    }
}
