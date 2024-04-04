package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//TODO:类名就是要查询的表名，MP会将表中的属性按照类的属性名给其赋值（同名/驼峰蛇形映射），类没有的属性就没赋值！
@TableName("修仙book")//TODO：当实体类的名字和要查的表名不同时可以用这个注解来让这个实体类对应数据库的表名！
@Data
//TODO：实体类不用将其加入到IOC？
public class 修仙book {
    private String number;
    private String classnumber;
    private String state;
    private String total;
    private String name;
    private Integer price;//用包装类型，默认值是null而不是int的0；

}
