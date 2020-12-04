/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.staffDAL;
import DTO.staff;
import GUI.staffForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhieu
 */
public class staffBLL {

    public static void show_info() {
        ArrayList<staff> list = staffDAL.getListnv();
        DefaultTableModel model = (DefaultTableModel) staffForm.tbStaff.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getStaffId();
            row[2] = list.get(i).getAge();
            row[3] = list.get(i).getGender();
            row[4] = list.get(i).getBirthday();
            row[5] = list.get(i).getStaffPosition();
            row[6] = list.get(i).getStaffSalary();
            model.addRow(row);
        }
        staffForm.tbStaff.setModel(model);
    }

    public static void getField() {
        try {
            staffForm.txtStaffId.setEnabled(false);
            int selectedRow = staffForm.tbStaff.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) staffForm.tbStaff.getModel();
            staffForm.txtStaffName.setText(model.getValueAt(selectedRow, 0).toString());
            staffForm.txtStaffId.setText(model.getValueAt(selectedRow, 1).toString());
            staffForm.txtStaffAge.setText(model.getValueAt(selectedRow, 2).toString());
            staffForm.txtStaffGender.setText(model.getValueAt(selectedRow, 3).toString());
            staffForm.txtBirthday.setText(model.getValueAt(selectedRow, 4).toString());
            staffForm.txtStaffPosition.setText(model.getValueAt(selectedRow, 5).toString());
            staffForm.txtStaffSalary.setText(model.getValueAt(selectedRow, 6).toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!");
        }
    }

    public static void refresh() {
        staffForm.txtStaffName.setText(null);
        staffForm.txtStaffId.setText(null);
        staffForm.txtStaffAge.setText(null);
        staffForm.txtStaffGender.setText(null);
        staffForm.txtBirthday.setText(null);
        staffForm.txtStaffPosition.setText(null);
        staffForm.txtStaffSalary.setText(null);
        staffForm.txtSearch.setText(null);
        staffForm.txtStaffId.setEnabled(true);
        show_info();
    }

    public static void addStaff() {
        ArrayList<staff> staff = staffDAL.addStaff(staffForm.txtStaffId.getText());
        DefaultTableModel model2 = (DefaultTableModel) staffForm.tbStaff.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
    }

    public static void deleteStaff() {
        ArrayList<staff> staff = staffDAL.deleteStaff(staffForm.txtStaffId.getText());
        DefaultTableModel model2 = (DefaultTableModel) staffForm.tbStaff.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
    }

    public static void updateStaff() {
        ArrayList<staff> staff = staffDAL.updateStaff(staffForm.txtStaffId.getText());
        DefaultTableModel model2 = (DefaultTableModel) staffForm.tbStaff.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();

    }

    public static void search() {
        ArrayList<staff> staff = staffDAL.search(staffForm.txtSearch.getText());

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"StaffName", "StaffId", "Age", "Gender", "Birthday", "Position", "Salary"});
        Object[] row = new Object[7];
        for (int i = 0; i < staff.size(); i++) {
            
            row[0] = staff.get(i).getName();
            row[1] = staff.get(i).getStaffId();
            row[2] = staff.get(i).getAge();
            row[3] = staff.get(i).getGender();
            row[4] = staff.get(i).getBirthday();
            row[5] = staff.get(i).getStaffPosition();
            row[6] = staff.get(i).getStaffSalary();
            model.addRow(row);
            staffDAL.getListnv();
        }
        staffForm.tbStaff.setModel(model);
    }    
}
