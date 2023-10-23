package com.example.tmdt.Model.Service;

import com.example.tmdt.Model.DAO.AccountDAO;
import com.example.tmdt.Model.POJO.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountService {
    AccountDAO dao = new AccountDAO();

    public Account getUser(String userName) throws SQLException {
        Account user = dao.getUser(userName);
        return user != null ? user : null;
    }

    public List<Account> getAccount() throws SQLException {
        List<Account> list = dao.getAccount();
        return list != null ? list : null;
    }

    public boolean insertAccount(String userName, String pass, String email) throws SQLException {

        Account user = dao.getUser(userName);

        if ((user.getUser()) == null) {
            boolean account = dao.insertAccount(userName, pass, email);

            return account == true ? account : false;
        }
        return false;
    }

    public  boolean updateAccount(String username,String password, String email) throws  SQLException{
        boolean result = dao.updateAccount(username,password,email);
        return result == true ?result: false;
    }

}
