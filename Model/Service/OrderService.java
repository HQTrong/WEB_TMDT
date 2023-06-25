package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.OrderDAO;
import com.example.tmdt.Model.POJO.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    OrderDAO dao = new OrderDAO();
    public boolean insertOrder(String userName, int thanhTien,String fullname) throws SQLException {
            boolean order = dao.insertOrder(userName,thanhTien,fullname);
            return order == true ? order : false;
    }
    public List<Order> getOrder() throws  SQLException{
        List<Order> list = dao.getOrder();
        return !list.isEmpty() ? list : null;
    }
    public  Order getOrderID(int id) throws  SQLException{
        Order order = dao.getOrderID(id);
        return  order!=null ?order: null;
    }
}
