/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.itextpdf.text.Document
 *  com.itextpdf.text.Element
 *  com.itextpdf.text.Paragraph
 *  com.itextpdf.text.pdf.PdfWriter
 *  helper.db.MySQLdb
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package bff;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import helper.db.MySQLdb;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LizentziaServlet
extends HttpServlet {
    private static final long serialVersionUID = -676242268258514738L;
    private MySQLdb mySQLdb;

    public void init(ServletConfig config) {
        System.out.println("---> Entering init() LizentziaLortuServlet");
        this.mySQLdb = new MySQLdb();
        System.out.println("---> Exiting init() LizentziaLortuServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doGet() LizentziaLortuServlet");
        this.doPost(request, response);
        System.out.println("---> Exiting doGet() LizentziaLortuServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> Entering doPost() LizentziaLortuServlet");
        response.setHeader("Cache-Control", "no-cache");
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("application/pdf");
        try {
            HttpSession session = request.getSession(true);
            String userName = (String)session.getAttribute("username");
            String pswd = (String)session.getAttribute("pswd");
            String[] userInfo = this.mySQLdb.getUserInfoBFF(userName, pswd);
            Document document = new Document();
            PdfWriter.getInstance((Document)document, (OutputStream)out);
            document.open();
            document.add((Element)new Paragraph(" LIZENTZIAREN ZIURTAGIRIA\n"));
            document.add((Element)new Paragraph(" NAN:       " + userInfo[8]));
            document.add((Element)new Paragraph(" Izena:     " + userInfo[1]));
            document.add((Element)new Paragraph(" Abizena:   " + userInfo[2]));
            document.add((Element)new Paragraph(" Herria:    " + userInfo[6]));
            document.add((Element)new Paragraph(" Email:     " + userInfo[4]));
            document.add((Element)new Paragraph(" Telefonoa: " + userInfo[7]));
            document.add((Element)new Paragraph(" Lizentzia: " + userInfo[5]));
            document.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        out.flush();
        out.close();
        System.out.println("---> Exiting doPost() LizentziaLortuServlet");
    }
}
