package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.ShopDAO;
import com.example.tmdt.Model.POJO.Shop;

import java.sql.SQLException;

public class ShopService {
    private ShopDAO dao = new ShopDAO();
    public Shop getShop() throws SQLException {
        Shop shop = dao.getShop();
        return shop != null ? shop : null;
    }
    public  boolean updateShop(int id,String address,String time, String day) throws  SQLException{
        boolean result = dao.updateShop(id,address,time,day);
        return result == true ?result: false;
    }
}
