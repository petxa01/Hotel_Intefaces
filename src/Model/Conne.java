/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @file Connection.java
 * @author Gorka
 * @email petxa01@gmail.com
 * @date 17-may-2017
 * @Time 13:16:39
 * @encoding UTF-8
 * @projectlicense Expression projectLicense is undefined on line 17, column 22 in Templates/Classes/Class.java.
 * 
 */
public class Conne {
    static String bd ="hotel";
    String login= "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost:3306/"+bd;
    
    Connection connex=null;

    public Conne() {
        
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connex = DriverManager.getConnection(url,login,password);
                if(connex!=null){
                    System.out.println("Conectatuta!!!");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFound");
            } catch (SQLException ex) {
                System.out.println("SQLException");
            }
        }
    
    
    public Connection getConnection(){
        return connex;
    }
    public void desconectar(){
        connex=null;
    }
    
    
}
