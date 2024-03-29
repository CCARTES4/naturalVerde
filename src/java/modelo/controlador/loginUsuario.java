/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

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
import javax.servlet.http.HttpSession;
import modelo.dao.daoControlador;
import modelo.entidades.Cliente;
import modelo.entidades.Usuario;

/**
 *
 * @author mjara
 */
@WebServlet(name = "loginUsuario", urlPatterns = {"/loginUsuario"})
public class loginUsuario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servletLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servletLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

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
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
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
        //IMPORTAMOS AL DAOCONTROLADOR
        daoControlador dao = new daoControlador();
        //LLAMAMOS A LA ENTIDAD CLIENTE
        Cliente cliente = null;

        //LLAMAMOS A LA SESION
        HttpSession session = request.getSession();

        //VARIABLES
        String Rut = request.getParameter("txtRut").toUpperCase();
        String Contrasena = request.getParameter("txtPass");
        String Nombre = null;
        String Apellido = null;

        try {
            if (dao.Login(Rut, Contrasena)) {
                cliente = dao.buscarCliente(Rut);
                Nombre = cliente.getNombre();
                Apellido = cliente.getApellido();
                
                //RETORNAMOS
                session.setAttribute("nombre", Nombre);
                session.setAttribute("apellido", Apellido);
                session.setAttribute("rut", Rut);
                session.setAttribute("pass", Contrasena);
                request.getRequestDispatcher("indexCli.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario o Contraseña Incorrecta, Vuelva a Intentarlo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ENTRAMOS A LA VISTA LOGIN 
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
