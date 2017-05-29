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
public class WorkCustomer {

    public static void writeCustomer(Customer cust) {
       Conne conex = new Conne(); //Konexioa burutu       
        try {
            PreparedStatement kontsulta = conex.getConnection().prepareStatement("INSERT INTO hotel.customer VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            kontsulta.setString(1, cust.getNan());
            kontsulta.setString(2, cust.getName());
            kontsulta.setString(3, cust.getSurname1());
            kontsulta.setString(4, cust.getSurname2());
            kontsulta.setInt(5, cust.getPhone());
            kontsulta.setString(6, cust.getEmail());
            kontsulta.setString(7, cust.getGender());
            kontsulta.setString(8, cust.getPayingMethod());

            kontsulta.execute();//Kontsulta exekutatu eta emaitza res-ri pasatu

            kontsulta.close();//Kurtsorea itxi
            conex.desconectar();
        } catch (SQLException e) {
        }

    }
    public static ArrayList <Customer> showCustomer() {
        ArrayList<Customer> custList = new ArrayList();
        Conne connex = new Conne();
        
        boolean exist =false;
        try{
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM hotel.customer");
           ResultSet res = kontsulta.executeQuery();
           while (res.next()){
               exist=true;
               Customer cust=new Customer();
               cust.setNan(res.getString(1));
               cust.setName(res.getString(2));
               cust.setSurname1(res.getString(3));
               cust.setSurname2(res.getString(4));
               cust.setPhone(res.getInt(5));
               cust.setEmail(res.getString(6));
               cust.setGender(res.getString(7));
               cust.setPayingMethod(res.getString(8));
               custList.add(cust);
               
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return custList;
        }else{
            return null;
        }
        
        
    }
    public static ArrayList <Customer> searchCustomer(String nan){
        ArrayList<Customer> customerList = new ArrayList();
        Conne connex = new Conne();
        Customer cust=new Customer();
        boolean exist =false;
        try{
           String trim = nan.trim();
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM customer WHERE Nan = ? ");
           kontsulta.setString(1, trim);
           ResultSet res = kontsulta.executeQuery();
           while (res.next()){
               exist=true;
               
               cust.setNan(res.getString(1));
               cust.setName(res.getString(2));
               cust.setName(res.getString(2));
               cust.setName(res.getString(2));
               cust.setName(res.getString(2));
               cust.setSurname1(res.getString(3));
               cust.setSurname2(res.getString(4));
               cust.setPhone(res.getInt(5));
               cust.setEmail(res.getString(6));
               cust.setGender(res.getString(7));
               cust.setPayingMethod(res.getString(8));
               customerList.add(cust);
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return customerList;
        }else{
            return null;
        }
        
        
    }
    
    public static ResultSet removeCustomer(String nan) throws SQLException {
        Conne conex = new Conne();
        try {
            PreparedStatement kontsulta = conex.getConnection().prepareStatement("DELETE FROM hotel.customer WHERE nan=?");
            kontsulta.setString(1, nan);
            kontsulta.execute();
            conex.desconectar();
        } catch (SQLException e) {
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
