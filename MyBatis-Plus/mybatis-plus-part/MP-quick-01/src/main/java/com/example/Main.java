package com.example;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.Mapper")
@SpringBootApplication//里面就有@Configuration，启动类也是一个配置类。
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello MyBatis-Plus!");
        SpringApplication.run(Main.class,args);
    }

    /*
    TODO:使用分页插件
    1.导入插件
    2.使用分页查询。
     */
    //Mybatis-Plus插件加入到IOC容器。
    @Bean
    public MybatisPlusInterceptor plusInterceptor()
    {
        //MybatisPlusInterceptor相当于MybatisPlus的插件集合。（乐观锁，分页插件……）
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //分页插件：
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}