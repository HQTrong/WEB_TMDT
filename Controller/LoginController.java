package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Account;
import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.AccountService;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="Login", value="/login")
public class LoginController extends HttpServlet {
    AccountService servive = new AccountService();
    Account user= null;
    Account admin= null;
    ProductService productService= new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> list = productService.getProduct();
            req.setAttribute("list",list);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username= req.getParameter("username");
        String pass = req.getParameter("pass");
        HttpSession session = req.getSession();
        List<Product> list = new ArrayList<>();

        try {
            user = servive.getUser(username);
            if (user.getUser()!=null) {
                if (user.getPass().equals(pass)) {
                    if (user.getPhanQuyen()!=null) {
                        list = productService.getProduct();
                        session.setAttribute("user", username);
                        req.setAttribute("list", list);
                        req.getRequestDispatcher("admin.jsp").forward(req, resp);
                    } else {
                        session.setAttribute("user", username);
                        req.getRequestDispatcher("home.jsp").forward(req, resp);
                    }
                } else {
                    String status = "Mật khẩu không chính xác!!";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                String status = "Tên đăng nhập không chính xác!!";
                req.setAttribute("status", status);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void destroy() {
    }
}
