package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    postgresDB db = new postgresDB();
    Connection c= null;
    public boolean insertCart( int idSanPham, int giasp, int idDonHang,int soLuong, String tensp) throws SQLException {
        Cart u = new Cart();
        PreparedStatement preparedStatement = null;
        boolean is = false;
        try {
          c = db.connectDB(); // connect
            String sql = "insert into cart(idproduct,price,idorder,quantity,name)" + "values (?,?,?,?,?);";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setInt(3, idDonHang);
            preparedStatement.setInt(4, soLuong);
            preparedStatement.setString(5, tensp);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                is = true;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (c != null) {
                c.close();
            }
            // bat buoc dong
            db.closeBD();
        }
        return is;

    }
    public List<Cart> getCartByID(int idDonHang) throws SQLException {
        Statement stmt = null;
        List<Cart> list= new ArrayList<>();
        try {
             c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from cart where idorder =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idDonHang);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cart u = new Cart();
                u.setId(rs.getInt(1));
                u.setIdProduct(rs.getInt(2));
                u.setPrice(rs.getInt(3));
                u.setIdOrder(rs.getInt(4));
                u.setQuantity(rs.getInt(5));
                u.setName(rs.getString(6));

                list.add(u);
            }
            rs.close();
            //stmt.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return list;
    }

    public List<Cart> getCart() throws SQLException {
        Statement stmt = null;
        List<Cart> list= new ArrayList<>();
        try {
             c = db.connectDB(); // connect
            stmt = c.createStatement();
            String sql ="select * from cart;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cart u = new Cart();
                u.setId(rs.getInt(1));
                u.setIdProduct(rs.getInt(2));
                u.setPrice(rs.getInt(3));
                u.setIdOrder(rs.getInt(4));
                u.setQuantity(rs.getInt(5));
                u.setName(rs.getString(6));
                list.add(u);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return list;
    }
    public boolean removeCart(int idSanPham) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;
        c = db.connectDB();
        try {
            String sql = "delete from  cart where idproduct=?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                is = true;
            }

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (c != null) {
                c.close();
            }
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }
}
