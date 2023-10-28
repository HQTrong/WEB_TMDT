package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Shop;
import com.example.tmdt.Model.Service.ShopService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Cập nhật địa chỉ", value = "/updateshop")
public class AddShopController extends HttpServlet {
    private ShopService shopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Shop shop = shopService.getShop();
            req.setAttribute("shop",shop);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
