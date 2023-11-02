package com.example.tmdt.Controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.tmdt.Model.POJO.ProductType;
import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.ProductTypeService;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UpdateProduct", value = "/update")
@MultipartConfig
public class UpdateProductController extends HttpServlet {
    ProductTypeService productTypeService = new ProductTypeService();
    List<ProductType> listProductType = new ArrayList<>();
    List<Product> list = new ArrayList<>();
    ProductService productService= new ProductService();
    private Cloudinary cloudinary = new Cloudinary();

    @Override
    public void init() throws ServletException {
        super.init();

        // Thay thế bằng thông tin của tài khoản Cloudinary của bạn
        String cloudName = "diey7k1oh";
        String apiKey = "949436371279646";
        String apiSecret = "vG8OuytO64c4Y_JKcTPATmJiiSs";

        cloudinary.config.cloudName = cloudName;
        cloudinary.config.apiKey = apiKey;
        cloudinary.config.apiSecret = apiSecret;

        this.cloudinary = cloudinary;
    }
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
            String mota = req.getParameter("mota");
            int idType = Integer.parseInt(req.getParameter("idType"));
            Part filePart = req.getPart("anh");
            String imageUrl= null;
            int a = (int) filePart.getSize();
                String contentType = filePart.getContentType();
                if (contentType.startsWith("image/") && (contentType.endsWith("jpg") || contentType.endsWith("jpeg") || contentType.endsWith("png"))) {
                    byte[] fileBytes = new byte[(int) filePart.getSize()];
                    try (InputStream is = filePart.getInputStream()) {
                        is.read(fileBytes);
                    }
                    String folder = "Ecommerce/" + UUID.randomUUID().toString();

                    Map<?, ?> uploadResult = cloudinary.uploader().upload(fileBytes,
                            ObjectUtils.asMap("public_id", folder));
                    imageUrl = (String) uploadResult.get("url");

            }else {
                    imageUrl = req.getParameter("oldImg");
                }
                    boolean is = productService.updateProduct(tensp,giasp,imageUrl,mota,id,idType);
                    if (is) {
                        list = productService.getProduct();
                        req.setAttribute("listProduct", list);
                        req.getRequestDispatcher("admin.jsp").forward(req, resp);
                    } else {
                        String status = "Cập nhật thất bại";
                        Product product = productService.getProductByID(id);
                        listProductType = productTypeService.getProductType();
                        req.setAttribute("list", listProductType);
                        req.setAttribute("status", status);
                        req.setAttribute("product",product);
                        req.getRequestDispatcher("updateProduct.jsp").forward(req,resp);
                    }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
