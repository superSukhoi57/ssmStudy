package com.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//TODO:这个就不必在。。创建。。。直接将properties写在resources下即可！！
@PropertySource("classpath:five.properties")
@ComponentScan("com.example")

//这个值要在classpath(resource)下找到com.example.config的……容易出错！！！这个注解总是会报错找不到配置类！！！
//@PropertySource(value= "five.properties")

@EnableAspectJAutoProxy//TODO：开启Aspectj直接的支持！就是AOP注解
@EnableTransactionManagement//TODO：开启事务注解的支持！！
@Configuration
public class configuration {
    @Value("${five.url}")
    String url;
    @Value("${five.driver}")
    String driver;
    @Value("${five.username}")
    String username;
    @Value("${five.password}")
    String password;


    //Druid连接池！
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
    @Bean
    //jdbcTemplate
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    /*
TODO：声明式事务：

    1.写开启事务的注解
        @EnableAspectJAutoProxy
        @EnableTransactionManagement

    2.写spring给的方法public TransactionManager transactionManager(DataSource dataSource){

    3.添加事务：
        @Transactional
        位置:方法|类上
        方法:当前方法有事务
        类上:类上的所有方法都有事务
        类和方法都加，方法的属性会覆盖类的！

    4.只读模式
        @Transactional(readOnly = false)
        只读模式可以提升查询事务的效率! 推荐事务中只有查询代码，使用只读模式!
        默认:boolean readOnly()default false;
        解释:一般情况下，都是通过类添加注解添加事务!类下的所有方法都有事务!
        查询方法可以通过再次添加注解，设置为只读模式，提高效率!

     5.超时时间
        默认:永远不超时-1
        设置 timeout=时间 秒数 超过时间，就会回滚事务和释放异常!TransactionTimedoutException如果类上设置事务属性，
        方法也设置了事务注解!方法会不会生效??不会生效:方法上的注解覆盖了类上的注解!

     6.指定异常回滚和指定异常不回滚:
        默认情况下，指定发生运行时异常事务才会回滚!
        我们可以指定Exception异常来控制所有异常都回滚!
        rollbackFor =Exception.class

        noRollbackFor=回滚异常范围内，控制某个异常不回滚!
    @Transactional(readOnly = false ,rollbackfor = Exception,class , noRollbackFor = FileNotFoundException.class)

    7.隔离级别设置
        推荐设置第二个隔离级别!
        isolation =Isolation.READ COMMITTED
        @Transactional(isolation =Isolation.READ COMMITTED)

    8.事务的传播行为：
    *propagation=Propagation.REQUIRED 父方法有事务，我们就加入到父方法的事务!最终是同一个事务! 推荐使用默认值!!
    *propagation =Propagation.REQUIRES_NEW  不管父方法是否有事务，我都是独立的事务!两个事务或者三个事务!
     */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        //内部的操作是基于数据库连接池的！！
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        //给他连接池对象。
        dataSourceTransactionManager.setDataSource(dataSource);
        return  dataSourceTransactionManager;

    }

}
