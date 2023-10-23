package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    postgresDB db = new postgresDB();
    public boolean insertOrder( int thanhTien, int idCustomer) throws SQLException {
        Order u = new Order();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into tborder(total,id_customer)" + "values (?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, thanhTien);
            preparedStatement.setInt(2, idCustomer);
            is = true;
            ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.executeUpdate(sql);

            rs.close();
            c.close();


        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }
    public List<Order> getOrder() throws SQLException {
        List<Order> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from tborder;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order u = new Order();
                u.setId(rs.getInt(1));
                u.setTotal(rs.getInt(2));
                u.setIdCustomer(rs.getInt(3));
                list.add(u);
            }
            rs.close();
            stmt.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return list;
    }
    public Order getOrderID(int id) throws SQLException {
        Statement stmt = null;
        Order u = new Order();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from tborder where id =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setTotal(rs.getInt(2));
                u.setIdCustomer(rs.getInt(3));
            }
            rs.close();
            //stmt.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return u;
    }
}
