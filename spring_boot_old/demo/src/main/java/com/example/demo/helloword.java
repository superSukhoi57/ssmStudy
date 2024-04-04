package com.example.demo;

public class helloword {
    public String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("setName函数被调用!!");
    }
    public void hello(){
        System.out.println(name);
    }
    public helloword(){
        System.out.println("构造函数被调用！");
    }
}
