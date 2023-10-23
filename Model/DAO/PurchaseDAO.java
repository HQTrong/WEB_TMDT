package com.example.tmdt.Model.DAO;

import com.example.tmdt.Client.postgresDB;
import com.example.tmdt.Model.POJO.Purchase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO {
    postgresDB db = new postgresDB();
    public List<Purchase> getPurchase(String username) throws SQLException {
        Statement stmt = null;
        List<Purchase> list= new ArrayList<>();
        try {
            Connection c = db.connectDB(); // connect
            PreparedStatement preparedStatement = null;
            String sql ="select ct.fullname , ct.address , ct.phone ,t.total,t.id,ca.id ,ca.price ,ca.quantity ,ca.name ,p.img \n" +
                    "from customer ct inner join tborder t on ct.id =t.id_customer \n" +
                    "inner join cart ca on ca.idorder = t.id inner join product p on ca.idproduct=p.id and ct.username = ?;";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Purchase u = new Purchase();
                u.setFullName(rs.getString(1));
                u.setAddress(rs.getString(2));
                u.setPhone(rs.getString(3));
                u.setTotal(rs.getInt(4));
                u.setOrderId(rs.getInt(5));
                u.setCartId(rs.getInt(6));
                u.setPrice(rs.getInt(7));
                u.setQuantity(rs.getInt(8));
                u.setProductName(rs.getString(9));
                u.setImg(rs.getString(10));
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
