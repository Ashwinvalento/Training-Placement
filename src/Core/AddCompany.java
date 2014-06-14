/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AddCompany implements IDBConnect {

    Connection con = null;
    Statement stmt = null, stmt1 = null, stmt2 = null;
    ResultSet rs = null;

    public AddCompany() {
        con = DBConnect.connection;
    }

    public Boolean insert(String cname, String aggregate, String cbranch, String cphoneno, String location, String salpackage) {
        try {
            int count = 0;
            stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs1 = stmt1.executeQuery("select * from " + COMPANYTABLE);
            while (rs1.next()) {
                rs1.last();
                count = rs1.getInt(1);
                count++;
                System.out.print(count);
            }


            stmt = con.createStatement();
            String sql2 = "INSERT INTO " + COMPANYTABLE + " VALUES (" + count + ",'" + cname + "','" + aggregate + "','" + cbranch + "','" + cphoneno + "','" + location + "','" + salpackage + "')";
            stmt.executeUpdate(sql2);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }

    public Boolean update(String cname, String aggregate, String cbranch, String cphoneno, String location, String salpackage) {
        try {
            int cid = 0;
            stmt2 = con.createStatement();

            String query1 = "select " + COMPANYID + " from " + COMPANYTABLE + " where " + COMPANYNAME + " ='" + cname + "' and " + CBRANCH + "='" + cbranch + "'";
            ResultSet rs1 = stmt2.executeQuery(query1);
            while (rs1.next()) {
                cid = rs1.getInt(COMPANYID);
                System.out.print(cid);
            }

            stmt = con.createStatement();
            String sql2 = "UPDATE " + COMPANYTABLE + " SET " + COMPANYNAME + "='" + cname + "'," + AGGREGATE + "='" + aggregate + "'," + CBRANCH + "='" + cbranch + "'," + CPHONENO + "='" + cphoneno + "'," + LOCATION + "='" + location + "'," + SALPACKAGE + "='" + salpackage + "' WHERE " + COMPANYID + " = '" + cid + "'";
            stmt.executeUpdate(sql2);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
