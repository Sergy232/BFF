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

public class PasahitzaAldatuServlet
extends HttpServlet {
    private static final long serialVersionUID = -676242268258514738L;
    private MySQLdb mySQLdb;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() PasahitzaAldatuServlet");
        this.mySQLdb = new MySQLdb();
        System.out.println("---> Exiting init() PasahitzaAldatuServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() PasahitzaAldatuServlet");
        this.doPost(request, response);
        System.out.println("---> Exiting doGet() PasahitzaAldatuServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() PasahitzaAldatuServlet");
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
                String zaharra = request.getParameter("zaharra");
                String berria = request.getParameter("berria");
                String berria2 = request.getParameter("berria2");
                if (!((String)request.getSession().getAttribute("pswd")).equals(zaharra)) {
                    request.setAttribute("pswdTxarto", (Object)true);
                    rd = request.getRequestDispatcher("/jsp/pasahitzaAldatu.jsp");
                } else if (!berria.equals(berria2)) {
                    request.setAttribute("different_pswds", (Object)true);
                    rd = request.getRequestDispatcher("/jsp/pasahitzaAldatu.jsp");
                } else {
                    this.mySQLdb.aldatuPasahitza((String)request.getSession().getAttribute("username"), berria);
                    request.setAttribute("eragiketaOndo", (Object)true);
                    rd = request.getRequestDispatcher("/jsp/menuNagusia.jsp");
                }
            }
        }
        rd.forward((ServletRequest)request, (ServletResponse)response);
        System.out.println("---> Exiting doPost() PasahitzaAldatuServlet");
    }
}
