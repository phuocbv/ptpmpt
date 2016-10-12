/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import project.DO.Account;
import project.DO.Document;
import project.config.CONFIG;
import project.dao.DocumentDAO;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name = "myDocumentController")
@ViewScoped
public class MyDocumentController {

    private List<Document> listDocument;
    private Account account;
    private Document selectedDocument;
    private Part file;

    public MyDocumentController() {
        FacesContext context = FacesContext.getCurrentInstance();
        account = (Account) context.getExternalContext().getSessionMap().get(CONFIG.SESSION_NAME_OF_ADMIN);

        try {
            listDocument = DocumentDAO.getListDocumentOfUser(account);
        } catch (SQLException ex) {
            Logger.getLogger(MyDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Document> getListDocument() {
        return listDocument;
    }

    public void setListDocument(List<Document> listDocument) {
        this.listDocument = listDocument;
    }

    public Document getSelectedDocument() {
        return selectedDocument;
    }

    public void setSelectedDocument(Document selectedDocument) {
        this.selectedDocument = selectedDocument;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

}
