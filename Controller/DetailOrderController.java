package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Cart;
import com.example.tmdt.Model.POJO.Customer;
import com.example.tmdt.Model.POJO.Order;
import com.example.tmdt.Model.Service.CartService;
import com.example.tmdt.Model.Service.CustomerService;
import com.example.tmdt.Model.Service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="DetailOrder", value = "/detailorder")
public class DetailOrderController extends HttpServlet {
    CartService cartService= new CartService();
    CustomerService customerService = new CustomerService();
    OrderService orderService = new OrderService();

    List<Cart> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {

            int id = Integer.parseInt(req.getParameter("Id"));
            Order order= orderService.getOrderID(id);
            Customer customer=customerService.getCustomerByID(order.getIdCustomer());
            list= cartService.getCartByID(id);
            req.setAttribute("list",list);
            req.setAttribute("id",id);
            req.setAttribute("fullname",customer.getFullname());
            req.setAttribute("phone",customer.getPhone());
            req.setAttribute("address",customer.getAddress());
            req.getRequestDispatcher("detailOrder.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
