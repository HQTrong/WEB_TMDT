package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.ProductDAO;
import com.example.tmdt.Model.POJO.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    ProductDAO dao= new ProductDAO();
    public List<Product> getProduct() throws SQLException {
        List<Product> list = dao.getProduct();
        return !list.isEmpty() ? list : null;
    }
    public Product getProductByID(int id) throws SQLException {
        Product product= dao.getProductByID(id);
        return product!=null ? product : null;
    }
    public Product getProductByName(String name) throws SQLException {
        Product product= dao.getProductByName(name);
        return product != null? product : null;
    }
    public  Product getProductByName_ID(String name, int ID) throws SQLException{
        Product product = dao.getProductByName_ID(name,ID);
        return  product != null ? product : null;
    }
    public  boolean insertProduct(String tesnsp, int giasp, String anh, String mota) throws  SQLException{
        boolean result = dao.insertProduct(tesnsp,giasp,anh,mota);
        return result==true ?result: false;
    }
    public  boolean updateProduct(String tesnsp, int giasp, String anh, String mota, int id) throws  SQLException{
        boolean result = dao.updateProduct(tesnsp,giasp,anh,mota,id);
        return result==true ?result: false;
    }
    public  boolean removeProduct(int id) throws  SQLException{
        boolean result = dao.removeProduct(id);
        return result==true ?result: false;
    }
}
