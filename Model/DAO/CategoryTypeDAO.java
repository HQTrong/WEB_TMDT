package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.CategoryType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
