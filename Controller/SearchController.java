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

@WebServlet(name = "Search", value = "/search")
public class SearchController extends HttpServlet {
    ProductService productService= new ProductService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = null;
        String productId = req.getParameter("product_id");
        String name = req.getParameter("name");
        try{
            if(productId.isEmpty() && name.isEmpty())
            {
                list =productService.getProduct();
                req.setAttribute("list",list);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
            else if(productId.isEmpty())
            {
                Product product = productService.getProductByName(name);
                req.setAttribute("product",product);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }else if (name.isEmpty())
            {
                Product product= productService.getProductByID(Integer.parseInt(productId));
                req.setAttribute("product",product);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }
            else
            {
                Product product = productService.getProductByName_ID(name,Integer.parseInt(productId));
                req.setAttribute("product",product);
                req.getRequestDispatcher("admin.jsp").forward(req,resp);
            }

        }catch(SQLException e)
        {
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
