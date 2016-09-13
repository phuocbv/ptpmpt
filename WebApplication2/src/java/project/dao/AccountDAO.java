/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import project.DO.Account;

/**
 *
 * @author DA CUOI
 */
public class AccountDAO {
    public static Account getAccountByUsername(Account account){
        Account result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = null;
        try{
           tx = session.beginTransaction();
           Query query = session.createQuery("FROM Account WHERE username = :username AND password = :password");
           query.setParameter("username", account.getUsername());
           query.setParameter("password", account.getPassword());
           List list = query.list();
           if(list != null && list.size() > 0){
               result = (Account) list.get(0);
           }
           tx.commit();
        }catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close();
        }
        return result;
    }
    
    public static Account getAccount(Account account){
        Account result = null;
        String sql = "SELECT * FROM account";
        ResultSet rs = null;
        try {
            result = new Account();
            rs = JDBC.selectSQL(sql);
            while(rs.next()){
                result.setIdaccount(rs.getInt("idaccount"));
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
            }
            rs.close();
            JDBC.commit();
        } catch (SQLException ex) {
            JDBC.rollback();
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            JDBC.closeConnect();
        }
        return result;
    }
}
