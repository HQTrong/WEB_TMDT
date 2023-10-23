package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.ProductTypeDAO;
import com.example.tmdt.Model.POJO.ProductType;

import java.sql.SQLException;
import java.util.List;

public class ProductTypeService {
    ProductTypeDAO dao = new ProductTypeDAO();

    public List<ProductType> getProductType() throws SQLException {
        List<ProductType> list = dao.getProductType();
        return !list.isEmpty() ? list : null;
    }
    public  boolean insertProductType(String loaisp) throws  SQLException{
        boolean result = dao.insertProductType(loaisp);
        return result==true ?result: false;
    }
    public ProductType getProductTypeByName(String loaisp) throws SQLException {
      ProductType category= dao.getProductTypeByName(loaisp);
        return  category != null ? category : null;
    }
}
