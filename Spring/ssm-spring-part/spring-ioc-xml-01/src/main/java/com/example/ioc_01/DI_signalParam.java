package com.example.ioc_01;
//DI依赖注入，在一个类中引用另一个类！！！
class Inject{

}
public class DI_signalParam {
    private Inject di;
    int age;
    String name;
    public  DI_signalParam(Inject inject,int age){
        System.out.println("di signal parameter ");
        this.di=inject;
        this.age=age;
    }



}
