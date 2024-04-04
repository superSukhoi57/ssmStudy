package com.example.pojo;




public class Heizi {
    private String name;
    private int priuce;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriuce() {
        return priuce;
    }

    public void setPriuce(int priuce) {
        this.priuce = priuce;
    }

    @Override
    public String toString() {
        return "Heizi{" +
                "name='" + name + '\'' +
                ", priuce=" + priuce +
                '}';
    }
}
