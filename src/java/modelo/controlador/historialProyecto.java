/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.daoControlador;
import modelo.entidades.Historial;
import modelo.entidades.Proyecto;

/**
 *
 * @author mjara
 */
@WebServlet(name = "historialProyecto", urlPatterns = {"/historialProyecto"})
public class historialProyecto extends HttpServlet {

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
        //IMPORTAMOS AL DAOCONTROLADOR
        daoControlador dao = new daoControlador();
        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();
        //CREAMOS UN LISTADO QUE ALMACENAMOS LOS PROYECTOS DEL CLIENTE
        List<Proyecto> proyecto = null;

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(RutCliente);
        } catch (Exception e) {
            Logger.getLogger(historialProyecto.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAMOS
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("historialPro.jsp").forward(request, response);
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
        //IMPORTAMOS AL DAOCONTROLADOR
        daoControlador dao = new daoControlador();
        //CREAMOS UN LISTADO QUE LE PASAMOS TODOS LOS PROYECTOS DEL CLIENTE
        List<Proyecto> proyecto = null;
        //CREAMOS UN LISTADO QUE LE PASAMOS TODOS LOS HISTORIALES DEL PROYECTO
        List<Historial> Historial = new ArrayList<Historial>();

        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String Nombre_Proyecto = request.getParameter("cboProyecto");
        String RutCliente = (String) sesion.getAttribute("rut");
        String Nombre = null;

        try {
            Historial = dao.buscarHistorial(Nombre_Proyecto);
            proyecto = dao.buscarProyecto(RutCliente);
            Nombre = Nombre_Proyecto;
        } catch (Exception e) {
            Logger.getLogger(historialProyecto.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAMOS
        request.setAttribute("historial", Historial);
        request.setAttribute("proyecto", proyecto);
        request.setAttribute("Nombre", Nombre);
        request.getRequestDispatcher("historialPro.jsp").forward(request, response);

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
