package com.example.tmdt.Controller;

import com.example.tmdt.Model.Service.ComplaintService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;

@WebServlet(name="Contact", value = "/contact")
public class ComplaintController extends HttpServlet {
    ComplaintService complaintService= new ComplaintService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       try {
            String username= req.getParameter("username");
            String phone= req.getParameter("phone");
            String complaint= req.getParameter("complaint");
            if(username=="")
            {
                String status="Vui lòng đăng nhập trước khi phản hồi";
                req.setAttribute("status", status);
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
            else {
                if(complaint=="")
                {
                    String status="Vui lòng điền đầy đủ thông tin";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("contact.jsp").forward(req,resp);
                }else if(phone.length()!= 10){
                    String status="Số điện thoại không hợp lệ";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("contact.jsp").forward(req,resp);
                }
                else
                {
                    boolean is = false;
                    is = complaintService.insertComplaint(username,phone,complaint);
                    if(is)
                    {
                        String status="Cảm ơn bạn đã góp ý cho của hàng";
                        req.setAttribute("status", status);
                        req.getRequestDispatcher("contact.jsp").forward(req,resp);
                    }else
                    {
                        String status="Không thể gởi phản hồi";
                        req.setAttribute("status", status);
                        req.getRequestDispatcher("contact.jsp").forward(req,resp);
                    }
                }

            }

        } catch (SQLException e)
       {
           throw  new RemoteException();
       }
    }

    @Override
    public void destroy() {

    }
}
