package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Account;
import com.example.tmdt.Model.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="Customer", value = "/customer")
public class CustomerController extends HttpServlet {
    AccountService accountService = new AccountService();
    List<Account> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            list= accountService.getAccount();
            req.setAttribute("listCustomer", list);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
