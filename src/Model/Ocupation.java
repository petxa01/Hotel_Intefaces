package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @file Reservation.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 20-dic-2016
 * @Time 13:11:25
 * @encoding UTF-8
 * 
 **/
public class Ocupation {
    private int ocu_Cod;
    private String customerNan;
    private int roomNumber;
    
    
    
    //constructor
    public Ocupation(){
        
    }
    
    
    
    //getters
    public int getOcu_Cod(){
        return ocu_Cod;
    }
    public String getCustomerNan(){
        return customerNan;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    
    
    //setters
    

    public void setCustomerNan(String newCustomerNan)
    {
        customerNan = newCustomerNan;
    }
    public void setRoomNumber(int newRoomNumber)
    {
        roomNumber = newRoomNumber;
    }
    
    

}
