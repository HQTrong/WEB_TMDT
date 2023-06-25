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

@WebServlet(name="Product",value = "/show")
public class ProductController extends HttpServlet {
ProductService service = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        {
            try {
                list = service.getProduct();
                request.setAttribute("list", list);
                request.getRequestDispatcher("product.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public void destroy() {
    }
}
