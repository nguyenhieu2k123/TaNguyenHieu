/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.clientDAL;
import DTO.client;
import GUI.clientForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhieu
 */
public class clientBLL {
    public static void show_info() {
        ArrayList<client> list = clientDAL.getListnv();
        DefaultTableModel model = (DefaultTableModel) clientForm.tbClient.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getClientId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAge();
            row[3] = list.get(i).getBirthday();
            row[4] = list.get(i).getGender();
            row[5] = list.get(i).getNational();
            row[6] = list.get(i).getPhoneNumber();
            model.addRow(row);
        }
        clientForm.tbClient.setModel(model);
    }

    public static void getField() {
        try{
        clientForm.txtClientId.setEnabled(false);
        int selectedRow = clientForm.tbClient.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) clientForm.tbClient.getModel();
        clientForm.txtClientId.setText(model.getValueAt(selectedRow, 0).toString());
        clientForm.txtClientName.setText(model.getValueAt(selectedRow, 1).toString());
        clientForm.txtAge.setText(model.getValueAt(selectedRow, 2).toString());
        clientForm.txtBirthday.setText(model.getValueAt(selectedRow, 3).toString());
        clientForm.txtGender.setText(model.getValueAt(selectedRow, 4).toString());
        clientForm.txtNational.setText(model.getValueAt(selectedRow, 5).toString());
        clientForm.txtPhoneNumber.setText(model.getValueAt(selectedRow, 6).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "asdasdasdasdas");
        }
    }
    public static void refresh(){
        clientForm.txtClientName.setText(null);
        clientForm.txtClientId.setText(null);
        clientForm.txtAge.setText(null);
        clientForm.txtBirthday.setText(null);
        clientForm.txtGender.setText(null);
        clientForm.txtNational.setText(null);
        clientForm.txtPhoneNumber.setText(null);
        clientForm.txtClientId.setEnabled(true);
        show_info();
        
    }
    public static void addClient() {
        ArrayList<client> nhanvien = clientDAL.addClient(clientForm.txtClientId.getText());
        DefaultTableModel model2 = (DefaultTableModel) clientForm.tbClient.getModel();
        model2.setRowCount(0);
        clientBLL.refresh();
        show_info();
    }

    public static void deleteClient() {
        ArrayList<client> nhanvien = clientDAL.deleteClient(clientForm.txtClientId.getText());
        DefaultTableModel model2 = (DefaultTableModel) clientForm.tbClient.getModel();
        model2.setRowCount(0);
        clientForm.txtClientId.setEnabled(true);
        clientBLL.refresh();
        show_info();
    }

    public static void updateClient() {
        ArrayList<client> nhanvien = clientDAL.updateClient(clientForm.txtClientId.getText());
        DefaultTableModel model2 = (DefaultTableModel) clientForm.tbClient.getModel();
        model2.setRowCount(0);
        clientBLL.refresh();
        show_info();

    }
}
