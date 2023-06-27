package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.CustomerDAO;
import com.example.tmdt.Model.POJO.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    CustomerDAO dao = new CustomerDAO();
    public  boolean insertCustomer(String fullname, String address, String phone, String username) throws SQLException {
        boolean result = dao.insertCustomer(fullname, address, phone, username);
        return result==true ?result: false;
    }
    public List<Customer> getCustomer() throws  SQLException{
        List<Customer> list = dao.getCustomer();
        return !list.isEmpty() ? list : null;
    }
    public Customer getCustomerByID(int id) throws SQLException {
        Customer customer= dao.getCustomerByID(id);
        return customer!=null ? customer : null;
    }
}
