package com.example.ioc_01;

public class DI_bySetter {
    private String name;
    int age;
    char sex;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
