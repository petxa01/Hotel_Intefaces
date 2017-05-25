package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Petxa
 */
public class Room {

    private int number;
    private int floor;
    private String typeOfRoom;

    //constructors
    public Room() {
        
    }

    //getters
    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    //setters
    public void setNumber(int newNumber) {
        number = newNumber;
    }


    public void setFloor(int newFloor) {
        floor = newFloor;
    }

    

    public void setTypeOfRoom(String newTypeOfRoom) {
        typeOfRoom = newTypeOfRoom;
    }

    

}
