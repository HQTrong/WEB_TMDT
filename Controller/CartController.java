package com.example.tmdt.Controller;

import com.example.tmdt.Model.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="Cart", value = "/cart")
public class CartController extends HttpServlet {
    AccountService accountService= new AccountService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
                String username= req.getParameter("username");
                if(accountService.getUser(username).getUser()!= null)
                {
                    req.getRequestDispatcher("/show").forward(req,resp);

                }else
                {
                    String status="Vui lòng đăng nhập trước khi mua hàng";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
