package com.example.config;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

/*
FIXME：springMVC整合Mybatis的配置文件。方式二 的mybatis配置类！！
有了这个用完全配置类的配置就用不到外部xml配置文件。
 */
@Configuration(proxyBeanMethods=false)
public class mybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //里面指定配置文件等信息。
        //指定数据库连接池对象
        sqlSessionFactoryBean.setDataSource(dataSource);
        /*指定外部mybatis配置文件,resource来自spring.core.io包
        Resource resource=new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);*/

        //这种方式二就不用上面的外部配置文件，只要在代码指定就行。
        //org.apache.ibatis.session.Configuration 这个就是储存setting的配置文件。
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);

        sqlSessionFactoryBean.setConfiguration(configuration);//类内配置的信息放到这个工厂里就好了。
        return sqlSessionFactoryBean;
    }

    @Bean
    //mapper代理对象加入到ioc！
    public MapperScannerConfigurer mapperScannerConfigurer(){
        /*这个就是Mapper代理对象的FactoryBean，会将指定包里的所有mpper接口通过SqlSessionFactory调用sqlSession
        的getMapper方法来生成mapper代理对象，加入到ioc容器。
         */
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.example.mapper");//mapper接口和mapper.xml文件所在的包
        return mapperScannerConfigurer;
    }
}
