package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Complaint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComplaintDAO {
    postgresDB db = new postgresDB();
    public boolean insertComplaint(String username,String phone, String complaint) throws SQLException {
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into comment(username,phone,comment)" + "values (?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,phone);
            preparedStatement.setString(3, complaint);
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
    public List<Complaint> getComplaint() throws SQLException {
        List<Complaint> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from comment;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Complaint u = new Complaint();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPhone(rs.getString(3));
                u.setComplaint(rs.getString(4));
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
