package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.CartService;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteProduct", value = "/remove")
public class DeleteProductController extends HttpServlet {
    ProductService productService = new ProductService();
    CartService cartService = new CartService();
    List<Product> list = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("Id"));
            cartService.removeCart(id);
            boolean is = productService.removeProduct(id);
            if (is) {
                list= productService.getProduct();
                req.setAttribute("list", list);
                req.getRequestDispatcher("admin.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
