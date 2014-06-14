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
public class ViewStudent implements IDBConnect {

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public ViewStudent() {
        con = DBConnect.connection;
    }

    public ResultSet getData(String searchName) {
        String query = null;
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (searchName.equals("")) {
            query = "select " + STUDENTID + " AS USN," + STUDENTNAME + " AS NAME," + GENDER + " AS GENDER," + FNAME + " AS \"FATEHRS NAME\"," + DOB + " AS \"D.O.B\"," + BRANCH + " AS BRANCH, " + SSLC + " AS \"SSLC %\" ," + PUC + " AS \"PUC %\"," + DEGREE + " AS \"B.E %\"," + PHONE + " AS PHONE ," + EMAIL + " AS EMAIL, " + YOP + " AS \"Year of Pass\" FROM " + STUDENTTABLE + " ORDER BY " + BRANCH;
        } else {
            query = "select " + STUDENTID + " AS USN," + STUDENTNAME + " AS NAME," + GENDER + " AS GENDER," + FNAME + " AS \"FATEHRS NAME\"," + DOB + " AS \"D.O.B\"," + BRANCH + " AS BRANCH, " + SSLC + " AS \"SSLC %\" ," + PUC + " AS \"PUC %\"," + DEGREE + " AS \"B.E %\"," + PHONE + " AS PHONE ," + EMAIL + " AS EMAIL, " + YOP + " AS \"Year of Pass\" FROM " + STUDENTTABLE + " WHERE " + STUDENTNAME + " = '" + searchName + "'";
        }

        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ViewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
