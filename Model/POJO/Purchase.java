package com.example.tmdt.Model.POJO;

import java.util.List;

public class Purchase {
    private String fullName;
    private String address;
    private String phone;
    private int total;
    private int orderId;
    private int cartId;
    private  int price;
    private  int quantity;
    private  String productName;
    private List<PurchaseSubset> listPurchase;
    private String img;

    public Purchase() {
    }

    public Purchase(String fullName, String address, String phone, int total, int orderId, int cartId, int price, int quantity, String productName, List<PurchaseSubset> listPurchase, String img) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.total = total;
        this.orderId = orderId;
        this.cartId = cartId;
        this.price = price;
        this.quantity = quantity;
        this.productName = productName;
        this.listPurchase = listPurchase;
        this.img = img;
    }

    public Purchase(String fullName, String address, String phone, int orderId, int total, List<PurchaseSubset> listPurchase) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.orderId = orderId;
        this.total = total;
        this.listPurchase = listPurchase;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<PurchaseSubset> getListPurchase() {
        return listPurchase;
    }

    public void setListPurchase(List<PurchaseSubset> listPurchase) {
        this.listPurchase = listPurchase;
    }
}
