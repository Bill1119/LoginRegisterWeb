/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.*;


/**
 *
 * @author skyba
 */
public class test {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bill","root","8111");
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from emp");
            System.out.println("program is running");
            
            while(rs.next())
             System.out.print(rs.getInt(1)+ " " + rs.getInt(2) + " " + rs.getInt(3));
            
            con.close();
        } 
        catch(Exception e){
        System.out.println(e);
        }
    
    }
}
