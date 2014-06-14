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
public class ViewComp implements IDBConnect {

    Connection con = null, con1 = null;
    Statement stmt = null, stmt1 = null;
    ResultSet rs = null, rs1 = null;
    String user;

    public ViewComp() {
        con = DBConnect.connection;
        con1 = DBConnect.connection;
    }

    public ViewComp(String user) {
        con = DBConnect.connection;
        con1 = DBConnect.connection;
        this.user = user;
    }

    public ResultSet getData(String searchName) {
        String query = null, query1 = null;
        String userType = Forms.MainForm.type;

        String studBranch = null;

        if (!userType.equals(ADMIN)) {
            // Get the student branch 1st
            query1 = "select " + BRANCH + " from " + LOGINTABLE + "," + STUDENTTABLE + " where " + STUDENTID + "=" + LOGIN_USN + " and " + USERNAME + " ='" + user + "'";
            try {
                stmt1 = con1.createStatement();
                rs1 = stmt1.executeQuery(query1);
                if (rs1.next()) {
                    studBranch = rs1.getString(1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ViewComp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (searchName.equals("")) {
            if (!userType.equals(ADMIN)) {
                query = "select " + COMPANYNAME + " AS NAME," + CBRANCH + " AS BRANCH," + AGGREGATE + " AS \"MIN AGGREGATE\"," + CPHONENO + " AS \"COMPANY PHONE\"," + LOCATION + " AS \"COMPANY LOCATION\"," + SALPACKAGE + " AS PACKAGE FROM " + COMPANYTABLE + " WHERE " + CBRANCH + "='" + studBranch + "'";

            } else {
                query = "select " + COMPANYNAME + " AS NAME," + CBRANCH + " AS BRANCH," + AGGREGATE + " AS \"MIN AGGREGATE\"," + CPHONENO + " AS \"COMPANY PHONE\"," + LOCATION + " AS \"COMPANY LOCATION\"," + SALPACKAGE + " AS PACKAGE FROM " + COMPANYTABLE;
            }
        } else {
            if (!userType.equals(ADMIN)) {
                query = "select " + COMPANYNAME + " AS NAME," + CBRANCH + " AS BRANCH," + AGGREGATE + " AS \"MIN AGGREGATE\"," + CPHONENO + " AS \"COMPANY PHONE\"," + LOCATION + " AS \"COMPANY LOCATION\"," + SALPACKAGE + " AS PACKAGE FROM " + COMPANYTABLE + " WHERE " + COMPANYNAME + " = '" + searchName + "' AND " + CBRANCH + "='" + studBranch + "'";
            } else {
                query = "select " + COMPANYNAME + " AS NAME," + CBRANCH + " AS BRANCH," + AGGREGATE + " AS \"MIN AGGREGATE\"," + CPHONENO + " AS \"COMPANY PHONE\"," + LOCATION + " AS \"COMPANY LOCATION\"," + SALPACKAGE + " AS PACKAGE FROM " + COMPANYTABLE + " WHERE " + COMPANYNAME + " = '" + searchName + "'";
            }
        }


        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(ViewComp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
