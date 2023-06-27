package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.CategoryType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryTypeDAO {
    postgresDB db = new postgresDB();
    public List<CategoryType> getCategoryType() throws SQLException {
        List<CategoryType> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from categorytype;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CategoryType u = new CategoryType();
                u.setId(rs.getInt(1));
                u.setLoaisp(rs.getString(2));
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
            String sql = "insert into categorytype(loaisp)" + "values (?);";
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
    public CategoryType getCategoryByName(String loaisp) throws SQLException {
        CategoryType u = new CategoryType();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from categorytype where loaisp =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, loaisp);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setLoaisp(rs.getString(2));
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
