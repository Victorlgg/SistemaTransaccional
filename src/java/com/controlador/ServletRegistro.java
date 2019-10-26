/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

//import com.modelo.BeanUsuario;
//import com.modelo.Usuario;
import com.conex.Conexion;
import com.modelo.BeanCupos;
import com.modelo.Cupos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "ServletRegistro", urlPatterns = {"/ServletRegistro"})
public class ServletRegistro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id_Est = request.getParameter("id_Est");
        String id_Asign = request.getParameter("id_Asign");

        if (!id_Est.equalsIgnoreCase("") && !id_Asign.equalsIgnoreCase("")) {
            try {
                Conexion c = new Conexion();
//                BeanUsuario busuario = new BeanUsuario(nombre, apellido, edad, correo, usuario, clave);
//                boolean sw = Usuario.agregarUsuario(busuario);
                 BeanCupos bcupo = new BeanCupos(id_Est,id_Asign);
                 boolean sw = Cupos.agregarCupo(bcupo);
                if (sw) {
                    request.getRequestDispatcher("Mensajes.jsp").forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("Algo salió mal en la acción, est:"+id_Est+", asign:"
                            +id_Asign+"\n"
                            +"Conexión: "+c.getConexion()+" usuario agregado:"+sw);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ServletRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//        response.setContentType(
//                "text/html;charset=UTF-8");
//    try (PrintWriter out = response.getWriter()
//
//        ) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Servlet ServletRegistro</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>Servlet ServletRegistro at " + request.getContextPath() + "</h1>");
//        out.println("</body>");
//        out.println("</html>");
//    }
}

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
