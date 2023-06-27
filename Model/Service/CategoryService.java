package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.CategoryTypeDAO;
import com.example.tmdt.Model.POJO.CategoryType;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    CategoryTypeDAO dao = new CategoryTypeDAO();

    public List<CategoryType> getCategoryType() throws SQLException {
        List<CategoryType> list = dao.getCategoryType();
        return !list.isEmpty() ? list : null;
    }
    public  boolean insertProducTypet(String loaisp) throws  SQLException{
        boolean result = dao.insertProductType(loaisp);
        return result==true ?result: false;
    }
    public CategoryType getCategoryByName(String loaisp) throws SQLException {
      CategoryType category= dao.getCategoryByName(loaisp);
        return  category != null ? category : null;
    }
}
