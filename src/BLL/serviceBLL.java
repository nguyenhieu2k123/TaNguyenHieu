/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.serviceDAL;
import DTO.service;
import GUI.serviceForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhieu
 */
public class serviceBLL {
    public static void show_info() {
        ArrayList<service> list = serviceDAL.getListnv();
        DefaultTableModel model = (DefaultTableModel) serviceForm.tbService.getModel();
        model.setRowCount(0);
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getServiceName();
            row[1] = list.get(i).getServiceId();
            row[2] = list.get(i).getServicePrice();
            model.addRow(row);
        }
        serviceForm.tbService.setModel(model);
    }

    public static void getField() {
        try{
        serviceForm.txtServiceId.setEnabled(false);
        int selectedRow = serviceForm.tbService.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) serviceForm.tbService.getModel();
        serviceForm.txtServiceId.setText(model.getValueAt(selectedRow, 0).toString());
        serviceForm.txtServiceName.setText(model.getValueAt(selectedRow, 1).toString());
        serviceForm.txtServicePrice.setText(model.getValueAt(selectedRow, 2).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SOMETHiNG WENT WRONG!!!!!!!!!!!!!!!!!");
        }
    }
    public static void refresh(){
        serviceForm.txtServiceId.setEnabled(true);
        serviceForm.txtServiceName.setText(null);
        serviceForm.txtServiceId.setText(null);
        serviceForm.txtServicePrice.setText(null);
        serviceForm.txtSearch.setText(null);
        refresh();
        
    }
    public static void addService() {
        ArrayList<service> nhanvien = serviceDAL.addService(serviceForm.txtServiceId.getText());
        DefaultTableModel model2 = (DefaultTableModel) serviceForm.tbService.getModel();
        model2.setRowCount(0);
        serviceBLL.refresh();
        show_info();
    }

    public static void deleteService() {
        ArrayList<service> nhanvien = serviceDAL.deleteService(serviceForm.txtServiceId.getText());
        DefaultTableModel model2 = (DefaultTableModel) serviceForm.tbService.getModel();
        model2.setRowCount(0);
        serviceForm.txtServiceId.setEnabled(true);
        serviceBLL.refresh();
        show_info();
    }

    public static void updateService() {
        ArrayList<service> nhanvien = serviceDAL.updateService(serviceForm.txtServiceId.getText());
        DefaultTableModel model2 = (DefaultTableModel) serviceForm.tbService.getModel();
        model2.setRowCount(0);
        serviceBLL.refresh();
        show_info();

    }

}
