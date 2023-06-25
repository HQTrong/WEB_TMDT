package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.ComplaintDAO;
import com.example.tmdt.Model.POJO.Complaint;

import java.sql.SQLException;
import java.util.List;

public class ComplaintService {
    ComplaintDAO dao = new ComplaintDAO();
    public  boolean insertComplaint(String username, String phone, String complaint) throws SQLException {
        boolean result = dao.insertComplaint(username,phone,complaint);
        return result==true ?result: false;
    }
    public List<Complaint> getComplaint() throws SQLException {
        List<Complaint> list = dao.getComplaint();
        return !list.isEmpty() ? list : null;
    }
}
