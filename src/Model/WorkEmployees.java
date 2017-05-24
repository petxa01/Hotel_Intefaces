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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        Conne connex = new Conne();
        Employee emp=new Employee();
        boolean exist =false;
        try{
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM employee");
           ResultSet res = kontsulta.executeQuery();
           while (res.next()){
               exist=true;
               
               emp.setNan(res.getString(1));
               emp.setName(res.getString(2));
               emp.setSurname1(res.getString(3));
               emp.setSurname2(res.getString(4));
               emp.setPhone(res.getInt(5));
               emp.setEmail(res.getString(6));
               emp.setGender(res.getString(7));
               emp.setJobType(res.getString(8));
               employeeList.add(emp);
               
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return employeeList;
        }else{
            return null;
        }
        
        
    }
    public static ArrayList <Employee> searchEmployee(String nan){
        ArrayList<Employee> employeeList = new ArrayList();
        Conne connex = new Conne();
        Employee emp=new Employee();
        boolean exist =false;
        try{
           String trim = nan.trim();
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM employee WHERE Nan = ? ");
           kontsulta.setString(1, trim);
           ResultSet res = kontsulta.executeQuery();
           while (res.next()){
               exist=true;
               
               emp.setNan(res.getString(1));
               emp.setName(res.getString(2));
               emp.setSurname1(res.getString(3));
               emp.setSurname2(res.getString(4));
               emp.setPhone(res.getInt(5));
               emp.setEmail(res.getString(6));
               emp.setGender(res.getString(7));
               emp.setJobType(res.getString(8));
               employeeList.add(emp);
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return employeeList;
        }else{
            return null;
        }
        
        
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
