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

    public Person(int a){
        
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
    public void setNan()
    {
        Boolean length = null;
        do{
       // nan = Read.readString("Enter the NAN:");
      //  length = Checks.nanLengthCheck(nan);
        }while(length == false);
        
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setName()
   {
//        name = Read.readString("Enter the name:");
   }
    public void setSurname1(String newSurname1)
    {
        surname1 = newSurname1;
    }
    public void setSurname1()
    {
//        surname1 = Read.readString("Enter the first surname:");
    }
    public void setSurname2(String newSurname2)
    {
        surname2 = newSurname2;
    }
    public void setSurname2()
    {

//        surname2 = Read.readString("Enter the second surname:");
    }
    public void setPhone(int newPhone)
    {
        phone = newPhone;
    }
    public void setPhone()
    {

    //    phone = Read.readInt("Enter the phone number:");

    }
    public void setEmail(String newEmail)
    {
        email = newEmail;
    }
    public void setEmail()
    {
        
    //    email =  Read.readString("Enter the email:");
    }
    public void setGender(String newGender)
    {
        gender = newGender;
    }
    public void setGender()
    {
    //    gender= Menu.genderMenu();
    }

}//class
