package com.example.tmdt.Controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.POJO.ProductType;
import com.example.tmdt.Model.Service.ProductService;
import com.example.tmdt.Model.Service.ProductTypeService;
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

@WebServlet(name = "AddProduct", value = "/add")
@MultipartConfig
public class AddProductController extends HttpServlet {
    ProductService productService= new ProductService();
    ProductTypeService productTypeService = new ProductTypeService();
    List<Product> list = new ArrayList<>();
    List<ProductType> listProductType = new ArrayList<>();


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
        try {
            listProductType = productTypeService.getProductType();
            req.setAttribute("listProductType", listProductType);
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
            String mota = req.getParameter("mota");
            int idType= Integer.parseInt(req.getParameter("idType"));
            Part filePart = req.getPart("anh");
            if(!tensp.isEmpty() || !giasp.isEmpty() || !mota.isEmpty()) {

                String contentType = filePart.getContentType();
                if (contentType.startsWith("image/") && (contentType.endsWith("jpg") || contentType.endsWith("jpeg") || contentType.endsWith("png"))) {
                    byte[] fileBytes = new byte[(int) filePart.getSize()];
                    try (InputStream is = filePart.getInputStream()) {
                        is.read(fileBytes);
                    }

                    String folder = "Ecommerce/";

                    Map<?, ?> uploadResult = cloudinary.uploader().upload(fileBytes,
                            ObjectUtils.asMap("public_id", folder + "unique_id_for_uploaded_image"));
                    String imageUrl = (String) uploadResult.get("url");

                    boolean is = productService.insertProduct(tensp, Integer.parseInt(giasp), imageUrl, mota, idType);

                    if (is) {
                        list = productService.getProduct();
                        String status = "Thêm thành công!!";
                        req.setAttribute("status", status);
                        req.setAttribute("listProduct", list);
                        req.getRequestDispatcher("admin.jsp").forward(req, resp);
                    } else {
                        String status = "Thêm không thành công!!";
                        listProductType = productTypeService.getProductType();
                        req.setAttribute("listProductType", listProductType);
                        req.setAttribute("status", status);
                        req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                    }
                } else {
                    // Handle the case where the uploaded file is not an image with allowed extensions
                    String status = "Vui lòng tải lên một tệp hình ảnh có định dạng .jpg hoặc .png.";
                    listProductType = productTypeService.getProductType();
                    req.setAttribute("listProductType", listProductType);
                    req.setAttribute("status", status);
                    req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                }
        }
            else
        {
            String status = "Thêm không thành công!!";
            listProductType = productTypeService.getProductType();
            req.setAttribute("listProductType", listProductType);
            req.setAttribute("status", status);
            req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
        }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
