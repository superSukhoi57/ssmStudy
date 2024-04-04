/*
	可以创建实体类来封装前端传过来的数据，并将这个类作为请求处理函数的参数，
	这个对象会被传过来的参数实例化并赋值，要求对象的属性和参数一致。
 */



package com.example.springboot1.pojo;

public class User {
    private String name;
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge(){
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
