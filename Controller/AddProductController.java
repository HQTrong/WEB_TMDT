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

@WebServlet(name = "AddProduct", value = "/add")
public class AddProductController extends HttpServlet {
    ProductService productService= new ProductService();
    ProductTypeService productTypeService = new ProductTypeService();
    List<Product> list = new ArrayList<>();
    List<ProductType> listProductType = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            listProductType = productTypeService.getProductType();
            req.setAttribute("list", listProductType);
            req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            String tensp = req.getParameter("tensp");
            String giasp = req.getParameter("giasp");
            String anh = req.getParameter("anh");
            String mota = req.getParameter("mota");
            int idType= Integer.parseInt(req.getParameter("idType"));

            if(tensp!="" || giasp!="" || anh!=""||mota!="")
            {
                boolean is = productService.insertProduct(tensp,Integer.parseInt(giasp),anh,mota,idType);
                if(is)
                {
                    list= productService.getProduct();
                    String status = "Thêm thành công!!";
                    req.setAttribute("status", status);
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("admin.jsp").forward(req, resp);
                }else
                {
                    String status = "Thêm không thành công!!";
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                }
            }else
            {
                String status = "Thêm không thành công!!";
                req.setAttribute("status", status);
                req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
