package com.example.tmdt.Model.POJO;

public class Product {
    private int id;
    private  String ten;
    private  int gia;
    private  String anh;
    private  String mota;
    private  int soLuong;


    public Product(int id, String ten, int gia, String anh, String mota, int soLuong) {
        this.id = id;
        this.ten = ten;
        this.gia = gia;
        this.anh = anh;
        this.mota = mota;
        this.soLuong = soLuong;
    }

    public Product(int id, String ten, int gia, String anh, int soLuong) {
        this.id=id;
        this.ten = ten;
        this.gia = gia;
        this.anh = anh;
        this.soLuong=soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
