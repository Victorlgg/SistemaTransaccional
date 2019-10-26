/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.modelo;

import com.conex.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
/**
 *
 * @author Victor
 */
public class Usuario {
    public static boolean agregarUsuario(BeanUsuario usuario){
    boolean agregado =false;
    
        try {
            Conexion c = new Conexion();
            Connection con = c.getConexion();
            if(con!=null){
//                Statement st;
//                st = con.createStatement();
//                String sql="INSERT INTO tbl_usuario (nombre,apellido,edad,correo,usuario,clave) VALUES('"+usuario.getNombre()+"','"
//                        +usuario.getApellido()+"',"+usuario.getEdad()+",'"+usuario.getCorreo()
//                        +"','"+usuario.getUsuario()+"','"+usuario.getClave()+"')";
//                //String sql1 = "INSERT INTO tbl_usuario (nombre,apellido,edad,correo,usuario,clave) VALUES('a','b',1,'c','d','e')";
//                st.executeUpdate(sql);
//                System.out.println(sql);
//                agregado = true;
//                st.close();
                
                //Procedimientos almacenados
                CallableStatement sp = con.prepareCall("{call Insertar(?, ?, ?, ?, ?, ?)}");
                sp.setString(1,usuario.getNombre());    
                sp.setString(2,usuario.getApellido());
                sp.setInt(3, Integer.parseInt(usuario.getEdad()));//("edad",usuario.getEdad());
                sp.setString(4,usuario.getCorreo());
                sp.setString(5,usuario.getUsuario());
                sp.setString(6,usuario.getClave());
                
                sp.execute();
                agregado = true;
                sp.close();
                
                //RECUERDA QUE EL USUARIO ES UNIQUE Y
            }
        } catch (SQLException e) {
            agregado = false;
            e.printStackTrace();
        }
    
    return agregado;
    }
}
