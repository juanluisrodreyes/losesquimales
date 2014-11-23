
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
 * @author Nyle
 */
@WebServlet(name = "LoginUsuarioServlet", urlPatterns = {"/LoginUsuarioServlet"})
public class LoginUsuarioServlet extends HttpServlet {
    
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
        String logout = request.getParameter("logout");

        RequestDispatcher dispatcher;
        
        if(logout != "true"){
            // Buscar si existe un usuario con el mismo nombre
            Usuario usuario = usuarioFacade.findByNombre(nombreUsuario);      

            if(usuario != null){ // el usuario existe hacemos login           
                request.getSession().setAttribute("user", usuario); // guardamos el usuario en la sesion                        
                dispatcher = request.getRequestDispatcher("Login.jsp?msg=Login correcto!");
            }else{ // Si el usuario existe (No se puede registrar)
                dispatcher = request.getRequestDispatcher("Login.jsp?msg=Nombre de usuario o contraseña invalidos.");
            }
        
        }else{
            request.getSession().invalidate();             
            dispatcher = request.getRequestDispatcher("Login.jsp?msg=Logout correcto!");
        }
        
        response.sendRedirect("index.html");
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











