package com.example.tmdt.Controller;

import com.example.tmdt.Model.POJO.Account;
import com.example.tmdt.Model.POJO.Customer;
import com.example.tmdt.Model.POJO.Order;
import com.example.tmdt.Model.POJO.Product;
import com.example.tmdt.Model.Service.AccountService;
import com.example.tmdt.Model.Service.CartService;
import com.example.tmdt.Model.Service.CustomerService;
import com.example.tmdt.Model.Service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name="Order", value = "/donhang")
public class OrderController extends HttpServlet {
    AccountService accountService= new AccountService();
    CustomerService customerService = new CustomerService();
    OrderService orderService = new OrderService();
    CartService cartService= new CartService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            List<Integer> quantityList = new ArrayList<>();
            String fullname= req.getParameter("fullname");
            String address= req.getParameter("address");
            String phone= req.getParameter("phone");
            String username = req.getParameter("username");
            String soLuong = req.getParameter("soLuong");
            List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");
            if(soLuong=="")
            {
                req.getRequestDispatcher("show").forward(req,resp);
            }
            else
            {
                String[] listSL = soLuong.split(",");
                int i = 0;
                Iterator<Product> iterator = cartItems.iterator();
                while (iterator.hasNext()) {
                    Product product = iterator.next();
                    if (i < listSL.length) {
                        int number = Integer.parseInt(listSL[i]);
                        product.setSoLuong(number);
                        if (product.getSoLuong() == 0) {
                            iterator.remove(); // Remove the current element using the iterator
                        }
                    }
                    i++;
                }
            }

            int thanhTien= Integer.parseInt(req.getParameter("tongTien"));

            Account account =accountService.getUser(username);
            if(username!=null)
            {
                if(thanhTien==0)
                {
                    req.getRequestDispatcher("show").forward(req,resp);
                }
                else
                {
                    if(fullname!="" || phone!=""||address!="" )
                    {
                        customerService.insertCustomer(fullname,address,phone,username);
                        List<Customer> customerList = customerService.getCustomer();
                        String lastCustomerId = null;
                        if (!customerList.isEmpty()) {
                            Customer lastCustomer = customerList.get(customerList.size() - 1);
                            lastCustomerId = String.valueOf(lastCustomer.getId());
                        }
                        orderService.insertOrder(thanhTien,Integer.parseInt(lastCustomerId));
                        List<Order> orderList = orderService.getOrder();
                        String lastOrderId = null;
                        if (!orderList.isEmpty()) {
                            Order lastOrder = orderList.get(orderList.size() - 1);
                            lastOrderId = String.valueOf(lastOrder.getId());
                        }
                        for (Product item: cartItems) {
                            cartService.insertCart(item.getId(),item.getGia(),Integer.parseInt(lastOrderId),item.getSoLuong(),item.getTen());
                        }

                        session.invalidate();
                        HttpSession newSession = req.getSession(true);
                        newSession.setAttribute("user",username);
                        req.setAttribute("fullname",fullname);
                        req.setAttribute("phone",phone);
                        req.setAttribute("address",address);
                        req.setAttribute("cart",cartItems);
                        req.setAttribute("tongtien",thanhTien);
                        req.getRequestDispatcher("bill.jsp").forward(req,resp);
                    }
                    else
                    {
                        req.getRequestDispatcher("cart.jsp").forward(req,resp);
                    }

                }
            }
            else
            {
                String status="Vui lòng đăng nhập trước khi mua hàng";
                req.setAttribute("status", status);
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void destroy() {
    }
}
