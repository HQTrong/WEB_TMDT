package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    postgresDB db = new postgresDB();
    public boolean insertCart( int idSanPham, int giasp, int idDonHang,int soLuong, String tensp) throws SQLException {
        Cart u = new Cart();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into cart(id_sanpham,giasp,id_donhang,soluong,tensp)" + "values (?,?,?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idSanPham);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setInt(3, idDonHang);
            preparedStatement.setInt(4, soLuong);
            preparedStatement.setString(5, tensp);

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
    public List<Cart> getCartByID(int idDonHang) throws SQLException {
        Statement stmt = null;
        List<Cart> list= new ArrayList<>();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from cart where id_donhang =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idDonHang);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cart u = new Cart();
                u.setIdCart(rs.getInt(1));
                u.setIdProduct(rs.getInt(2));
                u.setGiasp(rs.getInt(3));
                u.setIdDonHang(rs.getInt(4));
                u.setSoLuong(rs.getInt(5));
                u.setTensp(rs.getString(6));

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
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();
            String sql ="select * from cart ; ";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cart u = new Cart();
                u.setIdCart(rs.getInt(1));
                u.setIdProduct(rs.getInt(2));
                u.setGiasp(rs.getInt(3));
                u.setIdDonHang(rs.getInt(4));
                u.setSoLuong(rs.getInt(5));
                u.setTensp(rs.getString(6));
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
}
