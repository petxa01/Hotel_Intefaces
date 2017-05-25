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

    private addEmployee addEmployee; //ventana addEmployee
    private FirstFrame firstFrame;// ventana de inicio
    private WorkEmployees emp = new WorkEmployees();
    private ShowEmployees showEmployee; //ventana showEmployees
    private SearchEmployee searchEmployee; //ventana searchemp
    private addCustomer addCustomer; //ventana addCustomer
    private ShowCustomers showCustomer; // ventana showCustomer

    public Control(FirstFrame frame1, addEmployee addemp, WorkEmployees workemp, ShowEmployees showEmp, SearchEmployee searchEmp , addCustomer addCust, ShowCustomers showCust) {
        addEmployee = addemp;
        firstFrame = frame1;
        emp = workemp;
        showEmployee = showEmp;
        searchEmployee = searchEmp;
        addCustomer = addCust;
        showCustomer = showCust;
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
        
        
    }
//    public void showAddEmployees(){
//        addEmployee.setVisible(true);
//    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == firstFrame.addEmployee) {//addEmployee Button
            addEmployee.setVisible(true);
        } else if (ae.getSource() == addEmployee.save) {//Save a new employee button
            Employee emplo = new Employee();
            boolean valid;
            emplo.setNan(addEmployee.nanTextField.getText());
            emplo.setName(addEmployee.nameTextField.getText());
            emplo.setSurname1(addEmployee.surname1TextField.getText());
            emplo.setSurname2(addEmployee.surname2TextField.getText());
            emplo.setPhone(Integer.parseInt(addEmployee.phoneTextField.getText()));
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
            valid=WorkEmployees.writeEmployee(emplo);
            if(valid){
            JOptionPane.showMessageDialog(null, "Succesfully added", "Succesfully added", JOptionPane.INFORMATION_MESSAGE);
            }
            addEmployee.nanTextField.setText("");
            addEmployee.nameTextField.setText("");
            addEmployee.surname1TextField.setText("");
            addEmployee.surname2TextField.setText("");
            addEmployee.phoneTextField.setText("");
            addEmployee.emailTextField.setText("");
            addEmployee.male.setSelected(true);
            addEmployee.director.setSelected(true);
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
        } else if(ae.getSource() == showEmployee.removeEmployee){
            if(showEmployee.employeeTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null,
                        "You must select one row",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else{
                int i = showEmployee.employeeTable.getSelectedRow();
                String nan = (String) showEmployee.employeeTable.getValueAt(i, 0);
                try {
                    WorkEmployees.removeEmployee(nan);
                } catch (SQLException ex) {
                    
                }
                int selectedRow = showEmployee.employeeTable.getSelectedRow();
                DefaultTableModel modeloa = (DefaultTableModel) showEmployee.employeeTable.getModel();
                modeloa.removeRow(selectedRow);
                showEmployee.employeeTable.setModel(modeloa);
            }
        }
        
        else if (ae.getSource() == searchEmployee.Search) { //search a employe from the DB

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
                    System.out.println("");
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
        } else if(ae.getSource() == addCustomer.save){ // insert a new customer to the DB
            Customer cust = new Customer();

            cust.setNan(addCustomer.nanTextField.getText());
            cust.setName(addCustomer.nameTextField.getText());
            cust.setSurname1(addCustomer.surname1TextField.getText());
            cust.setSurname2(addCustomer.surname2TextField.getText());
            cust.setPhone(Integer.parseInt(addCustomer.phoneTextField.getText()));
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
            WorkCustomer.writeCustomer(cust);
            JOptionPane.showMessageDialog(null, "Succesfully added", "Succesfully added", JOptionPane.INFORMATION_MESSAGE);
            addCustomer.nanTextField.setText("");
            addCustomer.nameTextField.setText("");
            addCustomer.surname1TextField.setText("");
            addCustomer.surname2TextField.setText("");
            addCustomer.phoneTextField.setText("");
            addCustomer.emailTextField.setText("");
            addCustomer.male.setSelected(true);
            addCustomer.paypal.setSelected(true);
        }else if(ae.getSource()==firstFrame.showCustomer){
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
        }
    }

}
