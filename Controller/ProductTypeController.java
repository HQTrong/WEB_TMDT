package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.ProductType;
import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.ProductTypeService;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="Category Type", value = "/category")
public class ProductTypeController extends HttpServlet {
    ProductService productService = new ProductService();
    ProductTypeService productTypeService = new ProductTypeService();
    List<Product> list = new ArrayList<>();
    List<ProductType> categoryList= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idType=  Integer.parseInt(req.getParameter("Id"));
        try {
            list= productService.getProductByIdType(idType);
            categoryList= productTypeService.getProductType();
            req.setAttribute("list",list);
            req.setAttribute("categoryList",categoryList);
            req.getRequestDispatcher("product.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
