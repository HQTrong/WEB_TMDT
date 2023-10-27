package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.PurchaseDAO;
import com.example.tmdt.Model.POJO.Purchase;
import com.example.tmdt.Model.POJO.PurchaseSubset;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseService {
    PurchaseDAO dao = new PurchaseDAO();

    public List<Purchase> getPurchase(String username) throws SQLException {

        List<Purchase> purchases = dao.getPurchase(username);

        Map<Integer, Purchase> purchaseMap = new HashMap<>();

        for (Purchase purchase : purchases) {
            int orderId = purchase.getOrderId();

            if (purchaseMap.containsKey(orderId)) {
                Purchase existingPurchase = purchaseMap.get(orderId);
                List<PurchaseSubset> purchaseSubsets = existingPurchase.getListPurchase();

                PurchaseSubset purchaseSubset = new PurchaseSubset();
                purchaseSubset.setPrice(purchase.getPrice());
                purchaseSubset.setQuantity(purchase.getQuantity());
                purchaseSubset.setProductName(purchase.getProductName());
                purchaseSubset.setImg(purchase.getImg());
                purchaseSubsets.add(purchaseSubset);
            } else {
                List<PurchaseSubset> purchaseSubsets = new ArrayList<>();
                PurchaseSubset purchaseSubset = new PurchaseSubset();
                purchaseSubset.setPrice(purchase.getPrice());
                purchaseSubset.setQuantity(purchase.getQuantity());
                purchaseSubset.setProductName(purchase.getProductName());
                purchaseSubset.setImg(purchase.getImg());
                purchaseSubsets.add(purchaseSubset);

                Purchase newPurchase = new Purchase(purchase.getFullName(), purchase.getAddress(), purchase.getPhone(), orderId, purchase.getTotal(), purchaseSubsets);
                purchaseMap.put(orderId, newPurchase);
            }
        }

        return (purchaseMap != null) ? new ArrayList<>(purchaseMap.values()) : null;

    }
}
