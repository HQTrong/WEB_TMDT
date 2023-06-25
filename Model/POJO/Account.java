package com.example.tmdt.Model.POJO;

public class Account {
    private int id;
    private String user;
    private String pass;
    private  String phone;
    private  String email;
    private  String address;
    private  String fullName;
    private  String phanQuyen;

    public Account() {
    }

    public Account(int id, String user, String pass, String phone, String email, String address, String fullName,String phanQuyen) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.fullName = fullName;
        this.phanQuyen=phanQuyen;
    }

    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
