package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Shop;

import java.sql.*;

public class ShopDAO {
    postgresDB db = new postgresDB();
    public Shop getShop() throws SQLException {
        Shop u = new Shop();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from shop;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setAddress(rs.getString(2));
                u.setTime(rs.getString(3));
                u.setDay((rs.getString(4)));
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
        return u;
    }
    public boolean updateShop(int id, String address, String time, String day) throws SQLException {
        Shop shop = new Shop();
        PreparedStatement preparedStatement = null;
        boolean is = false;
        try {
            Connection c = db.connectDB();
            String sql = "UPDATE shop SET address=?,time =?, openday=? WHERE id=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, address);
            preparedStatement.setString(2, time);
            preparedStatement.setString(3, day);
            preparedStatement.setInt(4, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return is;
    }
}
