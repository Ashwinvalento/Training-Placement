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
public class RegisterStud implements IDBConnect {

    String query, query1;
    Statement stmt, stmt1;
    Connection con, con1;
    ResultSet rs = null;
    int companyid = 0;
    String usn = null;
    private ResultSet rs1;

    public boolean set(String user, String compname, String compbranch) {

        con = DBConnect.connection;
        con1 = DBConnect.connection;
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

        // get company id from branch and name
        query1 = "select * from " + COMPANYTABLE + " where " + COMPANYNAME + " = '" + compname + "' and " + CBRANCH + " = '" + compbranch + "'";

        try {
            stmt1 = con1.createStatement();
            rs1 = stmt1.executeQuery(query1);

            if (rs1.next()) {
                companyid = rs1.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterStud.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "insert into " + REGISTERTABLE + " values ('" + usn + "','" + companyid + "')";

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


    }
}
