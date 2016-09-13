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
import project.DO.Account;
import project.DO.Course;
import project.config.SQL;

/**
 *
 * @author DA CUOI
 */
public class CourseDAO {
    public static List<Course> getListCourseOfAccount(Account account) throws SQLException{
        List<Course> result = null;
        Connection conn = null;
        try {
            result = new ArrayList<>();
            conn = JDBC.connectDB();
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(SQL.GET_LIST_COURSE_OF_ACCOUNT);
            pstm.setInt(1, account.getIdaccount());
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Course item = new Course();
                item.setId(rs.getInt("id"));
                item.setCourceName(rs.getString("cource_name"));
                item.setCourceImage(rs.getString("cource_image"));
                item.setField("cource_create_date");
                item.setField("field");
                result.add(item);
            }
            rs.close();
            conn.commit();
        } catch (SQLException ex) {          
            if(conn != null) conn.rollback();          
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, "error-CourseDAO.getListCourseOfAccount", ex);
        } finally {
            if(conn != null) conn.close();
        }
        return result;
    }
}
