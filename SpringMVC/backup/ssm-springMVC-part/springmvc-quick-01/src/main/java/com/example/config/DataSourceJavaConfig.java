package com.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration
@PropertySource("classpath:db.properties")//引入配置文件。
//FIXME：避免在同一个类里面出现mybatis组件比@value优先加载出现没值的情况在这里创建一个连接池的配置类。
public class DataSourceJavaConfig {

    //————————————————————FIXME：springMVC整合Mybatis的配置文件。方式一——————————————————————
    @Value("${db.url}")
    private String url;
    @Value("${db.driver}")
    private String driver;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource= new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);//这里setDriverClassname！！！
        dataSource.setUrl(url);
        return dataSource;
    }


    /*///_______________________________
    //将sqlSessionFactory加入到ioc容器中。
    //mybatis会提供一个sqlSessionFactoryBean工厂，在这个工厂的getObject中帮我们完成sqlSessionFactory的实例化。
    //配置方式1：外部指定mybatis的xml文件（连接池用Druid连接池里面就不用配连接池！）
    //。。。。这种方式将datasource注解和mybatis的组件配置再一起，因为mybatis组件优先加载，会导致@value还没读取！
    //。。。。解决方法：将连个组件写到不同的类即可。
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //里面指定配置文件等信息。
        //指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定外部mybatis配置文件,resource来自spring.core.io包
        Resource resource=new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;

    }

    @Bean
    //mapper代理对象加入到ioc！
    public MapperScannerConfigurer mapperScannerConfigurer(){
        *//*这个就是Mapper代理对象的FactoryBean，会将指定包里的所有mpper接口通过SqlSessionFactory调用sqlSession
        的getMapper方法来生成mapper代理对象，加入到ioc容器。
         *//*
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.example.mapper");//mapper接口和mapper.xml文件所在的包
        return mapperScannerConfigurer;
    }*/
    //————————————————————————到此mybatis配好————————————————————————
}
