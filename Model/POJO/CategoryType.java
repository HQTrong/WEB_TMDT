package com.example.tmdt.Model.POJO;

public class CategoryType {
    private  int id;
    private  String loaisp;

    public CategoryType() {
    }

    public CategoryType(int id, String loaisp) {
        this.id = id;
        this.loaisp = loaisp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }
}
