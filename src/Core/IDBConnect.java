/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author Administrator
 */
public interface IDBConnect {
// other constants

    public static String ADMIN = "ADMIN";
    public static String SEQ = "comp_seq";
    //----------------table constants ----
    public static String LOGINTABLE = "login";
    public static String LOGIN_USN = "usn";
    public static String USERNAME = "username";
    public static String PASSWORD = "password";
    public static String TYPE = "type";
    //-----------------------------------------------------
    public static String STUDENTTABLE = "studentdetail";
    public static String STUDENTID = "studentid";
    public static String STUDENTNAME = "sname";
    public static String FNAME = "fathername";
    public static String BRANCH = "branch";
    public static String DOB = "dob";
    public static String SSLC = "sslc";
    public static String PUC = "puc";
    public static String DEGREE = "degree";
    public static String PHONE = "phoneno";
    public static String GENDER = "gender";
    public static String EMAIL = "emailid";
    public static String YOP = "yearpassing";
    //-----------------------------------------
    public static String COMPANYTABLE = "company";
    public static String COMPANYNAME = "companyname";
    public static String COMPANYID = "companyid";
    public static String AGGREGATE = "aggregate";
    public static String MINQUALIFICATION = "minqualification";
    public static String CBRANCH = "cbranch";
    public static String CPHONENO = "cphoneno";
    public static String LOCATION = "location";
    public static String SALPACKAGE = "package";
    //---------------------------------------
    public static String REGISTERTABLE = "registerstudent";
    public static String REG_USN = "studentid";
    public static String REG_CID = "companyid";
}
