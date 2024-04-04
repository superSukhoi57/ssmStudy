package com.example.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.Mapper.ikunMapper;
import com.example.pojo.修仙book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest//TODO:加完这个注解，就会自动帮我们完成IOC的初始化！
public class test {
    @Autowired
    private ikunMapper heizi;

    @Test
    public void test(){
        //数据库查找操作是MP提供的，TODO：要求接口的泛型是表名！！！
        List<修仙book> ikuns = heizi.selectList(null);
        int i,size= ikuns.size();
        for(i=0;i<size;i++)
            System.out.println(ikuns.get(i));

        //插入语句：
        修仙book book=new 修仙book();
        book.setClassnumber("2");
        book.setName("黑到深处自然粉！");
        book.setTotal("2.5");
        book.setState("借出");
        book.setPrice(250);
        book.setNumber("N17");

        //int row=heizi.insert(book);
        //System.out.println(row);//已经测试过了，插入成功！

        //使用Map来传递多个条件：
        Map param= new HashMap();
        param.put("price",25);
        param.put("number","N03");//表示 price=25 and number="N03"
        int d= heizi.deleteByMap(param);

    }

    @Test
    public void test_update(){
        //修改 price=22 的书的total为10086
        //当类得属性值为null时不修改。所以类里面有int属性要改为Integer！因为使用int它的默认值为0；包装类型默认为空。
        修仙book book=new 修仙book();
        book.setClassnumber(String.valueOf(3));

        // Create a QueryWrapper to specify the condition price=25
        QueryWrapper<修仙book> wrapper = new QueryWrapper<>();
        wrapper.eq("price", 25);

        // Update the book
        int u = heizi.update(book, wrapper);

    }

    //分页查询：TODO：使用分页代码。
    @Test
    public void test_page(){
        //IPage---->Page(页码，页容量);
        Page<修仙book> page=new Page<>(1,4);
       heizi.selectPage(page,null);
       //查询结果注解存在page里面！

        long current=page.getCurrent();//当前页码
        long size= page.getSize();//页容量
        List<修仙book> record=page.getRecords();//当前页的数据
        long total= page.getTotal();//数据总条数
        System.out.println("当前页码"+current+"  页容量"+size+"  当前页面数据"+record+"\n   总条数"+total);
    }


    //自定义查询方法：
    @Test
    public void mine_page_test(){
        Page<修仙book> page=new Page<>(2,2);
        heizi.queryByPrice(page,23);

        List<修仙book> record=page.getRecords();
        System.out.println(record);
    }

}
