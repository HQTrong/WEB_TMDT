package com.example.tmdt.Model.POJO;

public class Cart {
    private int idCart;
    private int idDonHang;
    private int idProduct;
    private  int giasp;
    private  String tensp;
    private int soLuong;
    public Cart() {
    }

    public Cart(int idCart, int idDonHang, int idProduct, int giasp, String tensp,int soLuong) {
        this.idCart = idCart;
        this.idDonHang = idDonHang;
        this.idProduct = idProduct;
        this.giasp = giasp;
        this.tensp=tensp;
        this.soLuong=soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(int idDonHang) {
        this.idDonHang = idDonHang;
    }
}
