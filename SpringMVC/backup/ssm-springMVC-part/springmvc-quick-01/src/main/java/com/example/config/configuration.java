package com.example.config;

import com.example.Filter.interceptor;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;





/*
1.service
2.开启aop注解的支持 aspect : @Before @After @AfterReturning @AfterThrowing @Around @Aspect @order
3.tx声明式事务管理:1.对应的事务管理器实现 [TransactionManager Dataource.: Hiberate.。 Jpa.。]2.开启事务注解支持
 */


//FIXME：配置类，配置springmvc
@EnableWebMvc//FIXME：加这个注解相当于给handelerMapping、handlerAdaprter配置了json转换器！
@Configuration
@ComponentScan({"com.example.controller","com.example.allErrorException","com.example.exceptions"})
@EnableAspectJAutoProxy//开启aop
@EnableTransactionManagement//开启tx事务！
public class configuration  implements WebMvcConfigurer {
    //FIXME:WebMvcConfigurer就是配置视图解析器！！
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        //用redistry来快速添加前后缀。配置好后在handleriu可以直接通过index（jsp文件名）来找到对应文件，因为他会自动添加前后缀！
        //使用这个自动添加前后缀的功能后，返回的字符串如果要用到视图解析器（没加@ResponBody）的会自动添加前后缀
        registry.jsp("WEB-INF/views/",".jsp");//会将这些字符串拼接在return的前后！！所以注意前一个最后面的/，后一个最前面的.！！
    }
    /*TODO:开启静态资源查找,配置好下面的代码后就哭一在浏览器直接通过静态资源的路径访问：pictures/0.jpg
    让despatcherServlet去handlerMapping找有没有对应的handler，如果没有就去找静态资源！
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }


    //FIXME：开启拦截器配设置拦截器行为！
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //方案1：拦截全部请求。
        //registry.addInterceptor(new interceptor());//里面写的就是我们自己创建的拦截器类！

        //方案2：指定拦截地址。*代表一层字符串，**代表任意层字符串。
        //registry.addInterceptor(new interceptor()).addPathPatterns("/user/**");

        //方案3.排除拦截;排除的地址要在拦截地址的里面！
        registry.addInterceptor(new interceptor()).addPathPatterns("/user/**").excludePathPatterns("/user/forwar");

    }

    //——————————————————————————————下面是Bean的配置——————————————————————————
    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }




}
