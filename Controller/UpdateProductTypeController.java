package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.ProductType;
import com.example.tmdt.Model.Service.ProductTypeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Update Product Type", value = "/updateProductType")
public class UpdateProductTypeController extends HttpServlet {
    ProductTypeService productTypeService = new ProductTypeService();
    List<ProductType> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int id = Integer.parseInt(req.getParameter("Id"));
           boolean result = productTypeService.updateProductType(id,name);
            if(result){
                list = productTypeService.getProductType();
                req.setAttribute("list",list);
                req.getRequestDispatcher("addTypeProduct.jsp").forward(req,resp);
            }
            else{
                String status= " Không thể cập nhật";
                req.setAttribute("status",status);
                req.getRequestDispatcher("addTypeProduct.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
