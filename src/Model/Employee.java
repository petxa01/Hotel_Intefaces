package Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.Serializable;

/**
 * @file Employees.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 20-dic-2016
 * @Time 12:45:16
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22 in Templates/Classes/Class.java.
 * 
 */
public class Employee extends Person implements Serializable {
    private String jobType;
    
    //constructor
   
    public Employee (){
        super();
    }
    
    //getters
    public String getJobType(){
        return jobType;
    }
    
    
    //setters
    public void setJobType(String newJobType){
        jobType=newJobType;
    }
    
    
    
}
