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

@WebServlet(name="Register", value = "/register")
public class RegisterController extends HttpServlet {
   AccountService service= new AccountService();
    Account account = new Account();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String  username= req.getParameter("username");
            String pass=req.getParameter("pass");
            String phone = req.getParameter("phone");
            String email= req.getParameter("email");
            String address=req.getParameter("address");
            String fullName=req.getParameter("fullname");
            if(username=="" || pass==""||phone==""||email=="")
            {
                String status ="Vui lòng nhập đầy đủ thông tin";
                req.setAttribute("status",status);
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }else
            {
                Boolean result = service.insertAccount(username,pass,phone,email,address,fullName);
                if(result==false)
                {
                    String status ="Tên đăng nhập đã tồn tại";
                    req.setAttribute("status",status);
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
                else
                {
                    String status ="Đăng ký thành công";
                    req.setAttribute("status",status);
                    req.getRequestDispatcher("register.jsp").forward(req,resp);
                }
            }

        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void destroy() {
    }
}
