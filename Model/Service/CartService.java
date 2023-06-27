package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.CartDAO;
import com.example.tmdt.Model.POJO.Cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {

    CartDAO dao = new CartDAO();
   List<Integer> list = new ArrayList<>();

    public boolean insertCart(int idSanPham, int giasp, int idDonHang, int soLuong ,String tensp) throws SQLException {
        boolean is = dao.insertCart(idSanPham,giasp,idDonHang,soLuong,tensp);
        return is == true ? is : false;
    }
    public List<Cart> getCartByID(int idDonHang) throws SQLException{
        List<Cart> list = dao.getCartByID(idDonHang);
        return !list.isEmpty()? list:null;
    }
    public List<Cart> getCart() throws SQLException{
        List<Cart> list = dao.getCart();
        return !list.isEmpty()? list:null;
    }
    public  boolean removeCart(int idSanPham) throws  SQLException{
        boolean result = dao.removeCart(idSanPham);
        return result==true ?result: false;
    }
}
