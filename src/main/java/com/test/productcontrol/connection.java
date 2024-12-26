/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.productcontrol;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class connection {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void connect() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_jsf_jpf?user=Cotangente00&password=Camil0242003.");
        }catch(Exception e){
            throw e;
        }
        
    }
    
    public void close() throws Exception{
        try{
            if(cn != null){
                if(cn.isClosed() == false){
                cn.close();
                }
            }
        }catch(Exception e){
            throw e;
        }
        
    }
}
