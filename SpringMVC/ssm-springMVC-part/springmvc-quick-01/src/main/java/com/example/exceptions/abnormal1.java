package com.example.exceptions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
FIXME:配置全局异常处理：
1.配置异常的handler
 */

//@RestController=@Controller+@ResponBody
@RestController
public class abnormal1 {
    @RequestMapping("nullPoint")
    public String nullPoint(){
        String str=null;
        str.toString();
        return "nullPoint exception!";
    }
    @RequestMapping("mathException")
    public String mathException(){
        int i=9;
        System.out.println(i/0);
        return  "math exception!";
    }
}
