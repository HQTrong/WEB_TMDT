package com.example.tmdt.Controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
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
    List<Product> list = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String input = req.getParameter("Id");
            int id = Integer.parseInt(input.substring(0, input.indexOf(",")));
            String url = input.substring(input.indexOf(",") + 1);
            url = url.replace(".jpg", "");
            int startIndex = url.indexOf("E");
            String publicId = url.substring(startIndex);
            cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            cartService.removeCart(id);
            boolean is = productService.removeProduct(id);
            if (is) {
                list= productService.getProduct();
                req.setAttribute("listProduct", list);
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
