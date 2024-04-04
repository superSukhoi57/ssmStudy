package com.example.config;



/*
java的配置类，替代xml配置文件
1.包扫描注解配置
2.引用外部的配置文件
3.声明第三方依赖的bean组件
步骤1:添加 @Configuration 代表我们是配置类步骤
2:实现上面的三个功能注解
 */


/*———————————————————————————————————————————声明第三方配置类的详细方法————————————————————————————————————
//第三方Bean的配置；就是xml里面配置第三方依赖的Bean，注解配置要先创建一个方法，方法的返回值是它的接口或者父类，方法名字就是id值，
// 然后在函数体里面实现具体过程就行，最后加@Bean注解！



/*

    问题1:beanName的问题
默认:方法名
name /value属性起名字，覆盖方法名指定:
    问题2:周期方法如何指定
原有注解方案:PostConstruct+PreDestroy
注解指定bean居性指定:initMethod/destroyMethod指定
    问题3:作用域
和以前还是一样，@Scope注解，默认是单例
    问题4：案例在代码后面
方案1:如果其他组件也是@Bean方法，可以直接调用
方案2: 形参列表声明想要的组件类型，可以是一个也可以是多个! ioc容器也会注入

 */
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;


@ComponentScan({"com.example","com.example.Student"})//多个包要扫描可以用数组……
@PropertySource(value="jdbc3.properties")
@Configuration
public class configuration {

    //这里的..可以找到配置文件是因为在这个子项目的pom.xml那里导入对应工程的依赖
    //详细步骤在markdown有！！
    @Value("${my.url}")
    String url;
    @Value("${my.driver}")
    String driver;
    @Value("${my.username}")
    String username;
    @Value("${son3.password}")
    String password;

        /*
    <bean-》一个方法
方法的返回值类型==bean组件的类型或者他的接口和父类
方法的名字=bean id
方法体可以自定义实现过程即可!
*最重要一步:@Bean 会真正让配置类的方法创建的组件存储到ioc容器!!
     */

    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean(name="data")
    public DruidDataSource dataSource(){
        //实现具体的实例化过程
        DruidDataSource dataSource =new DruidDataSource();dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbc = new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        // 方案1:如果其他组件也是@Bean方法，可以直接调用
        // 别看他是调用方法，实际上是从ioc容器获取组件，但前提是这个bean已经注册过了！
        jdbc.setDataSource(dataSource());
        return jdbc;

    }
    @Bean
    public JdbcTemplate jdbcTemplate1(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        //需要DataSource 需要ioc容器的其他组件
        // 方案2: 形参列表声明想要的组件类型，可以是一个也可以是多个! ioc容器也会注入
        //如果有多个就要写清楚类名，就是id的值。
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}

