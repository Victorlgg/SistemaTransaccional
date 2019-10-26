<%-- 
    Document   : index
    Created on : 18/08/2019, 07:08:54 PM
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Formulario Registro Asignatura</h1>
        <form action="ServletRegistro" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th colspan="2">Registro Asignatura </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Id del estudiante</td>
                        <td><input type="number" name="id_Est" value="">  </td>
                    </tr>
                    <tr>
                        <td>Id de la Asignatura</td>
                        <td><input type="number" name="id_Asign" value=""> </td>
                    </tr>
                    <!--<tr>
                        <td>EDAD</td>
                        <td><input type="text" name="edad" value=""> </td>
                    </tr>
                    <tr>
                        <td>CORREO</td>
                        <td><input type="text" name="correo" value=""></td>
                    </tr>
                    <tr>
                        <td>USUARIO</td>
                        <td><input type="text" name="usuario" value=""></td>
                    </tr>
                    <tr>
                        <td>CLAVE</td>
                        <td><input type="password" name="clave" value=""></td>
                    </tr>-->
                    <tr>
                        <td colspan="2" align="center">
                        <input type="submit" name="enviar" value="REGISTRAR"></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
        <form action="ServletLimpiar" method="POST"></form>
       <table>
                    <tr>
                        <td colspan="2" align="center">
                        <input type="submit" name="enviar" value="LimpiarCupos"></td>
                    </tr>
       </table>
    </body>
</html>
