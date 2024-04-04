package com.example.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Mapper.ikunMapper;
import com.example.pojo.修仙book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//TODO:条件构造器
// https://baomidou.com/pages/10c804/#abstractwrapper
@SpringBootTest
public class WrapperTest {

    @Autowired
    private ikunMapper heizi;
    @Test
    public void WrapperTest(){
        //查询classnumber<3而且price在10~100之间的
        QueryWrapper<修仙book> queryWrapper = new QueryWrapper<>();
        //动态调用wrapper的方法完成拼接：
        queryWrapper.between("price",10,100);
        queryWrapper.lt("classnumber",3);
        List<修仙book> result=heizi.selectList(queryWrapper);
        System.out.println(result);
    }


}
