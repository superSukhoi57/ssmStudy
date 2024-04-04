package com.example.ioc_01;

//静态工厂对象！就是直接调用静态函数来返回
public class staticFatory {
    private static staticFatory clientService = new staticFatory();
    private staticFatory(){}
    //这个就是静态函数！！
public static staticFatory createInstance() {
    return clientService;
    }
}