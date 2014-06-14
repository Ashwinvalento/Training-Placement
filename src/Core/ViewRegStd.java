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
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ViewRegStd implements IDBConnect {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String user, usn;

    public ResultSet getData(String user) {
        this.user = user;
        String query = null;

        con = DBConnect.connection;
        //get USN from user
        query = "select " + LOGIN_USN + " from " + LOGINTABLE + " where " + USERNAME + " = '" + user + "'";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                usn = rs.getString(LOGIN_USN);
                System.out.println("usn is" + usn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStud.class.getName()).log(Level.SEVERE, null, ex);
        }
        query = "select " + COMPANYNAME + " AS NAME," + AGGREGATE + " AS \"MIN AGGREGATE\"," + CPHONENO + " AS \"COMPANY PHONE\"," + LOCATION + " AS \"COMPANY LOCATION\"," + SALPACKAGE + " AS PACKAGE FROM " + STUDENTTABLE + " s," + COMPANYTABLE + " c," + REGISTERTABLE + " r where r." + REG_USN + "=s." + STUDENTID + " and r." + REG_CID + "=c." + COMPANYID + " and r." + REG_USN + "=" + usn;

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            rs = stmt.executeQuery(query);
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null, "NO RECORDS FOUND", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
            rs.previous();
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
