package com.example.tmdt.Model.POJO;

public class Order {
    private  int id;
    private  int idCustomer;

    private  int thanhTien;


    public Order() {
    }

    public Order(int id,int idCustomer, int thanhTien) {
        this.id = id;
        this.idCustomer= idCustomer;
        this.thanhTien = thanhTien;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
