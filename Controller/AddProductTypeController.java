package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.CategoryType;
import com.example.tmdt.Model.Service.CategoryService;
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
    CategoryService categoryService = new CategoryService();
  CategoryType categoryType= new CategoryType();

    String status="";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<CategoryType> list = null;
            list= categoryService.getCategoryType();
            req.setAttribute("list",list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("addTypeProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CategoryType> list = new ArrayList<>();
        try {
        String loaisp = req.getParameter("loaisp");

        if(loaisp=="")
        {
           status="Vui lòng nhập đầu đủ thông tin.";
        }
        else
        {
            categoryType=categoryService.getCategoryByName(loaisp);
            if( categoryType.getLoaisp() == null)
            {
                boolean is = categoryService.insertProducTypet(loaisp);
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
            list= categoryService.getCategoryType();
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
