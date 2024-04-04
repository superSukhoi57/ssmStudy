package com.example.ioc_04;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class jdbcTes {


    public static void main(String[] args) {
        new jdbcTes().useIoc();
    }


    //这是没交给IOC容器管理的DruidDataSource，参数要自己配置！！
    public void   notUseIoc(){
        //0.创建一个连接池对象
        DruidDataSource dataScurce= new DruidDataSource();
        dataScurce.setUrl("jdbc:mysql:///studb");
        dataScurce.setDriverClassName("com.mysql.cj.jdbc.Driver");//jdbc驱动
        dataScurce.setUsername("root");//账号
        dataScurce.setPassword("newbee");//密码
        //1.实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataScurce);
        //2.调用方法即可
        //jdbcTemplate.update()DDL DML DCL ... 非查询语句


        //2.调用方法即可
//jdbcTemplate.update()DDL DML DCL ...、非查询语句
// jdbcTemplate.queryForObject()DQL 查询单个对象
// jdbcTemplate.query()DQL 查询集命

    }

    public void useIoc(){
        //使用容器：
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-04.xml");
        //DruidDataSource datasource=(DruidDataSource)applicationContext.getBean("dataSource");
        JdbcTemplate jdbctemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");


        String sql="select name,price from 修仙book;";
        //一开始下面的圆括号没有写.class会报错：Exception in thread "main" java.lang.IllegalStateException: Mapped class was not specified
        //而且BeabPropertyRowMapper要求返回的类名要和类的属性名一致，不一致在sql语句取别名就行。这个类可以自动将多个值自动赋值给类，并返回List！！！
        List<table> tableList=jdbctemplate.query(sql,new BeanPropertyRowMapper<table>(table.class));
        System.out.println("tableList is"+tableList);
    }


}
class table{
    String name;
    int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    //TODO:toString方法就是在返回Object时我们看见的东西！！
    @Override
    public String toString() {
        return "table{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}'+'\n';
    }
    //todo:没重写就会[com.example.ioc_04.table@7357a011, com.example.ioc_04.table@3406472c ]
}
