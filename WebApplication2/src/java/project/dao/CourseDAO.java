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
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.DO.Account;
import project.DO.Course;
import project.config.SQL;

/**
 *
 * @author DA CUOI
 */
public class CourseDAO {

    public static int addCourse(Course cource) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer courseID = null;
        try {
            tx = session.beginTransaction();        
            courseID = (Integer) session.save(cource);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback(); 
            e.printStackTrace();
        } finally {
            session.close();
        }
        return courseID;
    }

    public static List<Course> getListCourseOfAccount(Account account) throws SQLException {
        List<Course> result = null;
        Connection conn = null;
        try {
            result = new ArrayList<>();
            conn = JDBC.connectDB();
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(SQL.GET_LIST_COURSE_OF_ACCOUNT);
            pstm.setInt(1, account.getIdaccount());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Course item = new Course();
                item.setId(rs.getInt("id"));
                item.setCourceName(rs.getString("cource_name"));
                item.setCourceImage(rs.getString("cource_image"));
                item.setCourceCreateDate(rs.getString("cource_create_date"));
                item.setField("field");
                result.add(item);
            }
            rs.close();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                conn.rollback();
            }
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, "error-CourseDAO.getListCourseOfAccount", ex);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }
}
