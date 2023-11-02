package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.ProductType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDAO {
    postgresDB db = new postgresDB();
    Connection c = null;
    public List<ProductType> getProductType() throws SQLException {
        List<ProductType> list = new ArrayList<>();
        Statement stmt = null;

        try {
            c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from producttype order by  id asc;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ProductType u = new ProductType();
                u.setId(rs.getInt(1));
                u.setTypeName(rs.getString(2));
                // u.setMota(rs.getString(3));
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
    public boolean insertProductType(String loaisp) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;
        try {
            c = db.connectDB(); // connect
            String sql = "insert into producttype(typename)" + "values (?);";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, loaisp);
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
            db.closeBD();
        }
        return is;
    }
    public ProductType getProductTypeByName(String loaisp) throws SQLException {
        ProductType u = new ProductType();
        try {
             c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from producttype where typename =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, loaisp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setTypeName(rs.getString(2));
            }
            rs.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return u;
    }

    public boolean updateProductType(int id, String name) throws SQLException {
        ProductType productType = new ProductType();
        PreparedStatement preparedStatement = null;
        boolean is = false;

        try {
            c = db.connectDB();
            String sql = "UPDATE producttype\n" +
                    "SET typename=?\n" +
                    "WHERE id=?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
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
            db.closeBD();
        }
        return is;
    }
}
