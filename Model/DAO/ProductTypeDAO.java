package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.ProductType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDAO {
    postgresDB db = new postgresDB();
    public List<ProductType> getProductType() throws SQLException {
        List<ProductType> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
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
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into producttype(typename)" + "values (?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, loaisp);
            is = true;
            ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.executeUpdate(sql);

            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return is;
    }
    public ProductType getProductTypeByName(String loaisp) throws SQLException {
        ProductType u = new ProductType();
        try {
            Connection c = db.connectDB(); // connect
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
}
