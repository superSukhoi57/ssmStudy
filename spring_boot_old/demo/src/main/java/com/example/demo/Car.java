package com.example.demo;

public class Car {
    public int price;
    public String type;
    public String company;
    public Car(int p,String t,String c){
        price=p;
        type=t;
        company=c;
    }
    @Override
    public String toString(){
        return "price:"+price+",type:"+type+",company:"+company;
    }
    //

    public void setPrice(int price) {
        this.price = price;
    }
}
