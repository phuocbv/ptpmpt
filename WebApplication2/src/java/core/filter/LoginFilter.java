/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.filter;

import core.controller.LoginController;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.logging.Logger;

/**
 *
 * @author DA CUOI
 */
public class LoginFilter implements Filter {

    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        LoginController loginBean = (LoginController) ((HttpServletRequest) request).getSession().getAttribute("loginController");
        // For the first application request there is no loginBean in the session so user needs to log in
        String contextPath = ((HttpServletRequest) request).getContextPath();
        
        String reqURI = ((HttpServletRequest) request).getRequestURI();
        
        if (loginBean == null || !loginBean.isLoggedIn()) {
            //String contextPath = ((HttpServletRequest)request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }
        if (contextPath.contains("admin") && loginBean.isLogInIsUser()) {
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }
        if (contextPath.contains("user") && loginBean.isLogInIsAdmin()) {
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }
        //loginBean.getAccount().getColumn1()
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    public void destroy() {
        // Nothing to do here!
    }

}
