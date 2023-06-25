package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Complaint;
import com.example.tmdt.Model.Service.ComplaintService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name=" Customer Complaint", value = "/complaint")
public class CustomerComplaint extends HttpServlet {
    ComplaintService complaintService = new ComplaintService();
    List<Complaint> list = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            list=complaintService.getComplaint();
            req.setAttribute("list",list);
            req.getRequestDispatcher("complaint.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
