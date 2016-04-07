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

import helper.db.MySQLdb;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InforEguneratServlet extends HttpServlet {
    private static final long serialVersionUID = -676242268258514738L;
    private MySQLdb mySQLdb;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() InforEguneratuServlet");
        this.mySQLdb = new MySQLdb();
        System.out.println("---> Exiting init() InforEguneratuServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() InforEguneratuServlet");
        this.doPost(request, response);
        System.out.println("---> Exiting doGet() InforEguneratuServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() InforEguneratuServlet");
        response.setHeader("Cache-Control", "no-cache");
        RequestDispatcher rd = null;
        if (request.getSession(false) == null) {
            System.out.println("     User is not logged in");
            System.out.println("     Redirecting the user to newloginForm.jsp");
            rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        } else {
            System.out.println("     User is logged in");
            String action = request.getParameter("action");
            if (action != null) {
                HttpSession session = request.getSession();
                session.invalidate();
                System.out.println("     Login error: redirecting the user to newloginForm.jsp");
                rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            } else {
                if (request.getParameter("licensetype") == null) {
                    String email = request.getParameter("email");
                    String firstName = request.getParameter("firstname");
                    String lastNames = request.getParameter("lastnames");
                    String address = request.getParameter("address");
                    String tlf = request.getParameter("tlf");
                    String dni = request.getParameter("nan");
                    this.mySQLdb.eguneratuDatuak((String)request.getSession().getAttribute("username"), email, firstName, lastNames, address, tlf, dni);
                    HttpSession session = request.getSession();
                    session.setAttribute("firstname", (Object)firstName);
                    session.setAttribute("lastnames", (Object)lastNames);
                    session.setAttribute("email", (Object)email);
                    session.setAttribute("address", (Object)address);
                    session.setAttribute("tlf", (Object)tlf);
                    session.setAttribute("dni", (Object)dni);
                } else {
                    this.mySQLdb.eguneratuLT((String)request.getSession().getAttribute("username"), request.getParameter("licensetype"));
                }
                request.setAttribute("eragiketaOndo", (Object)true);
                rd = request.getRequestDispatcher("/jsp/menuNagusia.jsp");
            }
            rd.forward((ServletRequest)request, (ServletResponse)response);
            System.out.println("---> Exiting doPost() InforEguneratuServlet");
        }
    }
}
