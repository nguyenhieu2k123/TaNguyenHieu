/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.billDAL;
import DTO.bill;
import GUI.billForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhieu
 */
public class billBLL {
    public static void show_info() {
        ArrayList<bill> list = billDAL.getListnv();
        DefaultTableModel model = (DefaultTableModel) billForm.tbBill.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getBill_id();
            row[1] = list.get(i).getStaffId();
            row[2] = list.get(i).getClientId();
            row[3] = list.get(i).getStart();
            row[4] = list.get(i).getEnd();
            row[5] = list.get(i).getServiceId();
            row[6] = list.get(i).getTotalPrice();
            model.addRow(row);
        }
        billForm.tbBill.setModel(model);
    }

    public static void getField() {
        try{
        billForm.txtBillId.setEnabled(false);
        billForm.txtClientId.setEnabled(false);
        billForm.txtServiceId.setEnabled(false);
        billForm.txtStaffId.setEnabled(false);
        int selectedRow = billForm.tbBill.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) billForm.tbBill.getModel();
        billForm.txtBillId.setText(model.getValueAt(selectedRow, 0).toString());
        billForm.txtStaffId.setText(model.getValueAt(selectedRow, 1).toString());
        billForm.txtClientId.setText(model.getValueAt(selectedRow, 2).toString());
        billForm.txtStart.setText(model.getValueAt(selectedRow, 3).toString());
        billForm.txtEnd.setText(model.getValueAt(selectedRow, 4).toString());
        billForm.txtServiceId.setText(model.getValueAt(selectedRow, 5).toString());
        billForm.txtTotalPrice.setText(model.getValueAt(selectedRow, 6).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!");
        }
    }
    public static void refresh(){
        billForm.txtBillId.setText(null);
        billForm.txtStaffId.setText(null);
        billForm.txtClientId.setText(null);
        billForm.txtStart.setText(null);
        billForm.txtEnd.setText(null);
        billForm.txtServiceId.setText(null);
        billForm.txtTotalPrice.setText(null);
        billForm.txtSearch.setText(null);
        billForm.txtBillId.setEnabled(true);
        billForm.txtClientId.setEnabled(true);
        billForm.txtServiceId.setEnabled(true);
        billForm.txtStaffId.setEnabled(true);
        show_info();
    }
    public static void addBill() {
        if("".equals(billForm.txtBillId.getText()) || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER FULL INFORMATION");
        }
        else{
        ArrayList<bill> nhanvien = billDAL.addBill(billForm.txtBillId.getText());
        DefaultTableModel model2 = (DefaultTableModel) billForm.tbBill.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
        }
    }

    public static void deleteBill() {
        if("".equals(billForm.txtBillId.getText()) || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE CHOSE SOMEONE");
        }
        else{
        ArrayList<bill> nhanvien = billDAL.deleteBill(billForm.txtBillId.getText());
        DefaultTableModel model2 = (DefaultTableModel) billForm.tbBill.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
        }
    }

    public static void updateBill() {
        if("".equals(billForm.txtBillId.getText()) || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE CHOSE SOMEONE");
        }
        else{
            ArrayList<bill> nhanvien = billDAL.updateBill(billForm.txtBillId.getText());
            DefaultTableModel model2 = (DefaultTableModel) billForm.tbBill.getModel();
            model2.setRowCount(0);
            refresh();
            show_info();
        }
    }
    public static void check(){
        if("".equals(billForm.txtBillId.getText()) || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER FULL INFORMATION");
        }
    }
    public static void add(){
        
        if("".equals(billForm.txtBillId.getText()) || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER FULL INFORMATION");
        }
        else{
            if((billForm.txtBillId.getText() == "") || billForm.txtClientId.getText() == "" || billForm.txtServiceId.getText() == ""|| billForm.txtStaffId.getText() == "" || billForm.txtStart.getText() == "" || billForm.txtTotalPrice.getText() == ""){
            JOptionPane.showMessageDialog(null, "PLEASE ENTER FULL INFORMATION");
            }
            else{
                addBill();
            }
        }
    }
}
