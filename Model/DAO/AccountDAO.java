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
                u.setEmail(rs.getString(4));
                u.setRole(rs.getString(5));
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
                u.setEmail(rs.getString(4));
                u.setRole(rs.getString(5));
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
    public boolean insertAccount(String userName, String pass, String email) throws SQLException {
       Account u = new Account();
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into account(username,pass,email)" + "values (?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, pass);
            preparedStatement.setString(3, email);
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
    public boolean updateAccount(String username,String password, String email) throws SQLException {
        Account account = new Account();
        PreparedStatement preparedStatement = null;
        boolean is = false;
        try {
            Connection c = db.connectDB();
            String sql = "UPDATE account SET pass=?,email =? WHERE username=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,username);
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
