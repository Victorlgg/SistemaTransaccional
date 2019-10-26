/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.modelo;

import com.conex.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
/**
 *
 * @author Victor
 */
public class Cupos {
    public static boolean agregarCupo(BeanCupos cupo){
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
                CallableStatement sp = con.prepareCall("{call RegistrarAsignatura(?, ?)}");
                
                sp.setInt(1, Integer.parseInt(cupo.getIdEstudiante()));
                sp.setInt(2, Integer.parseInt(cupo.getIdAsignatura())); 
                ResultSet rs1 = sp.getResultSet();
//                String resultado= (String)sp;
                
                sp.execute();
                agregado = true;
                sp.close();
                
                
            }
        } catch (SQLException e) {
            agregado = false;
            e.printStackTrace();
        }
    
    return agregado;
    }
}
