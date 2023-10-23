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
import java.util.List;

@WebServlet(name="Product",value = "/show")
public class ProductController extends HttpServlet {
ProductService service = new ProductService();
ProductTypeService productTypeService = new ProductTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        List<ProductType> categoryList = null;
        {
            try {
                list = service.getProduct();
                categoryList= productTypeService.getProductType();
                request.setAttribute("list", list);
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("product.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = null;
        List<ProductType> categoryList = null;
        {
            try {
                String tensp = req.getParameter("tensp");
                categoryList= productTypeService.getProductType();
                list = service.getProductName(tensp);
                req.setAttribute("list", list);
                req.setAttribute("categoryList", categoryList);
                req.getRequestDispatcher("product.jsp").forward(req, resp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void destroy() {
    }
}
