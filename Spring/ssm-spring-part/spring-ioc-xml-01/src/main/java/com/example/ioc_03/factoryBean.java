package com.example.ioc_03;


import org.springframework.beans.factory.FactoryBean;



//继承factoryBean工厂接口来创建容器。
public class factoryBean implements FactoryBean<javaBean> {
    @Override
    public javaBean getObject() throws Exception {
        javaBean mine=new javaBean();
        System.out.println("我已经创建好FactoryBean标准化工厂指定的类javaBean（Object类型）");
        return mine;//返回类的实例！！
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("返回.class");
        return javaBean.class;//返回类的类型！！！
        /*
        ，javaBean.class 就是 javaBean 类的 Class 对象。当你调用 getObjectType() 方法时，它会返回这个 Class 对象，
        表示这个 FactoryBean 生成的对象的类型是 javaBean。
         */
    }
}
