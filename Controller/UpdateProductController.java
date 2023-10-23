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

@WebServlet(name = "UpdateProduct", value = "/update")
public class UpdateProductController extends HttpServlet {
    ProductTypeService productTypeService = new ProductTypeService();
    List<ProductType> listProductType = new ArrayList<>();
    ProductService productService= new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            int id = Integer.parseInt(req.getParameter("Id"));
            Product product = productService.getProductByID(id);
            listProductType = productTypeService.getProductType();
            req.setAttribute("list", listProductType);
            req.setAttribute("product",product);
            req.getRequestDispatcher("updateProduct.jsp").forward(req,resp);
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String tensp = req.getParameter("tensp");
            int giasp= Integer.parseInt(req.getParameter("giasp"));
            String anh = req.getParameter("anh");
            String mota = req.getParameter("mota");
            int idType = Integer.parseInt(req.getParameter("idType"));
            boolean product = productService.updateProduct(tensp,giasp,anh,mota,id,idType);
            if (product) {
                List<Product> list = productService.getProduct();
                req.setAttribute("list", list);
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
