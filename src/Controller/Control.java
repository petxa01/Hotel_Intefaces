/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Employee;
import View.*;
import Model.WorkEmployees;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Control(View.FirstFrame frame1, View.addEmployee addemp, WorkEmployees workemp, ShowEmployees showEmp) {
        addEmployee = addemp;
        firstFrame = frame1;
        emp = workemp;
        showEmployee=showEmp;
        //Activating listeners
        firstFrame.addEmployee.addActionListener(this);
        addEmployee.save.addActionListener(this);
        firstFrame.showEmployee.addActionListener(this);
        showEmployee.refreshEmployees.addActionListener(this);
    }
//    public void showAddEmployees(){
//        addEmployee.setVisible(true);
//    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == firstFrame.addEmployee) {//addEmployee Button
            addEmployee.setVisible(true);
        } else if (ae.getSource() == addEmployee.save) {//Save a new employee button
            Employee emplo = new Employee();

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
            WorkEmployees.writeEmployee(emplo);

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
        } else if(ae.getSource()==showEmployee.refreshEmployees){//boton Resfresh en ShowEmployee
            ArrayList<Employee> employeeList = null;
            employeeList = WorkEmployees.showEmployee();
            Employee emp;
            DefaultTableModel modeloa = (DefaultTableModel) showEmployee.employeeTable.getModel();
            int rows = 0;
            for (int i = 0; i < employeeList.size(); i++) {
                
                //ARRAY LISTETIK IKASLEAK HARTU
                emp = (Employee) employeeList.get(i);
                //LORTU DUGUN OBJETU BAKOITZEKO FILA BAT GEHITZEN DIOGU TAULARI
                modeloa.addRow(new Object[rows]);
                //ZUTABEAK GEHITZEKO
                modeloa.setValueAt(emp.getNan(), i, 0);
                modeloa.setValueAt(emp.getName(), i, 1);
                modeloa.setValueAt(emp.getSurname1(), i, 2);
                modeloa.setValueAt(emp.getSurname2(), i, 3);
                modeloa.setValueAt(emp.getPhone(), i, 4);
                modeloa.setValueAt(emp.getEmail(), i, 5);
                modeloa.setValueAt(emp.getGender(), i, 6);
                modeloa.setValueAt(emp.getJobType(), i, 7);
            }
        }
    }

}
