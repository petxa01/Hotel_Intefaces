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
public class Reservation {
    private int res_cod;
    private String customerNan;
    private int roomNumber;
    private LocalDate enterDate;
    private LocalDate leaveDate;
    
    
    //constructor
    public Reservation(){
        
    }
    
    
    
    //getters
    public int getRes_cod(){
        return res_cod;
    }
    public String getCustomerNan(){
        return customerNan;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public LocalDate getEnterDate()
    {
        return enterDate;
    }
    public LocalDate getLeaveDate()
    {
        return leaveDate;
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
    
    public void setEnterDate(LocalDate newEnterDate){
        enterDate = newEnterDate;
    }
   
    public void setLeaveDate(LocalDate newLeaveDate){
        enterDate = newLeaveDate;
    }
    

}
