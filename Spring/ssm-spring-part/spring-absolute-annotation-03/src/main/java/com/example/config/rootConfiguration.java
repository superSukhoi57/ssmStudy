package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//通过Import注解将configuration配置类整合到rootConfiguration里面！！
@Import(value={configuration.class})
@Configuration
public class rootConfiguration {

}
