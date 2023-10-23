package com.example.tmdt.Model.POJO;

public class Order {
    private  int id;
    private  int idCustomer;

    private  int total;


    public Order() {
    }

    public Order(int id, int idCustomer, int total) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.total = total;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
