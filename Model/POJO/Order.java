package com.example.tmdt.Model.POJO;

public class Order {
    private  int id;
    private  String username;
    private  int thanhTien;
    private String fullName;

    public Order() {
    }

    public Order(int id, String username, int thanhTien, String fullName) {
        this.id = id;
        this.username = username;
        this.thanhTien = thanhTien;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
