package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Mota", value = "/mota")
public class DescriptController extends HttpServlet {
    ProductService service = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Product product = new Product();
        {
            try {
                int Id= Integer.parseInt(request.getParameter("Id"));
                 product= service.getProductByID(Id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("descript.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void destroy() {

    }

}
