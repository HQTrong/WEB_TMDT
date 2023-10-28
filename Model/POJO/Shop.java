package com.example.tmdt.Model.POJO;

public class Shop {
    private int id;
    private String address;
    private String time;
    private String day;

    public Shop() {
    }

    public Shop(int id, String address, String time, String day) {
        this.id = id;
        this.address = address;
        this.time = time;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day= day;
    }
}
