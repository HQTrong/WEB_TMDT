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

@WebServlet(name="Add Type Product", value = "/addtype")
public class AddProductTypeController extends HttpServlet {
    ProductTypeService productTypeService = new ProductTypeService();
  ProductType productType = new ProductType();

    String status="";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ProductType> list = null;
            list= productTypeService.getProductType();
            req.setAttribute("list",list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("addTypeProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductType> list = new ArrayList<>();
        try {
        String loaisp = req.getParameter("loaisp");

        if(loaisp=="")
        {
           status="Vui lòng nhập đầu đủ thông tin.";
        }
        else
        {
            productType = productTypeService.getProductTypeByName(loaisp);
            if( productType.getTypeName() == null)
            {
                boolean is = productTypeService.insertProductType(loaisp);
                if(is)
                {
                    status="Thêm thành công.";
                }
                else
                {
                    status="Thêm không thành công. Vui long thử lại";
                }

            }
            else
            {
                status="Loại sản phẩm đã tồn tại";
            }
            list= productTypeService.getProductType();
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("list",list);
        req.setAttribute("status",status);
        req.getRequestDispatcher("addTypeProduct.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {

    }
}
