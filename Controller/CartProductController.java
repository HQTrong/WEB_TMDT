package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.CartService;
import com.example.tmdt.Model.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="CartProduct", value = "/cartproduct")
public class CartProductController extends HttpServlet {
    ProductService service= new ProductService();
    Product product = null;
    CartService cartService= new CartService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession session = req.getSession();
            String user= req.getParameter("username");
            // Lấy danh sách sản phẩm từ session
            List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
            // Kiểm tra nếu danh sách sản phẩm không tồn tại, tạo mới
            if (cartItems == null ) {
                cartItems = new ArrayList<>();
                //session.setAttribute("cartItems", cartItems);
            }
            // Lấy thông tin từ URL và thêm vào danh sách sản phẩm
            String name = req.getParameter("name");
            String gia= req.getParameter("price");
            String image = req.getParameter("image");
            product= service.getProductByName(name);
            int id= product.getId();

            if (gia == null) {
                String userName = (String) session.getAttribute("user");

                session.invalidate();

                HttpSession newSession = req.getSession(true);

                newSession.setAttribute("user", userName);

                resp.sendRedirect("cart.jsp");
                return;
            }
            else
            {
                int sl = 1;
                int price = Integer.parseInt(gia);
                boolean found = false;
                Product foundProduct = null;

                for (Product item : cartItems) {
                    if (item.getName().equals(name)) {
                        sl = item.getQuantity() + 1;
                        foundProduct = item;
                        found = true;
                        break;
                    }
                }

                if (found==true) {
                    cartItems.remove(foundProduct);
                    Product item = new Product(id,name,price,image,sl);
                    cartItems.add(item);
                } else {
                    Product item = new Product(id,name,price,image,1);
                    cartItems.add(item);
                }
            }
            session.setAttribute("cartItems", cartItems);
            req.getRequestDispatcher("/show").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
