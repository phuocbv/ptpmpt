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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import project.DO.Account;
import project.DO.Course;
import project.DO.Index;
import project.DO.ShareCourse;
import project.config.CONFIG;
import project.dao.AccountDAO;
import project.dao.IndexDAO;
import project.dao.ShareCourseDAO;
import project.util.Tree;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name = "courseDetailController")
@ViewScoped
public class CourseDetailController {

    public int courseId;
    private Account account;
    private boolean cloned;
    private TreeNode root;
    private Tree treeUtil;
    private TreeNode selectedNode;
    private List<Account> listMemberNotShareCourse;
    private List<String> listIdMemberNotShareCouse;
    private ShareCourse shareCourseCurrent;
    private List<Index> listItem;

    public CourseDetailController() {
        FacesContext context = FacesContext.getCurrentInstance();
        account = (Account) context.getExternalContext().getSessionMap().get(CONFIG.SESSION_NAME_OF_ADMIN);

        treeUtil = new Tree();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
        if (courseId > 0) {
            shareCourseCurrent = ShareCourseDAO.getShareCourseByIdAccountAndIdCourse(account.getIdaccount(), courseId);

            //cloned = shareCourseCurrent.getCloned().equals("yes") ? true : false;
            if (shareCourseCurrent.getCloned().equals(CONFIG.CONFIG_CLONED)) {
                resetTree(shareCourseCurrent);
                cloned = true;
            } else {
                ShareCourse shareCourse = ShareCourseDAO.
                        getShareCouseByIdAccountAndIdCourseAdmin(shareCourseCurrent.getIdAccountCreate(), courseId);
                cloned = false;
                resetTree(shareCourse);
            }

            Account account = new Account();
            account.setIdaccount(shareCourseCurrent.getIdAccountCreate());
            Course course = new Course();
            course.setIdcourse(shareCourseCurrent.getIdCourse());

//            try {
//                listMemberNotShareCourse = AccountDAO.getListAccountAttendedCourseNotShared(account, course);
//            } catch (SQLException ex) {
//                Logger.getLogger(CourseDetailController.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

    public void resetTree(ShareCourse shareCourse) {
        listItem = IndexDAO.getIndexByIdShareCourse(shareCourse);
        if (listItem != null && listItem.size() > 0) {
            treeUtil.setListIndex(listItem);
            root = treeUtil.createTreeNodeIndex();
        }
    }

    public void cloneCourse() {
        if (shareCourseCurrent.getCloned().equals(CONFIG.CONFIG_NOT_CLONE) && listItem != null) {
            //shareCourseCurrent listItem
            boolean b = IndexDAO.cloneCourse(listItem, shareCourseCurrent);
            boolean result = false;
            if (b) {
                result = ShareCourseDAO.updateStatusClone(shareCourseCurrent);
            }
            if (result) {
                cloned = true;
                resetTree(shareCourseCurrent);
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Clone khóa học thành công."));
            } else {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Clone không thành công."));
            }
        }
    }

    public List<Account> getListMemberNotShareCourse() {
        if (listMemberNotShareCourse == null) {
            listMemberNotShareCourse = new ArrayList<>();
        }
        return listMemberNotShareCourse;
    }

    public void setListMemberNotShareCourse(List<Account> listMemberNotShareCourse) {
        this.listMemberNotShareCourse = listMemberNotShareCourse;
    }

    public List<String> getListIdMemberNotShareCouse() {
        if (listIdMemberNotShareCouse == null) {
            listIdMemberNotShareCouse = new ArrayList<>();
        }
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

    public TreeNode getSelectedNode() {
        if (selectedNode == null) {
            selectedNode = new DefaultTreeNode();
        }
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

}
