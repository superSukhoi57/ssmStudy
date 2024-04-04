package com.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

//实现这个接口后每当项目启动就会调用该接口的onstart方法！可以在里面进行ioc容器的初始化！
public class Main implements WebApplicationInitializer {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("项目启动，调用onStart方法！\n类路径是：");
        System.out.println(System.getProperty("java.class.path"));

    }
}