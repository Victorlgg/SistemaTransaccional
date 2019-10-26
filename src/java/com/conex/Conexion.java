/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Victor
 */
public class Conexion {
    private Connection con = null;
    
    public Conexion() throws SQLException {
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectost","root","");
            if(con!=null){System.out.println("estable");}
        
        } catch(InstantiationException | ClassNotFoundException | IllegalAccessException e ){//| IllegalAccessException | ClassNotFoundException e){
            e.printStackTrace();
        }
        //| IllegalAccessException | ClassNotFoundException e){
        //| IllegalAccessException | ClassNotFoundException e){

    }


public Connection getConexion(){
    return con;
}

public void cerrarConexion(){
    try{
    con.close();
    } catch (SQLException e){
        e.printStackTrace();
}


}

}