/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public final class DBConnect {
    // JDBC driver name and database URL
    //Mysql Drivers

    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://129.0.0.1:3306/orcl";
    //-- ODBC Drivers
    //   static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
    //   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
// Database credentials
    static final String USER = "scott";
    static final String PASS = "pace11";
    
    public static Connection connection = null;

    public static void getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            
        }
        
        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected to database...");
            } catch (SQLException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}