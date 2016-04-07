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

import helper.db.MySQLdb;

public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = -5655082560049167734L;
    private MySQLdb mySQLdb;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() SignupServlet");
        this.mySQLdb = new MySQLdb();
        System.out.println("---> Exiting init() SignupServlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() SignupServlet");
        request.setAttribute("user_exists", (Object)false);
        request.setAttribute("different_pswds", (Object)false);
        request.setAttribute("login_error", (Object)false);
        request.setAttribute("ok", (Object)false);
        String pswd = request.getParameter("pswd");
        String pswd2 = request.getParameter("pswd2");
        if (pswd.equals(pswd2)) {
            String email = request.getParameter("email");
            String userName = request.getParameter("username");
            String firstName = request.getParameter("firstname");
            String lastNames = request.getParameter("lastnames");
            String licenseType = request.getParameter("licensetype");
            String address = request.getParameter("address");
            String tlf = request.getParameter("tlf");
            String dni = request.getParameter("nan");
            System.out.println("     Extracting request parameters: " + email + " " + pswd + " " + userName);
            boolean badago = this.mySQLdb.setUserInfoBFF(userName, firstName, lastNames, pswd, email, licenseType, address, tlf, dni);
            if (badago) {
                request.setAttribute("user_exists", (Object)true);
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/newSignUpForm.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            } else {
                System.out.println("     Updating users table in the database");
                request.setAttribute("ok", (Object)true);
                System.out.println("     Redirecting the user to newloginForm.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            }
        } else {
            request.setAttribute("different_pswds", (Object)true);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/newSignUpForm.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        }
        System.out.println("---> Exiting doPost() SignupServlet");
    }
}
