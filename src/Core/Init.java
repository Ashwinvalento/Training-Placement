/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import Forms.LoginForm;

/**
 *
 * @author Ashu
 */
public class Init {

    public static Init InitObj = null;
    private final LoginForm LFObj;

    public Init() {
        DBConnect.getConnection();
        LFObj = new LoginForm();
        LFObj.setVisible(true);
    }

    public static void main(String args[]) {
        InitObj = new Init();
    }
}
