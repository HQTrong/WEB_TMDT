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

@WebServlet(name = "Shop", value = "/shop")
public class ShopController extends HttpServlet {
    private ShopService shopService = new ShopService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Shop shop = shopService.getShop();
            req.setAttribute("shop",shop);
            req.getRequestDispatcher("contact.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address= req.getParameter("address");
        String time = req.getParameter("time");
        String day = req.getParameter("day");
        int id= Integer.parseInt(req.getParameter("id"));
        boolean is = false;
        try {
            is = shopService.updateShop(id,address,time,day);
            if(is)
            {
                Shop shop = shopService.getShop();
                String status= "Cập nhật thành công!!";
                req.setAttribute("status",status);
                req.setAttribute("shop",shop);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
            else{
                String status= "Cập nhật thất bại!!";
                req.setAttribute("status",status);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
