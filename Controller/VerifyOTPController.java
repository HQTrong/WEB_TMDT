package com.example.tmdt.Controller;

import com.example.tmdt.Model.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Verify OTP and Password", value = "/verify")
public class VerifyOTPController extends HttpServlet {
    private JedisPool jedisPool;
    private AccountService accountService = new AccountService();

    @Override
    public void init() throws ServletException {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(poolConfig, "localhost", 6379);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jedis jedis = null;
        String otp = req.getParameter("otp");
        String password = BCrypt.hashpw(req.getParameter("pass"), BCrypt.gensalt(10));
        String email= req.getParameter("email");
        try {
            jedis = jedisPool.getResource();
            String value = jedis.get(email);
            if(value.equals(otp)){
                accountService.updatePassword(password,email);
                String status="Thay đổi mật khẩu thành công!!";
                req.setAttribute("status",status);
                req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
            }
            else{
                String status="Thay đổi mật khẩu thất bại!! Vui lòng kiếm tra lại";
                req.setAttribute("status",status);
                req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            String status="Có lỗi xảy ra. Vui lòng kiếm tra lại";
            req.setAttribute("status",status);
            req.getRequestDispatcher("forgotPassword.jsp").forward(req,resp);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    @Override
    public void destroy() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }

}
