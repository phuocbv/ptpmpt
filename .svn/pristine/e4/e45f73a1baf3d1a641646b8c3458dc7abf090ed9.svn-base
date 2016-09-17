
package core.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import project.DO.Account;
import project.dao.AccountDAO;

/**
 *
 * @author DA CUOI
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {
    private static final String REDIRECT_TO_HOME = "/ptpmpt/home.xhtml?faces-redirect=true";
    private static final String REDIRECT_TO_LOGIN = "/login.xhtml?faces-redirect=true";
    private static final String TO_LOGIN = "/login.xhtml";
    
    private Account account;
    private boolean loggedIn;
    FacesContext context;
    public LoginController(){
        account = new Account();
        context = FacesContext.getCurrentInstance();
    }
    
    public String doLogin(){
        if(account.getUsername() == ""){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ""));
            return TO_LOGIN;
        }
        if(account.getUsername() != "" && account.getPassword() != ""){
            
            Account result = AccountDAO.getAccountByUsername(account);
            //Account result = AccountDAO.getAccount(account);
            if(result == null) {
                //context.addMessage(null, new FacesMessage("Error", "Đăng nhập không thành công"));
                return TO_LOGIN;
            }
            loggedIn = true;
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().put("account", result);
            //context.addMessage(null, new FacesMessage("Error", "Đăng nhập thành công"));
            return REDIRECT_TO_HOME;
        }
        loggedIn = false;
        context.addMessage(null, new FacesMessage("Error", "Đăng nhập không thành công"));
        return TO_LOGIN;
    }
    
    public String doLogout(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("account");
        loggedIn = false;
        return REDIRECT_TO_LOGIN;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    } 

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}