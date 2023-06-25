package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Order;
import com.example.tmdt.Model.Service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="OrderBuy", value = "/orderbuy")
public class OrderBuyController extends HttpServlet {
    OrderService orderService= new OrderService();
    List<Order> list= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            list=orderService.getOrder();
            req.setAttribute("list",list);
            req.getRequestDispatcher("orderbuy.jsp").forward(req,resp);
        }catch (SQLException e)
        {
            throw  new RemoteException();
        }

    }

    @Override
    public void destroy() {

    }
}
