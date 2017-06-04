//*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
public class WorkRoom {

    public static boolean writeRoom(Room room) {
       Conne conex = new Conne(); //Konexioa burutu       
        try {
            PreparedStatement kontsulta = conex.getConnection().prepareStatement("INSERT INTO hotel.room VALUES (?, ?, ?)");
            kontsulta.setInt(1, room.getNumber());
            kontsulta.setString(2, room.getTypeOfRoom());
            kontsulta.setInt(3, room.getFloor());
            

            kontsulta.execute();//Kontsulta exekutatu eta emaitza res-ri pasatu

            kontsulta.close();//Kurtsorea itxi
            conex.desconectar();
        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null,
                        "That room already exists",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
            return false;
        } catch (SQLException ex) {
            return false;
        }
        return true;

    }
    public static ArrayList <Room> showRoom() {
        ArrayList<Room> roomList = new ArrayList();
        Conne connex = new Conne();
        
        boolean exist =false;
        try{
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM room");
           ResultSet res = kontsulta.executeQuery();
            
           while (res.next()){
               
               exist=true;
               Room room=new Room();
               room.setNumber(res.getInt(1));
               room.setTypeOfRoom(res.getString(2));
               room.setFloor(res.getInt(3));
               System.out.println(room.getFloor());
               roomList.add(room);
               
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return roomList;
        }else{
            return null;
        }
        
        
    }
    public static ArrayList <Room> searchRoom(int roomNumber){
        ArrayList<Room> roomList = new ArrayList();
        Conne connex = new Conne();
        Room room=new Room();
        boolean exist =false;
        try{
          
           PreparedStatement kontsulta = connex.getConnection().prepareStatement("SELECT * FROM room WHERE Number = ? ");
           kontsulta.setInt(1, roomNumber);
           ResultSet res = kontsulta.executeQuery();
           while (res.next()){
               exist=true;
               room.setNumber(res.getInt(1));
               room.setTypeOfRoom(res.getString(2));
               room.setFloor(res.getInt(3));
               
               roomList.add(room);
           }
           res.close();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPTION");
        }
        if(exist){
            return roomList;
        }else{
            return null;
        }
        
        
    }
    
    public static ResultSet removeRoom(int room) throws SQLException {
        Conne conex = new Conne();
        try {
            PreparedStatement kontsulta = conex.getConnection().prepareStatement("DELETE FROM hotel.room WHERE Number=?");
            kontsulta.setInt(1, room);
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
