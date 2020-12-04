/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import DAL.managerDAL;
import GUI.loginForm;
import GUI.menuForm;

/**
 *
 * @author nguyenhieu
 */
public class managerBLL {

    public static ResultSet rs = null;
    public static PreparedStatement ps = null;
    public void login() {
        String user = loginForm.txtuser.getText();
        String pass = loginForm.txtpass.getText();
        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter full information", "Error", 1);
        } else {
            managerDAL mng = new managerDAL().cLog(user, pass);
            try {
                if (mng != null) {
                    JOptionPane.showMessageDialog(null, "Successed", "NOTIFICATION", 1);
                    menuForm menuform = new menuForm();
                    menuform.dispose();
                    menuform.setVisible(true);
                    menuform.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Your account doesn't exist", "NOTIFICATION", 1);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
}
