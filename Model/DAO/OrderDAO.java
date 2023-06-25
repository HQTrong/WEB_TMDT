package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    postgresDB db = new postgresDB();
    public boolean insertOrder( String username, int thanhTien, String fullname) throws SQLException {
        Order u = new Order();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into donhang(username,thanhtien,fullname)" + "values (?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, thanhTien);
            preparedStatement.setString(3, fullname);
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

            String sql = "select * from donhang;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order u = new Order();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setThanhTien(rs.getInt(3));
                u.setFullName(rs.getString(4));
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
            String sql = " select * from donhang where id_donhang =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setThanhTien(rs.getInt(3));
                u.setFullName(rs.getString(4));
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
