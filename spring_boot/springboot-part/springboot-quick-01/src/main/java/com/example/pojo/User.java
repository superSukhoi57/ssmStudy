package com.example.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*
TODO：只用配置文的方法;
    1.直接用@Value;但${}里面的key要写全！而且@value只能读取单个值，集合读不了！
    2.使用@ConfigurationProperties(prefix="pojo.user")指定通用前缀就可以给类里面和属性值=最后一个key的赋值!
 */
@Data
@Component
@ConfigurationProperties(prefix="pojo.user")
public class User {
    private String name;
    private int age;
    private char gender;
    List<String> friends;
}
