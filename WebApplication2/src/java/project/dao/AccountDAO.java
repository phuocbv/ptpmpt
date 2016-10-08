/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import project.DO.Account;
import project.DO.Course;
import project.config.*;

/**
 *
 * @author DA CUOI
 */
public class AccountDAO {

    //admin
    //them tai khoan nguoi dung
    public static int addAccountInfo(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer result = -1;
        try {
            tx = session.beginTransaction();
            result = (Integer) session.save(account);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result.intValue();
    }
    
    public static Account getAccountByUsername(Account account) {
        Account result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Account WHERE username = :username AND password = :password");
            query.setParameter("username", account.getUsername());
            query.setParameter("password", account.getPassword());
            List list = query.list();
            if (list != null && list.size() > 0) {
                result = (Account) list.get(0);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static Account getAccount(Account account) {
        Account result = null;
        String sql = "SELECT * FROM account";
        ResultSet rs = null;
        try {
            result = new Account();
            rs = JDBC.selectSQL(sql);
            while (rs.next()) {
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

     //admin
    //lay danh sach tai khoan duoc tao boi nguoi quan tri tuong ung voi id truyen vao
    public static List<Account> getListAccountCreatedByAdmin(Account adminCurrent) {
        List<Account> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Account WHERE column1 = :column1 AND column2 = :column2");
            query.setParameter("column1", "user");
            query.setParameter("column2", adminCurrent.getIdaccount().toString());
            list = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    
   
    
    //admin
    //lay danh sach cac tai khoan chua tham gia khoa hoc co id chuyen vao
    //duoc tao boi nguoi quan tri tuong ung
    public static List<Account> getListAccountUserByAdminCreate(Account adminCurrent, Course courseCurrent) throws SQLException {
        List<Account> list = null;
        Connection conn = null;
        try {
            list = new ArrayList<>();
            conn = JDBC.connectDB();
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(SQL.GET_LIST_ACCOUNT_NOT_ATTEND_COURSE);
            pstm.setInt(1, adminCurrent.getIdaccount());
            pstm.setInt(2, adminCurrent.getIdaccount());
            pstm.setInt(3, courseCurrent.getIdcourse());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Account item = new Account();
                item.setIdaccount(rs.getInt("idaccount"));
                item.setUsername(rs.getString("username"));
                item.setPassword(rs.getString("password"));
                item.setAccountName(rs.getString("account_name"));
                item.setCreateDate(rs.getString("create_date"));
                item.setColumn1(rs.getString("column1"));
                item.setColumn2(rs.getString("column2"));
                list.add(item);
            }
            rs.close();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, "error-getListAccountUserByAdminCreate", ex);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    //admin va user
    //lay danh sach tai khoan da tham gia khoa hoc nhung chua duoc chia se tai lieu
    public static List<Account> getListAccountAttendedCourseNotShared(Account adminCurrent, Course courseCurrent) throws SQLException {
        List<Account> list = null;
        Connection conn = null;
        try {
            list = new ArrayList<>();
            conn = JDBC.connectDB();
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(SQL.GET_LIST_ACCOUNT_ATTENDED_COURSE_NOT_SHARED);
            pstm.setInt(1, courseCurrent.getIdcourse());
            pstm.setInt(2, adminCurrent.getIdaccount());
            pstm.setInt(3, 0);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Account item = new Account();
                item.setIdaccount(rs.getInt("idaccount"));
                item.setUsername(rs.getString("username"));
                item.setPassword(rs.getString("password"));
                item.setAccountName(rs.getString("account_name"));
                item.setCreateDate(rs.getString("create_date"));
                item.setColumn1(rs.getString("column1"));
                item.setColumn2(rs.getString("column2"));
                list.add(item);
            }
            rs.close();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, "error-getListAccountUserByAdminCreate", ex);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
}
