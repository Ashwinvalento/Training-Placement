/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdatePass implements IDBConnect {

    Connection con;
    Statement stmt;

    public UpdatePass() {
        con = DBConnect.connection;
    }

    public void update(String Username, String oldPassword, String newPassword) {
        try {
            stmt = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePass.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "UPDATE login SET " + PASSWORD + " ='" + newPassword + "' where " + USERNAME + " = '" + Username + "' and " + PASSWORD + " = '" + oldPassword + "'";
        try {
            stmt.executeQuery(query);

            JOptionPane.showMessageDialog(null, "PASSWORD SUCCESSFULLY CHANGED", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePass.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "PASSWORD NOT CHANGED", "FAILED", JOptionPane.ERROR_MESSAGE);

        }


    }
}
