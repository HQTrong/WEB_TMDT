package com.example.tmdt.Controller;

import com.example.tmdt.Model.Service.AccountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name="Send Mail", value = "/sendMail")
public class SendMailController extends HttpServlet {
    public int ranDom(){
        Random random = new Random();
        int min = 111111;
        int max = 999999;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }
    private JedisPool jedisPool;
    private AccountService accountService = new AccountService();

    @Override
    public void init() throws ServletException {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        jedisPool = new JedisPool(poolConfig, "localhost", 6379);
    }

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Jedis jedis = null;
        // Email properties
        String smtpHost = "smtp.gmail.com";
        String from = "service.67329646@gmail.com";
        String to = request.getParameter("email");
        int smtpPort = 587;
        String password = "gzdx ktgy qryy lfpt";

    Properties properties = new Properties();
    properties.put("mail.smtp.host", smtpHost);
    properties.put("mail.smtp.port", smtpPort);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");


    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
    });

    MimeMessage message = new MimeMessage(session);

    try {

        // Set the sender and recipient
        message.setFrom(new InternetAddress(from));
        message.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

        // Set the email subject and content
        message.setSubject("OTP");
        int OTP = ranDom();
        message.setText("OTP: " + OTP);
        // Send the message
        if(to.equals(accountService.getEmail(to).getEmail()))
        {
            Transport.send(message);
            jedis = jedisPool.getResource();
            jedis.setex(to, 180, String.valueOf(OTP));
            String status="Gởi thành công. Vui lòng thực hiện bước tiếp theo.";
            request.setAttribute("status",status);
            request.getRequestDispatcher("forgotPassword.jsp").forward(request,response);
        }
        else{
            String status="Không tìm thấy email. Vui lòng kiểm tra lại";
            request.setAttribute("status",status);
            request.getRequestDispatcher("forgotPassword.jsp").forward(request,response);
        }

    } catch (MessagingException | SQLException mex) {
        String status="Vui lòng nhập email!! ";
        request.setAttribute("status",status);
        request.getRequestDispatcher("forgotPassword.jsp").forward(request,response);
    }
}
    @Override
    public void destroy() {
        if (jedisPool != null) {
            jedisPool.close();
        }
    }

}
