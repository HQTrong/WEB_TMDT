package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    postgresDB db = new postgresDB();
    Connection c =null;
    public List<Product> getProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        Statement stmt = null;

        try {
             c = db.connectDB(); // connect
            stmt = c.createStatement();

            String sql = "select * from product order by id asc ;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product u = new Product();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
            String sql = " select * from product where id =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
            String sql = " select * from product where name =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
            String sql = "select * from product where name =? and id= ?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,ID);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
    PreparedStatement preparedStatement = null;
        try {
            c = db.connectDB(); // connect
            String sql = "insert into product(name,price,img,description,id_type)" + "values (?,?,?,?,?);";

            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, tensp);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setString(3, anh);
            preparedStatement.setString(4, mota);
            preparedStatement.setInt(5, idType);
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
    public boolean updateProduct(String tensp, int giasp, String anh, String mota, int id,int idType) throws SQLException {
        Product product = new Product();
        PreparedStatement preparedStatement = null;
        boolean is = false;

        try {
            c = db.connectDB();
            String sql = "UPDATE product\n" +
                    "SET name=?,price =?,img=?,description =?, id_type=?\n" +
                    "WHERE id=?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, tensp);
            preparedStatement.setInt(2, giasp);
            preparedStatement.setString(3, anh);
            preparedStatement.setString(4, mota);
            preparedStatement.setInt(5, idType);
            preparedStatement.setInt(6, id);
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
    public boolean removeProduct(int id) throws SQLException {
        boolean is = false;
        PreparedStatement preparedStatement = null;

        try {
            c = db.connectDB();
            String sql = "delete from product where id=?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
            // bat buoc dong
            db.closeBD();
        }
        return is;
    }
    public List<Product> getProductName(String name) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
             c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = "SELECT * FROM product WHERE name LIKE ?";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product u = new Product();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
    public List<Product> getProductByIdType(int idType) throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
             c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql = " select * from product where id_type =?; ";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, idType);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product u = new Product();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPrice(rs.getInt(3));
                u.setImg(rs.getString(4));
                u.setDescription(rs.getString(5));
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
