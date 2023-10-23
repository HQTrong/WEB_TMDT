package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Purchase;
import com.example.tmdt.Model.Service.PurchaseService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Purchase", value = "/purchase")
public class PurchaseController extends HttpServlet {
    PurchaseService purchaseService = new PurchaseService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("user");
        List<Purchase> list = null;
        try {
            list = purchaseService.getPurchase(username);
            req.setAttribute("purchase", list);

            List<Purchase> l = purchaseService.getPurchase(username);
            int a=3;
            req.getRequestDispatcher("detailPurchase.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
