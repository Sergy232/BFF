/*
 * Decompiled with CFR 0_114.
 */
package helper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLdb {
    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String passwd = "Kamaleon";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conn;

    public MySQLdb() {
        try {
            Class.forName(this.driver).newInstance();
            this.conn = DriverManager.getConnection(this.url, this.user, this.passwd);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public boolean setUserInfoBFF(String userName, String firstName, String lastNames, String pswd, String email, String licenseType, String address, String tlf, String dni) {
        String query = "INSERT INTO bff.users VALUES ('" + userName + "', '" + firstName + "', '" + lastNames + "', '" + pswd + "', '" + email + "', '" + licenseType + "', '" + address + "', '" + tlf + "', '" + dni + "');";
        System.out.println("     DB query: " + query);
        try {
            Statement st = this.conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return true;
        }
        return false;
    }

    public String[] getUserInfoBFF(String userName, String pswd) {
        String query = "SELECT * FROM bff.users WHERE username='" + userName + "' AND pswd='" + pswd + "';";
        System.out.println("     DB query: " + query);
        String[] info = null;
        try {
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery(query);
            int i = 0;
            while (res.next()) {
                info = new String[9];
                info[i++] = res.getString("userName");
                info[i++] = res.getString("firstName");
                info[i++] = res.getString("lastNames");
                info[i++] = res.getString("pswd");
                info[i++] = res.getString("email");
                info[i++] = res.getString("licenseType");
                info[i++] = res.getString("address");
                info[i++] = res.getString("tlf");
                info[i++] = res.getString("dni");
                System.out.println(info[0]);
                System.out.println(info[1]);
                System.out.println(info[2]);
                System.out.println(info[3]);
                System.out.println(info[4]);
                System.out.println(info[5]);
                System.out.println(info[6]);
                System.out.println(info[7]);
                System.out.println(info[8]);
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
        return info;
    }

    public String[] updateUserInfoBFF(String userName, String firstName, String lastNames, String pswd, String email, String licenseType, String address, String tlf, String dni) {
        String query = "UPDATE bff.users set firstName='" + firstName + "', lastNames='" + lastNames + "', pswd='" + pswd + "', email='" + email + "', licenseType='" + licenseType + "', address='" + address + "', tlf='" + tlf + "', dni='" + dni + "') WHERE username='" + userName + "';";
        System.out.println("     DB query: " + query);
        String[] info = new String[9];
        try {
            Statement st = this.conn.createStatement();
            ResultSet res = st.executeQuery(query);
            int i = 0;
            while (res.next()) {
                info[i++] = res.getString("userName");
                info[i++] = res.getString("firstName");
                info[i++] = res.getString("lastNames");
                info[i++] = res.getString("pswd");
                info[i++] = res.getString("email");
                info[i++] = res.getString("licenseType");
                info[i++] = res.getString("address");
                info[i++] = res.getString("tlf");
                info[i++] = res.getString("dni");
            }
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return info;
    }

    public void aldatuPasahitza(String userName, String pswd) {
        String query = "UPDATE bff.users SET pswd='" + pswd + "' where username='" + userName + "'";
        System.out.println("     DB query: " + query);
        try {
            Statement st = this.conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void eguneratuDatuak(String userName, String email, String firstName, String lastNames, String address, String tlf, String dni) {
        String query = "UPDATE bff.users SET email='" + email + "', firstname='" + firstName + "', lastnames='" + lastNames + "', address='" + address + "', tlf='" + tlf + "', dni='" + dni + "' where username='" + userName + "'";
        System.out.println("     DB query: " + query);
        try {
            Statement st = this.conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void eguneratuLT(String userName, String licenseType) {
        String query = "UPDATE bff.users SET licensetype='" + licenseType + "' where username='" + userName + "'";
        System.out.println("     DB query: " + query);
        try {
            Statement st = this.conn.createStatement();
            st.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
