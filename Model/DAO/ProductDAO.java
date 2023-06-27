package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    postgresDB db = new postgresDB();
    public List<Product> getProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        Statement stmt = null;

        try {
            Connection c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from sanpham;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product u = new Product();
                u.setId(rs.getInt(1));
                u.setTen(rs.getString(2));
                u.setGia(rs.getInt(3));
                u.setAnh(rs.getString(4));
                u.setMota(rs.getString(5));
                u.setIdType(rs.getInt(6));
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
    public Product getProductByID(int id) throws SQLException {
        Product u = new Product();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from sanpham where id =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setTen(rs.getString(2));
                u.setGia(rs.getInt(3));
                u.setAnh(rs.getString(4));
                u.setMota(rs.getString(5));
                u.setIdType(rs.getInt(6));
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
    public Product getProductByName(String name) throws SQLException {
        Product u = new Product();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from sanpham where tensp =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setTen(rs.getString(2));
                u.setGia(rs.getInt(3));
                u.setAnh(rs.getString(4));
                u.setMota(rs.getString(5));
                u.setIdType(rs.getInt(6));
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
public  Product getProductByName_ID(String name, int ID) throws SQLException{
        Product u= new Product();
        try
        {
            Connection c = db.connectDB();
            PreparedStatement preparedStatement=null;
            String sql = "select * from sanpham where tensp =? and id= ?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,ID);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setTen(rs.getString(2));
                u.setGia(rs.getInt(3));
                u.setAnh(rs.getString(4));
                u.setMota(rs.getString(5));
                u.setIdType(rs.getInt(6));
            }
            rs.close();
            c.close();
        }catch (Throwable e)
        {
            e.printStackTrace();
        }finally {
            db.closeBD();
        }
        return  u;
}
public boolean insertProduct(String tensp, int giasp, String anh, String mota, int idType) throws SQLException {
        boolean is = false;
        try {
            Connection c = db.connectDB(); // connect
            String sql = "insert into sanpham(tensp,giasp,anh,mota,id_type)" + "values (?,?,?,?,?);";
            PreparedStatement preparedStatement = null;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, tensp);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setString(3, anh);
            preparedStatement.setString(4, mota);
            preparedStatement.setInt(5, idType);
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
    public boolean updateProduct(String tensp, int giasp, String anh, String mota, int id,int idType) throws SQLException {
        Product product = new Product();
        PreparedStatement preparedStatement = null;
        boolean is = false;
        try {
            Connection c = db.connectDB();
            String sql = "UPDATE sanpham\n" +
                    "SET tensp=?,giasp =?,anh=?,mota =?, id_type=?\n" +
                    "WHERE id=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, tensp);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setString(3, anh);
            preparedStatement.setString(4, mota);
            preparedStatement.setInt(5, idType);
            preparedStatement.setInt(6, id);
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
    public boolean removeProduct(int id) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;
        try {
            Connection c = db.connectDB();
            String sql = "delete from  sanpham where id=?;";
            is = true;
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
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
    public List<Product> getProductName(String name) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = "SELECT * FROM sanpham WHERE tensp LIKE ?";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product u = new Product();
                u.setId(rs.getInt(1));
                u.setTen(rs.getString(2));
                u.setGia(rs.getInt(3));
                u.setAnh(rs.getString(4));
                u.setMota(rs.getString(5));
                u.setIdType(rs.getInt(6));
                list.add(u);
            }
            rs.close();
            c.close();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            db.closeBD();
        }
        return list;
    }

}
