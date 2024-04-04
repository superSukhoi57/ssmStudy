package com.example.demo;

//import org.apache.catalina.core.ApplicationContext;
//导入上面的包时ApplicationContext ctx= new ClassPathXmlApplicationContext会报错，改成下面那句就不会！
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       /* helloword say=new helloword();
        say.setName("Tony");
        //普通的使用一个对象的方法。
      */

        /*用spring来管理对象*/
        //创建spring的IOC容器对象，他会自动调用构造函数创建一个目标对象，然后调用name指定的元素。
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring_config.xml");
        //从IOC容器里获取bean实例
        helloword say=(helloword) ctx.getBean("the_id");//就是bean的id的值！！！要做强制类型转换！用id定位到IOC容器的Bean！
       // helloword say= ctx.getBean("helloword.class");    //利用类型返回IOC容器的Bean。但要求IOC中只有一个这个类型的Bean

        say.hello();

        //构造器注入

        Car car=ctx.getBean(Car.class);
        System.out.append(car.toString());
        //ref的应用

        People Tom=(People)ctx.getBean("person");
        System.out.println(Tom.see());
        //内部Bean

        People richer=(People)ctx.getBean("richer");
        System.out.println(richer.see());
    }
}
