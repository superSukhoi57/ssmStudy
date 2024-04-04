package com.example;


import com.example.ioc_01.HappyComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.example.ioc_02.*;
import com.example.ioc_03.*;

//容器对象的创建和使用！
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");

//————————————————————————————————————创建容器—此时里面配置的对象也被创建！！！—————————————————————————————————————
/*
//创建容器选择合适的容器实现即可!

接口
BeanFactory
ApplicationContext

实现类
可以直接通过构造函数实例化!
classesClassPathXmlAppLicationContext：读取类路径下的xml配置方式
FileSystemXmlApplicationContext ：读取指定文件位置的xml配置方式
AnnotationConfigApplicationContext： 读取配置类方式的ioc容器
WebApplicationContextweb：项目专属的配置的ioc容器
 */
        //方式1：直接创建对象并指定配置文件
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring-01.xml");


        //每次调用都会实例化对象！！！

        //方式2:先创建ioc容器对象,再指定配置文件,再刷新!
        // 源码的配置过程!创建容器[spring]和 配置文件指定分开[自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
       applicationContext1.setConfigLocations("spring-01.xml");//外部配置文件的设置
        applicationContext1.refresh();//调用ioc和di的流程，这里就是刷新，不刷新会报错！

//————————————————————————————————————获取组件——————————————————————————————————
        //通过getbean获取，返回的是object，所以要强制类型转换！
        HappyComponent happyComponent=(HappyComponent)applicationContext.getBean("happyComponent1");
        //通过bean的id获取，同时指定class！
        HappyComponent happyComponent1=applicationContext1.getBean("happyComponent2", HappyComponent.class);

        //直接通过类型获取：当一个类对应多个时会报错！也可以用接口，接口只能有一个实现类。
        //No qualifying bean of type 'com.example.ioc_01.HappyComponent' available: expected single matching bean but found 2: happyComponent1,happyComponent2
        //HappyComponent happyComponent2=applicationContext1.getBean(HappyComponent.class);


        //使用实例对象!!!
        happyComponent1.doWork();



        //————————————————————————————————钩子————————————————————————————————
        new period().show();


        //—————————————————————————————FactoryBean标准工厂方法——————————————————————
        ApplicationContext factory =new ClassPathXmlApplicationContext("spring-03.xml");
        javaBean mine= (javaBean) factory.getBean("javaBean");

    }
}

//周期函数，钩子函数！
class period{
    public void show(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        periodicMethod period=applicationContext.getBean(periodicMethod.class);
        period.show();
//析构函数不能调用，因为IOC容器非正常死亡，来不及调用析构方法！
        applicationContext.close();//这样才正常关闭！！
    }


}
