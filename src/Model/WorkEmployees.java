/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @file WorkEmployees.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 04-may-2017
 * @Time 11:20:31
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22
 * in Templates/Classes/Class.java.
 *
 */
public class WorkEmployees {

    public static void writeEmployee(Employee emp) {
       

        try {
            FileOutputStream fos = new FileOutputStream("C:\\users\\Petxa\\Employees.ser", true);
            MiObjectOutputStream so = new MiObjectOutputStream(fos);
            so.writeObject(emp);
            so.close();
            fos.close();
        } catch (FileNotFoundException gaizki) {
            System.out.println("File not Found.");
        } catch (IOException gaizki) {
            System.out.println("Error: " + gaizki.toString());
        }

    }
    public static ArrayList <Employee> showEmployee() {
        ArrayList<Employee> employeeList = new ArrayList();
        try{
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            Employee emp = new Employee();
           while (true) {    
               emp = (Employee) so.readObject();
               employeeList.add(emp);
            } 
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        }
        
        
        return employeeList;
        
    }
    public static Employee searchEmployee(String nan){
        
        try{
            FileInputStream fis = new FileInputStream("C:\\users\\Petxa\\Employees.ser");
            MiObjectInputStream so = new MiObjectInputStream(fis);
            Employee emp = new Employee();
           while (true) {    
               emp = (Employee) so.readObject();
               if(nan==emp.getNan()){
                   
               }
            } 
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            
        } catch (ClassNotFoundException ex) {
            
        }
        
        return null;
    }

    public static class MiObjectInputStream extends ObjectInputStream {

        public MiObjectInputStream(ObjectInputStream out) throws IOException {
            super(out);
        }

        protected MiObjectInputStream() throws IOException, SecurityException {
            super();
        }

        public MiObjectInputStream(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        protected void readStreamHeader() throws IOException {
        }

    }

    public static class MiObjectOutputStream extends ObjectOutputStream //kabezera txuriz jartzeko
    {

        /**
         * Constructor que recibe OutputStream
         */
        public MiObjectOutputStream(OutputStream out) throws IOException {

            super(out);

        }

        /**
         * Constructor sin parÃ¡metros
         */
        protected MiObjectOutputStream() throws IOException, SecurityException {

            super();

        }

        /**
         * RedefiniciÃ3n del mÃ©todo de escribir la cabecera para que no haga
         * nada.
         *
         */
        protected void writeStreamHeader() throws IOException {

        }

    }
}
