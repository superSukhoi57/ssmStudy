package com.example.ioc_01;

//非静态工厂就是调用一般的方法来返回对象！！！不是static]
public class nonStaticFactory {
    private static nonStaticFactory nonstaticfactory = new nonStaticFactory();

    public nonStaticFactory createClientServiceInstance() {
        return nonstaticfactory;
    }
}