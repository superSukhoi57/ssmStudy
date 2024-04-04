package com.example.config;

import com.example.controller.param;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//FIXME:初始化springmvc，springmvc的初始化类！！

//可以被web项目加载，初始化ioc容器，会设置dispatcherServlet
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //root-ioc容器配置类。就是持久层的配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceJavaConfig.class, mybatisConfig.class};
    }


    //设置项目对应的配置类!!web-ioc容器配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{configuration.class};//表示创建一个class数组，并且初始化为：里面写的东西
    }

    //配置springmvc内部自带的servlet的访问地址，“/”代表处理所有请求！dispatcherServlet拦截器配置类
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
