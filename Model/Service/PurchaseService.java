package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.PurchaseDAO;
import com.example.tmdt.Model.POJO.Purchase;
import com.example.tmdt.Model.POJO.PurchaseSubset;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseService {
    PurchaseDAO dao = new PurchaseDAO();

    public List<Purchase> getPurchase(String username) throws SQLException {
        List<Purchase> purchases = new ArrayList<>();
        List<Purchase> list = dao.getPurchase(username);
        for (Purchase p : list) {
            if(purchases.isEmpty()){
                List<PurchaseSubset> purchaseSubsets = new ArrayList<>();
                PurchaseSubset purchaseSubset = new PurchaseSubset();
                purchaseSubset.setPrice(p.getPrice());
                purchaseSubset.setQuantity(p.getQuantity());
                purchaseSubset.setProductName(p.getProductName());
                purchaseSubset.setImg(p.getImg());
                purchaseSubsets.add(purchaseSubset);
                purchases.add(new Purchase(p.getFullName(),p.getAddress(),p.getPhone(),p.getOrderId(),p.getTotal(),purchaseSubsets));
            }else{
                for(Purchase purchase: purchases){
                    if(p.getOrderId()==purchase.getOrderId()){
                        List<PurchaseSubset> purchaseSubsets = purchase.getListPurchase();
                        PurchaseSubset purchaseSubset= new PurchaseSubset();
                        purchaseSubset.setPrice(p.getPrice());
                        purchaseSubset.setQuantity(p.getQuantity());
                        purchaseSubset.setProductName(p.getProductName());
                        purchaseSubset.setImg(p.getImg());
                       purchaseSubsets.add(purchaseSubset);
                    }
                    else{
                        List<PurchaseSubset> purchaseSubsets = new ArrayList<>();
                        PurchaseSubset purchaseSubset = new PurchaseSubset();
                        purchaseSubset.setPrice(p.getPrice());
                        purchaseSubset.setQuantity(p.getQuantity());
                        purchaseSubset.setProductName(p.getProductName());
                        purchaseSubset.setImg(p.getImg());
                        purchaseSubsets.add(purchaseSubset);
                        purchases.add(new Purchase(p.getFullName(),p.getAddress(),p.getPhone(),p.getOrderId(),p.getTotal(),purchaseSubsets));
                        break;
                    }
                }
            }
        }

        return !purchases.isEmpty()? purchases:null;
    }
}
