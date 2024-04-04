package com.example.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.pojo.修仙book;
import org.apache.ibatis.annotations.Param;


public interface ikunMapper extends BaseMapper<修仙book> {
    //TODO：Mybatis-Plus里面不用写方法了！！只要继承BaseMapper<泛型>就行！泛型就是代表查询时的表明！！！
    //通过继承BaseMapper获得数据库的增删改查方法。


    //没需要什么接口方法什么页不用写，要自定义方法可以在这里写。
    //根据price查询，并分页（price>23）
    IPage<修仙book> queryByPrice(IPage<修仙book>page, @Param("price")Integer prices);
    //注意要写mybatis配置这个方法的实现语句的xml，默认会扫描resources文件夹下的mapper！所以要在那里建一个mapper目录！
    //要另外指定需要在yml配置文件指定。

}
