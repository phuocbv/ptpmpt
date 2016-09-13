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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import project.DO.*;
import project.dao.CourseDAO;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name="homeController")
@SessionScoped
public class HomeController {
    
    private Account account;
    private String username;
    private List<Course> listCourse = null;
    public HomeController(){
        FacesContext context = FacesContext.getCurrentInstance();
        account = (Account) context.getExternalContext().getSessionMap().get("account");
        
        try {
            listCourse = CourseDAO.getListCourseOfAccount(account);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        username = account.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }
    
    
}
