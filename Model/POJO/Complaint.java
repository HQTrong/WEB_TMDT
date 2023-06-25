package com.example.tmdt.Model.POJO;

public class Complaint {
    private int id;
    private  String username;
    private  String phone;
    private  String complaint;

    public Complaint(int id, String username, String phone, String complaint) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.complaint = complaint;
    }

    public Complaint() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
