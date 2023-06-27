package com.example.tmdt.Model.POJO;

public class Customer {
    private  int id;
    private String fullname;
    private String address;
    private String phone;
    private  String username;

    public Customer() {
    }

    public Customer(int id, String fullname, String address, String phone,  String username) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.phone = phone;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
