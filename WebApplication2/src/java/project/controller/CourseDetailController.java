/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import project.DO.Account;
import project.DO.Course;
import project.DO.ShareCourse;
import project.config.CONFIG;
import project.dao.AccountDAO;
import project.dao.ShareCourseDAO;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name ="courseDetailController")
@ViewScoped
public class CourseDetailController {
    public int courseId;
    private Account account;
    private boolean cloned;
    private List<Account> listMemberNotShareCourse;
    private List<String> listIdMemberNotShareCouse;
    
    public CourseDetailController() {
        FacesContext context = FacesContext.getCurrentInstance();
        account = (Account) context.getExternalContext().getSessionMap().get(CONFIG.SESSION_NAME_OF_ADMIN);
        
    }
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
        if(courseId > 0){
            ShareCourse shareCourse = ShareCourseDAO.getShareCourseByIdAccountAndIdCourse(account.getIdaccount(), courseId);
            cloned = shareCourse.getCloned().equals("yes") ? true : false;
            Account account = new Account();
            account.setIdaccount(shareCourse.getIdAccountCreate());
            Course course = new Course();
            course.setIdcourse(shareCourse.getIdCourse());
            
            try {
                listMemberNotShareCourse = AccountDAO.getListAccountAttendedCourseNotShared(account, course);
            } catch (SQLException ex) {
                Logger.getLogger(CourseDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Account> getListMemberNotShareCourse() {
        if(listMemberNotShareCourse == null) listMemberNotShareCourse = new ArrayList<>();
        return listMemberNotShareCourse;
    }

    public void setListMemberNotShareCourse(List<Account> listMemberNotShareCourse) {
        this.listMemberNotShareCourse = listMemberNotShareCourse;
    }

    public List<String> getListIdMemberNotShareCouse() {
        if(listIdMemberNotShareCouse == null) listIdMemberNotShareCouse = new ArrayList<>();
        return listIdMemberNotShareCouse;
    }

    public void setListIdMemberNotShareCouse(List<String> listIdMemberNotShareCouse) {
        this.listIdMemberNotShareCouse = listIdMemberNotShareCouse;
    }

    public boolean isCloned() {
        return cloned;
    }

    public void setCloned(boolean cloned) {
        this.cloned = cloned;
    }
    
    
}
