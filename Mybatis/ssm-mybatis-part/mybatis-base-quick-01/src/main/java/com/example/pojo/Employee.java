package com.example.pojo;

public class Employee {
    String nummber;
    String name;
    Integer price;

    public String getNummber() {
        return nummber;
    }

    public void setNummber(String nummber) {
        this.nummber = nummber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nummber='" + nummber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
