package com.example.tmdt.Model.POJO;

public class PurchaseSubset {
    private int price;
    private int quantity;
    private String productName;
    private  String img;

    public PurchaseSubset(int price, int quantity, String productName, String img) {
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public PurchaseSubset() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
