/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

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
    
    private View.addEmployee addEmployee;
    private View.Main main;
    private WorkEmployees emp= new WorkEmployees();
    
    public Control(View.Main m, View.addEmployee add, WorkEmployees e){
        addEmployee=add;
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
        
    }
    
    
}
