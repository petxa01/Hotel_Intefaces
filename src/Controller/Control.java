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

/**
 * @file Control.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 04-may-2017
 * @Time 10:28:37
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22 in Templates/Classes/Class.java.
 * 
 */
public class Control implements ActionListener {
    
    private addEmployee addEmployee;
    private FirstFrame main;
    private WorkEmployees emp= new WorkEmployees();
    
    public Control(View.FirstFrame m, View.addEmployee emp1, WorkEmployees e){
        addEmployee=emp1;
        main=m;
        emp=e;
        //Activating listeners
        main.addEmployee.addActionListener(this);
        addEmployee.save.addActionListener(this);
    }
    public void showAddEmployees(){
        addEmployee.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==main.addEmployee){//addEmployee Button
            addEmployee.setVisible(true);
        } else if (ae.getSource()==addEmployee.save){//Save a new employee button
            Employee emplo=new Employee();
            
            emplo.setNan(addEmployee.nanTextField.getText());
            emplo.setName(addEmployee.nameTextField.getText());
            emplo.setSurname1(addEmployee.surname1TextField.getText());
            emplo.setSurname2(addEmployee.surname2TextField.getText());
            emplo.setPhone(Integer.parseInt(addEmployee.phoneTextField.getText()));
            emplo.setEmail(addEmployee.emailTextField.getText());
            if(addEmployee.male.isSelected()){
                emplo.setGender("Male");
            }else{
                emplo.setGender("Female");
            }
            if (addEmployee.director.isSelected()){
                emplo.setJobType("Director");
            } else if (addEmployee.recepcionist.isSelected()){
                emplo.setJobType("Recepcionist");
            }else if(addEmployee.cleaner.isSelected()){
                emplo.setJobType("Cleaner");
            } else{
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
        }
    }
    
    
}
