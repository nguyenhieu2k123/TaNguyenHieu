/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.roomDAL;
import DTO.room;
import GUI.roomForm;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenhieu
 */
public class roomBLL {
    public static void show_info() {
        ArrayList<room> list = roomDAL.getListnv();
        DefaultTableModel model = (DefaultTableModel) roomForm.tbRoom.getModel();
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getRoomId();
            row[1] = list.get(i).getRoomKind();
            row[2] = list.get(i).getNumber();
            row[3] = list.get(i).getFloor();
            row[4] = list.get(i).getRoomCondition();
            row[5] = list.get(i).getRoomPrice();  
            model.addRow(row);
        }
        roomForm.tbRoom.setModel(model);
    }

    public static void getField() {
        try{
        roomForm.txtRoomId.setEnabled(false);
        int selectedRow = roomForm.tbRoom.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) roomForm.tbRoom.getModel();
        roomForm.txtRoomId.setText(model.getValueAt(selectedRow, 0).toString());
        roomForm.txtKindId.setText(model.getValueAt(selectedRow, 1).toString());
        roomForm.txtNumber.setText(model.getValueAt(selectedRow, 2).toString());
        roomForm.txtFloor.setText(model.getValueAt(selectedRow, 3).toString());
        roomForm.txtCondition.setText(model.getValueAt(selectedRow, 4).toString());
        roomForm.txtPrice.setText(model.getValueAt(selectedRow, 5).toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG!!");
        }
    }
    public static void refresh(){
        roomForm.txtRoomId.setText(null);
        roomForm.txtKindId.setText(null);
        roomForm.txtNumber.setText(null);
        roomForm.txtFloor.setText(null);
        roomForm.txtCondition.setText(null);
        roomForm.txtPrice.setText(null);
        roomForm.txtSearch.setText(null);
        roomForm.txtRoomId.setEnabled(true);
        show_info();
    }
    public static void addRoom() {
        ArrayList<room> nhanvien = roomDAL.addRoom(roomForm.txtRoomId.getText());
        DefaultTableModel model2 = (DefaultTableModel) roomForm.tbRoom.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
    }

    public static void deleteRoom() {
        ArrayList<room> nhanvien = roomDAL.deleteRoom(roomForm.txtRoomId.getText());
        DefaultTableModel model2 = (DefaultTableModel) roomForm.tbRoom.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();
    }

    public static void updateRoom() {
        ArrayList<room> nhanvien = roomDAL.updateRoom(roomForm.txtRoomId.getText());
        DefaultTableModel model2 = (DefaultTableModel) roomForm.tbRoom.getModel();
        model2.setRowCount(0);
        refresh();
        show_info();

    }

}
