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
public class Login implements IDBConnect {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    public String userType = null;

    public Login() {
        con = DBConnect.connection;
    }

    public boolean isValid(String username, String password) {
        try {

            stmt = con.createStatement();

            String query = "select " + USERNAME + "," + PASSWORD + "," + TYPE + " from " + LOGINTABLE + " where " + USERNAME + " = '" + username + "' and " + PASSWORD + " = '" + password + "'";

            rs = stmt.executeQuery(query);

            if (rs.next()) {

                userType = rs.getString(TYPE);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
