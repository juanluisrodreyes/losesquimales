/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war.servlets;

import ejb.beans.UsuarioFacade;
import ejb.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan
 */
@WebServlet(name = "RegistroUsuarioServlet", urlPatterns = {"/RegistroUsuarioServlet"})
public class RegistroUsuarioServlet extends HttpServlet {
    @EJB
    private UsuarioFacade usuarioFacade;

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

        // Recoger el nombre de usuario a registrar y la contraseña
        String nombreUsuario = request.getParameter("usuario");
        String contrasenaUsuario = request.getParameter("contrasena");

        // Buscar si existe un usuario con el mismo nombre
        Usuario usuario = usuarioFacade.findByNombre(nombreUsuario);
        
        RequestDispatcher dispatcher;
        if(usuario == null){ // Si el usuario no existe (Se puede registrar)
           /**
	    * Crear un nuevo usuario
	    * Si se pone el id autoincremental en la BD, da igual número que
	    * pongamos al crear el usuario, usará el siguiente del autoincremento
	    */
            usuario = new Usuario(null, nombreUsuario, contrasenaUsuario);
            
            // Añadirlo a la BD
            usuarioFacade.create(usuario);
            
            dispatcher = request.getRequestDispatcher("RegistroUsuarios.jsp?msg=Usuario " + nombreUsuario + " registrado");
        }else{ // Si el usuario existe (No se puede registrar)
            dispatcher = request.getRequestDispatcher("RegistroUsuarios.jsp?msg=El usuario " + nombreUsuario + " ya existe");
        }
        dispatcher.forward(request, response);
 
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
