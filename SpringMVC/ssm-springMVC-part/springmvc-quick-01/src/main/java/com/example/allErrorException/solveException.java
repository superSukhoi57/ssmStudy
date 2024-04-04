package com.example.allErrorException;

//TODO:全局已成发生就会走此类写的handler！并且在配置类要加到扫描注解那里！！

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice//可以返回逻辑视图，转发和重定向
@RestControllerAdvice//等于@ResponBody+#ControllerAdvice！！返回json字符串。
public class solveException {
//发生异常，就会进入到加了@ControllerAdvice的这个类中，根据指定的异常找对应的handler！
    //可以精准擦胡找异常，或者查找父异常。

    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e){
        //在里面自定义异常即可就是handler
        String message=e.getMessage();
        return message;
    }
    @ExceptionHandler(Exception.class)
    public Object Exceptions(Exception e){
        String message=e.getMessage();
        return message;
    }
}
