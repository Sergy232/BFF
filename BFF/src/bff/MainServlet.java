/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
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

public class MainServlet
extends HttpServlet {
    private static final long serialVersionUID = 5369286693776901124L;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() MainServlet");
        System.out.println("---> Exiting init() MainServlet");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() MainServlet");
        this.doPost(request, response);
        System.out.println("---> Exiting doGet() MainServlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() MainServlet");
        response.setHeader("Cache-Control", "no-cache");
        request.setAttribute("user_exists", (Object)false);
        request.setAttribute("different_pswds", (Object)false);
        request.setAttribute("login_error", (Object)false);
        request.setAttribute("ok", (Object)false);
        if (request.getSession(false) == null) {
            System.out.println("     User is not logged in");
            System.out.println("     Redirecting the user to newloginForm.jsp");
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
            rd.forward((ServletRequest)request, (ServletResponse)response);
        } else {
            System.out.println("     User is logged in");
            String action = request.getParameter("action");
            if (action != null) {
                HttpSession session = request.getSession();
                session.invalidate();
                System.out.println("     Login error: redirecting the user to newloginForm.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/newLoginForm.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            } else {
                System.out.println("     Redirecting the user to menuNagusia.jsp");
                RequestDispatcher rd = request.getRequestDispatcher("/jsp/menuNagusia.jsp");
                rd.forward((ServletRequest)request, (ServletResponse)response);
            }
        }
        System.out.println("---> Exiting doPost() MainServlet");
    }
}
