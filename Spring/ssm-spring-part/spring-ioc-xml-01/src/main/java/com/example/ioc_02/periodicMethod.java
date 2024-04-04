package com.example.ioc_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//它的钩子函数和BeanDefinition的作用域！！！！！！
public class periodicMethod {

    private int age;
    private String name;
    public void initialize(){
        System.out.println("在创建IOC容器时-初始化！");
    }
    public void destroy(){
        System.out.println("析构函数！销毁！");
    }
    public void show(){
        System.out.println("第二种方法创建容器，在里面指定类！！！！");
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-02.xml");
        periodicMethod one=applicationContext.getBean(periodicMethod.class);
        periodicMethod two=applicationContext.getBean("periodmethod", periodicMethod.class);
        System.out.println("scope=prototype 时两次创建的对象是不同的。");
    }
}
