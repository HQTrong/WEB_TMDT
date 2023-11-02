package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    postgresDB db = new postgresDB();
    Connection c = null;
    public boolean insertCustomer(String fullname, String address, String phone, String username) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;
        try {
           c = db.connectDB(); // connect
            String sql = "insert into customer(fullname,address,phone,username)" + "values (?,?,?,?);";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, username);
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
    public List<Customer> getCustomer() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Statement stmt = null;

        try {
             c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from customer;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
               Customer u = new Customer();
                u.setId(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setAddress(rs.getString(3));
                u.setPhone(rs.getString(4));
                u.setUsername(rs.getString(5));

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
    public Customer getCustomerByID(int id) throws SQLException {
        Customer u = new Customer();
        try {
            c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from customer where id =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setAddress(rs.getString(3));
                u.setPhone(rs.getString(4));
                u.setUsername(rs.getString(5));
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
