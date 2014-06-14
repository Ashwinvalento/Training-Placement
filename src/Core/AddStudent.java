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
public class AddStudent implements IDBConnect {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public AddStudent() {
        con = DBConnect.connection;
    }

    public boolean insert(String name, String usn, String gender, String fatherName, String branch, String dob, String sslc, String puc, String be, String yop, String contact, String email) {

        try {
            stmt = con.createStatement();
            String sql2 = "INSERT INTO " + STUDENTTABLE + " VALUES ('" + usn + "','" + name + "','" + fatherName + "','" + branch + "','" + dob + "','" + sslc + "','" + puc + "','" + be + "','" + yop + "','" + contact + "','" + gender + "','" + email + "')";
            stmt.executeUpdate(sql2);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Boolean update(String name, String usn, String gender, String fatherName, String branch, String dob, String sslc, String puc, String be, String yop, String contact, String email) {

        try {
            stmt = con.createStatement();

            String sql2 = " UPDATE " + STUDENTTABLE + " SET " + STUDENTNAME + "='" + name + "'," + FNAME + "='" + fatherName + "'," + BRANCH + "='" + branch + "'," + DOB + "='" + dob + "'," + SSLC + "='" + sslc + "'," + PUC + "='" + puc + "'," + DEGREE + "='" + be + "'," + PHONE + "='" + contact + "'," + GENDER + "='" + gender + "'," + EMAIL + "='" + email + "'," + YOP + "='" + yop + "' WHERE " + STUDENTID + "='" + usn + "'";
            stmt.executeUpdate(sql2);
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
