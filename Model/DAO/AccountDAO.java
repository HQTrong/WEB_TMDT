package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    postgresDB db= new postgresDB();
    public Account getUser(String userName) throws SQLException {
        Account u = new Account();
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "select * from account where username=?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setUser(rs.getString(2));
                u.setPass(rs.getString(3));
                u.setPhone(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setAddress(rs.getString(6));
                u.setFullName(rs.getString(7));
                u.setPhanQuyen(rs.getString(8));
            }
            rs.close();
            c.close();

        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            // bat buoc dong
            db.closeBD();
        }
        return u;
    }
    public List<Account> getAccount() throws SQLException {
        List<Account> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from account;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Account u = new Account();
                u.setId(rs.getInt(1));
                u.setUser(rs.getString(2));
                u.setPass(rs.getString(3));
                u.setPhone(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setAddress(rs.getString(6));
                u.setFullName(rs.getString(7));
                u.setPhanQuyen(rs.getString(8));
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
    public boolean insertAccount(String userName, String pass,String phone, String email,String address, String fullname) throws SQLException {
       Account u = new Account();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into account(username,pass,phone,email,address,fullname)" + "values (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, fullname);
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
}
