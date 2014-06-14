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
public class SignUp implements IDBConnect {

    private final Connection con;
    private Statement stmt, stmt1;
    ResultSet rs1;
    String myUSN;

    public SignUp() {
        con = DBConnect.connection;

    }

    public void insert(String USN, String username, String password, String Type) {
        String query = null;
        myUSN = USN;
        boolean exists = false;
        try {
            stmt = con.createStatement();
            //stmt1 = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePass.class.getName()).log(Level.SEVERE, null, ex);
        }
        //get USN from student details to check if student is there is database
        if (!USN.equals(ADMIN)) {
            try {
                System.out.println("usn sent is " + USN);

                String query1 = "select * from " + STUDENTTABLE + " where " + STUDENTID + " = '" + USN.toLowerCase() + "'";
                stmt1 = con.createStatement();
                ResultSet rs1 = stmt1.executeQuery(query1);

                if (rs1.next()) {
                    exists = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            }
            query = "insert into " + LOGINTABLE + " values ('" + USN.toLowerCase() + "','" + username + "','" + password + "','" + Type + "')";


        } else {
            query = "insert into " + LOGINTABLE + "(" + USERNAME + "," + PASSWORD + "," + TYPE + ")values ('" + username + "','" + password + "','" + Type + "')";
            exists = true;
        }
        if (!userExists()) {

            if (exists) //if the USN exists in the student table
            {
                try {
                    stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "USER Inserted", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Error inserting USER", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "USN does not exist", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "User already exist", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private boolean userExists() {
        try {

            stmt = con.createStatement();

            String query = "select " + USERNAME + " from " + LOGINTABLE + " where " + LOGIN_USN + " = '" + myUSN + "'";

            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("hello");
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
