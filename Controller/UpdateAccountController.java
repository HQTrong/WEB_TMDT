package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Account;
import com.example.tmdt.Model.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Update Account", value = "/updateAccount")
public class UpdateAccountController extends HttpServlet {
    AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            String username = (String) session.getAttribute("user");
            Account user = accountService.getUser(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("detailUser.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("user");
            String password = BCrypt.hashpw(req.getParameter("pass"), BCrypt.gensalt(10));
            String email = req.getParameter("email");
            accountService.updateAccount(username,password,email);
            Account user = accountService.getUser(username);
            req.setAttribute("user", user);
            req.getRequestDispatcher("detailUser.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
