package com.example.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.service")
@EnableAspectJAutoProxy//等于xml文件开启aspectj的注解！！！
public class myCongiuration {

}
