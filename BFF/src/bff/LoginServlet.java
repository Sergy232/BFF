/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  helper.db.MySQLdb
 *  javax.servlet.RequestDispatcher
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package bff;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import helper.db.MySQLdb;

public class LoginServlet
extends HttpServlet {
    private static final long serialVersionUID = 2707232058695929542L;
    private MySQLdb mySQLdb;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() LoginServlet");
        this.mySQLdb = new MySQLdb();
        System.out.println("---> Exiting init() LoginServlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() LoginServlet");
        response.setHeader("Cache-Control", "no-cache");
        String userName = request.getParameter("username");
        String pswd = request.getParameter("pswd");
        System.out.println("     Extracting request parameters: " + userName + " " + pswd);
        String[] userInfo = null;
        userInfo = this.mySQLdb.getUserInfoBFF(userName, pswd);
        if (userInfo == null) {
            System.out.println("     Login error: redirecting the user to newLoginForm.jsp");
            boolean loginerror = true;
            request.setAttribute("login_error", (Object)loginerror);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", (Object)userInfo[0]);
            session.setAttribute("pswd", (Object)userInfo[3]);
            session.setAttribute("firstname", (Object)userInfo[1]);
            session.setAttribute("lastnames", (Object)userInfo[2]);
            session.setAttribute("email", (Object)userInfo[4]);
            session.setAttribute("licensetype", (Object)userInfo[5]);
            session.setAttribute("address", (Object)userInfo[6]);
            session.setAttribute("tlf", (Object)userInfo[7]);
            session.setAttribute("dni", (Object)userInfo[8]);
            String sessionID = session.getId();
            System.out.println("     User session for " + userName + ": " + sessionID);
            System.out.println("     Redirecting the user to menuNagusia.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuNagusia.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        }
        System.out.println("---> Exiting doPost() LoginServlet");
    }
}
