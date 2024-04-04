package com.example.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Transactional//TODO:  @Transactional声明式事务类/方法的注解，如果有属性方法的会付给类的
    public void fix(){
        String sql="update 修仙book set price = ? where number= ?;";
        jdbcTemplate.update(sql,315,"N03");
    }
}
