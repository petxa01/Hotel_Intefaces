/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import Model.WorkEmployees;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @file Control.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 04-may-2017
 * @Time 10:28:37
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class Control implements ActionListener {

    private AddEmployee addEmployee; //ventana AddEmployee
    private FirstFrame firstFrame;// ventana de inicio
    private WorkEmployees emp = new WorkEmployees();
    private ShowEmployees showEmployee; //ventana showEmployees
    private SearchEmployee searchEmployee; //ventana searchemp
    private AddCustomer addCustomer; //ventana AddCustomer
    private ShowCustomers showCustomer; // ventana showCustomer
    private SearchCustomer searchCustomer; //ventana search cust
    private ShowRooms showRooms;
    private AddRooms addRooms;
    private SearchRoom searchRooms;

    public Control(FirstFrame frame1, AddEmployee addemp, WorkEmployees workemp, ShowEmployees showEmp, SearchEmployee searchEmp, AddCustomer addCust, ShowCustomers showCust, SearchCustomer searchCust, ShowRooms showRoom, AddRooms addRoom, SearchRoom searchRoom) {
        addEmployee = addemp;
        firstFrame = frame1;
        emp = workemp;
        showEmployee = showEmp;
        searchEmployee = searchEmp;
        addCustomer = addCust;
        showCustomer = showCust;
        searchCustomer = searchCust;
        showRooms = showRoom;
        addRooms = addRoom;
        searchRooms = searchRoom;
        //Activating listeners
        firstFrame.addEmployee.addActionListener(this);
        firstFrame.showEmployee.addActionListener(this);
        firstFrame.searchEmployee.addActionListener(this);
        addEmployee.save.addActionListener(this);
        showEmployee.refreshEmployees.addActionListener(this);
        searchEmployee.Search.addActionListener(this);
        showEmployee.removeEmployee.addActionListener(this);
        firstFrame.addCustomers.addActionListener(this);
        addCustomer.save.addActionListener(this);
        firstFrame.showCustomer.addActionListener(this);
        showCustomer.refreshCustomers.addActionListener(this);
        showCustomer.removeCustomer.addActionListener(this);
        firstFrame.searchCustomer.addActionListener(this);
        searchCustomer.Search.addActionListener(this);
        firstFrame.showRoom.addActionListener(this);
        showRooms.removeRooms.addActionListener(this);
        firstFrame.addRoom.addActionListener(this);
        addRooms.saveRoom.addActionListener(this);
        firstFrame.searchRoom.addActionListener(this);
        searchRooms.Search.addActionListener(this);

    }
//    public void showAddEmployees(){
//        AddEmployee.setVisible(true);
//    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == firstFrame.addEmployee) {//addEmployee Button
            addEmployee.setVisible(true);
        } else if (ae.getSource() == addEmployee.save) {//Save a new employee button
            Employee emplo = new Employee();
            boolean valid = false;
            boolean error = false;
            emplo.setNan(addEmployee.nanTextField.getText());
            emplo.setName(addEmployee.nameTextField.getText());
            emplo.setSurname1(addEmployee.surname1TextField.getText());
            emplo.setSurname2(addEmployee.surname2TextField.getText());
            if (!addEmployee.phoneTextField.getText().isEmpty()) {
                int phone = 0;
                try {
                    phone = Integer.parseInt(addEmployee.phoneTextField.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Phone must be a number",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    error = true;
                }
                emplo.setPhone(phone);
            }
            emplo.setEmail(addEmployee.emailTextField.getText());
            if (addEmployee.male.isSelected()) {
                emplo.setGender("Male");
            } else {
                emplo.setGender("Female");
            }
            if (addEmployee.director.isSelected()) {
                emplo.setJobType("Director");
            } else if (addEmployee.recepcionist.isSelected()) {
                emplo.setJobType("Recepcionist");
            } else if (addEmployee.cleaner.isSelected()) {
                emplo.setJobType("Cleaner");
            } else {
                emplo.setJobType("Chef");
            }
            if (!error) {
                if (emplo.getNan() == null || emplo.getName() == null || emplo.getSurname1() == null || emplo.getSurname2() == null || emplo.getPhone() == 0 || emplo.getGender() == null || emplo.getJobType() == null) {
                    JOptionPane.showMessageDialog(null,
                            "All the fields must be filled",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    valid = WorkEmployees.writeEmployee(emplo);

                }
            }
            if (valid) {
                JOptionPane.showMessageDialog(null, "Succesfully added", "Succesfully added", JOptionPane.INFORMATION_MESSAGE);
                addEmployee.nanTextField.setText("");
                addEmployee.nameTextField.setText("");
                addEmployee.surname1TextField.setText("");
                addEmployee.surname2TextField.setText("");
                addEmployee.phoneTextField.setText("");
                addEmployee.emailTextField.setText("");
                addEmployee.male.setSelected(true);
                addEmployee.director.setSelected(true);
            } else {
                addEmployee.nanTextField.setText("");
            }

        } else if (ae.getSource() == firstFrame.showEmployee) {//boton showEmployee
            showEmployee.setVisible(true);
            ArrayList<Employee> employeeList = null;
            employeeList = WorkEmployees.showEmployee();

            Employee emplo;
            DefaultTableModel modeloa = (DefaultTableModel) showEmployee.employeeTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;
            for (int i = 0; i < employeeList.size(); i++) {

                //ARRAY LISTETIK IKASLEAK HARTU
                emplo = (Employee) employeeList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(emplo.getNan(), i, 0);
                modeloa.setValueAt(emplo.getName(), i, 1);
                modeloa.setValueAt(emplo.getSurname1(), i, 2);
                modeloa.setValueAt(emplo.getSurname2(), i, 3);
                modeloa.setValueAt(emplo.getPhone(), i, 4);
                modeloa.setValueAt(emplo.getEmail(), i, 5);
                modeloa.setValueAt(emplo.getGender(), i, 6);
                modeloa.setValueAt(emplo.getJobType(), i, 7);
            }
        } else if (ae.getSource() == showEmployee.refreshEmployees) {//boton Resfresh en ShowEmployee
            ArrayList<Employee> employeeList = null;
            employeeList = WorkEmployees.showEmployee();

            Employee emplo;
            DefaultTableModel modeloa = (DefaultTableModel) showEmployee.employeeTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;
            for (int i = 0; i < employeeList.size(); i++) {

                //ARRAY LISTETIK IKASLEAK HARTU
                emplo = (Employee) employeeList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(emplo.getNan(), i, 0);
                modeloa.setValueAt(emplo.getName(), i, 1);
                modeloa.setValueAt(emplo.getSurname1(), i, 2);
                modeloa.setValueAt(emplo.getSurname2(), i, 3);
                modeloa.setValueAt(emplo.getPhone(), i, 4);
                modeloa.setValueAt(emplo.getEmail(), i, 5);
                modeloa.setValueAt(emplo.getGender(), i, 6);
                modeloa.setValueAt(emplo.getJobType(), i, 7);

            }
        } else if (ae.getSource() == showEmployee.removeEmployee) {
            if (showEmployee.employeeTable.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "You must select one row",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int i = showEmployee.employeeTable.getSelectedRow();
                String nan = (String) showEmployee.employeeTable.getValueAt(i, 0);
                try {
                    WorkEmployees.removeEmployee(nan);
                    JOptionPane.showMessageDialog(null, "Succesfully deleted", "Succesfully deleted", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {

                }
                int selectedRow = showEmployee.employeeTable.getSelectedRow();
                DefaultTableModel modeloa = (DefaultTableModel) showEmployee.employeeTable.getModel();
                modeloa.removeRow(selectedRow);
                showEmployee.employeeTable.setModel(modeloa);
            }
        } else if (ae.getSource() == searchEmployee.Search) { //search a employe from the DB

            searchEmployee.errorDisplay.setVisible(false);
            ArrayList<Employee> employeeList = null;
            Employee emplo;
            DefaultTableModel modeloa = (DefaultTableModel) searchEmployee.employeeTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;

            //ARRAY LISTETIK IKASLEAK HARTU
            employeeList = WorkEmployees.searchEmployee(searchEmployee.SearchTextField.getText());
            //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
            if (employeeList != null) {
                for (int i = 0; i < employeeList.size(); i++) {
                    //System.out.println(emplo.getNan());
                    modeloa.addRow(new Object[rows]);
                    emplo = employeeList.get(i);
                    //ZUTABEAK GEHITZEKO
                    modeloa.setValueAt(emplo.getNan(), i, 0);
                    modeloa.setValueAt(emplo.getName(), i, 1);
                    modeloa.setValueAt(emplo.getSurname1(), i, 2);
                    modeloa.setValueAt(emplo.getSurname2(), i, 3);
                    modeloa.setValueAt(emplo.getPhone(), i, 4);
                    modeloa.setValueAt(emplo.getEmail(), i, 5);
                    modeloa.setValueAt(emplo.getGender(), i, 6);
                    modeloa.setValueAt(emplo.getJobType(), i, 7);
                    searchEmployee.errorDisplay.setVisible(false);
                    searchEmployee.SearchTextField.setText("");
                }
            } else {
                searchEmployee.errorDisplay.setText("No Employee with that NAN");
                searchEmployee.errorDisplay.setVisible(true);
                searchEmployee.SearchTextField.setText("");

            }
        } else if (ae.getSource() == firstFrame.searchEmployee) {
            searchEmployee.setVisible(true);

        } else if (ae.getSource() == firstFrame.addCustomers) {//addCustomer Button
            addCustomer.setVisible(true);
        } else if (ae.getSource() == addCustomer.save) { // insert a new customer to the DB
            Customer cust = new Customer();
            boolean error = false;
            cust.setNan(addCustomer.nanTextField.getText());
            cust.setName(addCustomer.nameTextField.getText());
            cust.setSurname1(addCustomer.surname1TextField.getText());
            cust.setSurname2(addCustomer.surname2TextField.getText());
            if (!addCustomer.phoneTextField.getText().isEmpty()) {
                int phone = 0;
                try {
                    phone = Integer.parseInt(addCustomer.phoneTextField.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Phone must be a number",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    error = true;
                }
                cust.setPhone(phone);
            }
            cust.setEmail(addCustomer.emailTextField.getText());
            if (addCustomer.male.isSelected()) {
                cust.setGender("Male");
            } else {
                cust.setGender("Female");
            }
            if (addCustomer.paypal.isSelected()) {
                cust.setPayingMethod("PayPal");
            } else if (addCustomer.creditCard.isSelected()) {
                cust.setPayingMethod("Credit card");
            }
            if (!error) {
                if (cust.getNan() == null || cust.getName() == null || cust.getSurname1() == null || cust.getSurname2() == null || cust.getPhone() == 0 || cust.getGender() == null || cust.getPayingMethod() == null) {
                    JOptionPane.showMessageDialog(null,
                            "All the fields must be filled",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    boolean valid = WorkCustomer.writeCustomer(cust);
                    if (valid) {
                        JOptionPane.showMessageDialog(null, "Succesfully added", "Succesfully added", JOptionPane.INFORMATION_MESSAGE);
                        addCustomer.nanTextField.setText("");
                        addCustomer.nameTextField.setText("");
                        addCustomer.surname1TextField.setText("");
                        addCustomer.surname2TextField.setText("");
                        addCustomer.phoneTextField.setText("");
                        addCustomer.emailTextField.setText("");
                        addCustomer.male.setSelected(true);
                        addCustomer.paypal.setSelected(true);
                    } else {
                        addCustomer.nanTextField.setText("");
                    }

                }
            }

        } else if (ae.getSource() == firstFrame.showCustomer) {
            showCustomer.setVisible(true);
            ArrayList<Customer> custList = null;
            custList = WorkCustomer.showCustomer();

            Customer cust;
            DefaultTableModel modeloa = (DefaultTableModel) showCustomer.CustomerTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;
            for (int i = 0; i < custList.size(); i++) {

                //ARRAY LISTETIK IKASLEAK HARTU
                cust = (Customer) custList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(cust.getNan(), i, 0);
                modeloa.setValueAt(cust.getName(), i, 1);
                modeloa.setValueAt(cust.getSurname1(), i, 2);
                modeloa.setValueAt(cust.getSurname2(), i, 3);
                modeloa.setValueAt(cust.getPhone(), i, 4);
                modeloa.setValueAt(cust.getEmail(), i, 5);
                modeloa.setValueAt(cust.getGender(), i, 6);
                modeloa.setValueAt(cust.getPayingMethod(), i, 7);
            }
        } else if (ae.getSource() == showCustomer.removeCustomer) {
            if (showCustomer.CustomerTable.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "You must select one row",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int i = showCustomer.CustomerTable.getSelectedRow();
                String nan = (String) showCustomer.CustomerTable.getValueAt(i, 0);
                try {
                    WorkCustomer.removeCustomer(nan);
                    JOptionPane.showMessageDialog(null, "Succesfully deleted", "Succesfully deleted", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {

                }
                int selectedRow = showCustomer.CustomerTable.getSelectedRow();
                DefaultTableModel modeloa = (DefaultTableModel) showCustomer.CustomerTable.getModel();
                modeloa.removeRow(selectedRow);
                showCustomer.CustomerTable.setModel(modeloa);
            }

        } else if (ae.getSource() == showCustomer.refreshCustomers) {//boton Resfresh en ShowEmployee
            ArrayList<Customer> custList = null;
            custList = WorkCustomer.showCustomer();

            Customer cust;
            DefaultTableModel modeloa = (DefaultTableModel) showCustomer.CustomerTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;
            for (int i = 0; i < custList.size(); i++) {

                //ARRAY LISTETIK IKASLEAK HARTU
                cust = (Customer) custList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(cust.getNan(), i, 0);
                modeloa.setValueAt(cust.getName(), i, 1);
                modeloa.setValueAt(cust.getSurname1(), i, 2);
                modeloa.setValueAt(cust.getSurname2(), i, 3);
                modeloa.setValueAt(cust.getPhone(), i, 4);
                modeloa.setValueAt(cust.getEmail(), i, 5);
                modeloa.setValueAt(cust.getGender(), i, 6);
                modeloa.setValueAt(cust.getPayingMethod(), i, 7);

            }
        } else if (ae.getSource() == firstFrame.searchCustomer) {
            searchCustomer.setVisible(true);
        } else if (ae.getSource() == searchCustomer.Search) {
            searchCustomer.errorDisplay.setVisible(false);
            ArrayList<Customer> custList = null;
            Customer cust;
            DefaultTableModel modeloa = (DefaultTableModel) searchCustomer.CustomerTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;

            //ARRAY LISTETIK IKASLEAK HARTU
            custList = WorkCustomer.searchCustomer(searchCustomer.SearchTextField.getText());
            //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
            if (custList != null) {
                for (int i = 0; i < custList.size(); i++) {
                    //System.out.println(emplo.getNan());
                    modeloa.addRow(new Object[rows]);
                    cust = custList.get(i);
                    //ZUTABEAK GEHITZEKO
                    modeloa.setValueAt(cust.getNan(), i, 0);
                    modeloa.setValueAt(cust.getName(), i, 1);
                    modeloa.setValueAt(cust.getSurname1(), i, 2);
                    modeloa.setValueAt(cust.getSurname2(), i, 3);
                    modeloa.setValueAt(cust.getPhone(), i, 4);
                    modeloa.setValueAt(cust.getEmail(), i, 5);
                    modeloa.setValueAt(cust.getGender(), i, 6);
                    modeloa.setValueAt(cust.getPayingMethod(), i, 7);
                    searchCustomer.errorDisplay.setVisible(false);
                    searchCustomer.SearchTextField.setText("");
                }
            } else {
                searchCustomer.errorDisplay.setText("No Customer with that NAN");
                searchCustomer.errorDisplay.setVisible(true);
                searchCustomer.SearchTextField.setText("");

            }
        } else if (ae.getSource() == firstFrame.showRoom) {
            showRooms.setVisible(true);
            ArrayList<Room> roomList = null;
            roomList = WorkRoom.showRoom();

            Room room;
            DefaultTableModel modeloa = (DefaultTableModel) showRooms.RoomTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;
            for (int i = 0; i < roomList.size(); i++) {

                //ARRAY LISTETIK IKASLEAK HARTU
                room = (Room) roomList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(room.getNumber(), i, 0);
                modeloa.setValueAt(room.getTypeOfRoom(), i, 1);
                modeloa.setValueAt(room.getFloor(), i, 2);

            }
        } else if (ae.getSource() == showRooms.removeRooms) {
            if (showRooms.RoomTable.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "You must select one row",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                int i = showRooms.RoomTable.getSelectedRow();
                int Number = (int) showRooms.RoomTable.getValueAt(i, 0);
                try {
                    WorkRoom.removeRoom(Number);
                    JOptionPane.showMessageDialog(null, "Succesfully deleted", "Succesfully deleted", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {

                }
                int selectedRow = showRooms.RoomTable.getSelectedRow();
                DefaultTableModel modeloa = (DefaultTableModel) showRooms.RoomTable.getModel();
                modeloa.removeRow(selectedRow);
                showRooms.RoomTable.setModel(modeloa);
            }
        } else if (ae.getSource() == firstFrame.addRoom) {
            addRooms.setVisible(true);
        } else if (ae.getSource() == addRooms.saveRoom) {
            Room room = new Room();
            boolean valid = false;
            boolean error = false;
            if (!addRooms.roomNumber.getText().isEmpty()) {
                int number = 0;
                try {
                    number = Integer.parseInt(addRooms.roomNumber.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Room number must be a number",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    error = true;
                }
                room.setNumber(number);
            }
            if (addRooms.Single.isSelected()) {
                room.setTypeOfRoom("Single");
            } else if (addRooms.Familiar.isSelected()) {
                room.setTypeOfRoom("Familiar");
            } else if (addRooms.Suit.isSelected()) {
                room.setTypeOfRoom("Suit");
            }
            int floor = room.getNumber() / 100;
            room.setFloor(floor);
            if (!error) {
                if (room.getNumber() == 0) {
                    JOptionPane.showMessageDialog(null,
                            "All the fields must be filled",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    valid = WorkRoom.writeRoom(room);

                }
            }
            if (valid) {
                JOptionPane.showMessageDialog(null, "Succesfully added", "Succesfully added", JOptionPane.INFORMATION_MESSAGE);
                addRooms.roomNumber.setText("");
                addRooms.Single.setSelected(true);
            } else {
                addRooms.roomNumber.setText("");
                addRooms.Single.setSelected(true);
            }
        } else if (ae.getSource() == firstFrame.searchRoom) {
            searchRooms.setVisible(true);
        } else if (ae.getSource() == searchRooms.Search) {
            searchRooms.errorDisplay.setVisible(false);
            ArrayList<Room> roomList = null;
            Room room;
            int roomNumber=0;
            boolean error = false;
            DefaultTableModel modeloa = (DefaultTableModel) searchRooms.RoomTable.getModel();
            modeloa.setRowCount(0);
            int rows = 0;

            //ARRAY LISTETIK IKASLEAK HARTU
            try {
                roomNumber= Integer.parseInt(searchRooms.SearchTextField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Room number must be a number",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                error = true;
            }
            if (!error) {
                roomList = WorkRoom.searchRoom(roomNumber);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                if (roomList != null) {
                    for (int i = 0; i < roomList.size(); i++) {
                        //System.out.println(emplo.getNan());
                        modeloa.addRow(new Object[rows]);
                        room = roomList.get(i);
                        //ZUTABEAK GEHITZEKO
                        modeloa.setValueAt(room.getNumber(), i, 0);
                        modeloa.setValueAt(room.getTypeOfRoom(), i, 1);
                        modeloa.setValueAt(room.getFloor(), i, 2);
                        searchRooms.errorDisplay.setVisible(false);
                        searchRooms.SearchTextField.setText("");
                    }
                } else {
                    searchRooms.errorDisplay.setText("No room with that number");
                    searchRooms.errorDisplay.setVisible(true);
                    searchRooms.SearchTextField.setText("");

                }
            }

        }
    }
}
