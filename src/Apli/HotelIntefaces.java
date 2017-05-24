/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apli;

import Model.*;
import View.*;
import Controller.*;

/**
 *
 * @author Gorka
 */
public class HotelIntefaces {
    WorkEmployees work;
    FirstFrame start_window;
    addEmployee addEmployee;
    Control control;
    ShowEmployees showEmp;
    SearchEmployee searchEmp;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HotelIntefaces apli=new HotelIntefaces();
        apli.start();
        
     }
    private void start(){
        //instanciar las clases
        showEmp=new ShowEmployees();
        work=new WorkEmployees();
        start_window=new FirstFrame();
        addEmployee=new addEmployee();
        searchEmp=new SearchEmployee();
        control=new Control(start_window, addEmployee, work, showEmp, searchEmp);
        start_window.setVisible(true);
        
        
        
        
    }
    
    
}
