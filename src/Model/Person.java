package Model;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Petxa
 */
public class Person implements Serializable
{

    private String nan;
    private String name;
    private String surname1;
    private String surname2;
    private int phone;
    private String email;
    private String gender;

    public Person(){
        
    }

    //getters
    public String getNan()
    {
        return nan;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname1()
    {
        return surname1;
    }

    public String getSurname2()
    {
        return surname2;
    }

    public int getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }

    public String getGender()
    {
        return gender;
    }

    //setters
    public void setNan(String newNan)
    {
        
        nan = newNan;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setSurname1(String newSurname1)
    {
        surname1 = newSurname1;
    }
   
    public void setSurname2(String newSurname2)
    {
        surname2 = newSurname2;
    }
    
    public void setPhone(int newPhone)
    {
        phone = newPhone;
    }
    
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
   
    public void setGender(String newGender)
    {
        gender = newGender;
    }
   

}//class
