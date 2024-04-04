package com.example.springboot1.myController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;

//——————————————my package—————————————

import com.example.springboot1.pojo.*;

//——————————end of my package———————————

@RestController
public class RequestController {
    //下面向外暴露的方法就是功能接口！

    /*@RequestMapping("/simpleParam")
    public String simpleParam1(HttpServletRequest request){
        String name=request.getParameter("name");
        String ageStr=request.getParameter("age");
        int age=Integer.parseInt(ageStr);//将Integer对象转化为int
        System.out.println(name+":"+age);
        return "OK";
    }*/
    @RequestMapping("/simpleParam")
    //如果想在函数里使用不同于参数参数的形参，要用@requestParam来告诉这个值要映射哪个参数！
    public String simpleParam1(@RequestParam(name = "name", required = false) String name, int age) {
        //Spring Boot的方式，不用手动转换参数类型，只要保持参数名称和形参变量名相同就行！！
        System.out.println(name + ":" + age);
        return "OK";
    }
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user.getName()+":"+user.getAge());
        return "OK-class";
    }


    //当要传递的参数一个对应多个值时，请求参数名和形参素组名称相同即可用数组接受参数！！
    @RequestMapping("/arrayParam")
    public String arrayParam(String array[]){
        System.out.println(Arrays.toString(array));
        return "OK-arrayParam!";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")LocalDateTime updateTime){
        //请求日期时间参数要注解说明前端传递来的日期格式！
        System.out.println(updateTime);
        return "OK-dateTime";
    }

}
