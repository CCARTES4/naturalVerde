/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "estadoSolicitud", urlPatterns = {"/estadoSolicitud"})
public class estadoSolicitud extends HttpServlet {

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
        //CREAMOS UN LISTADO PARA PASARLE TODOS LOS PROYECTOS EXISTENTES DEL CLIENTE
        List<Proyecto> proyecto = null;

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(RutCliente);
        } catch (Exception e) {
            Logger.getLogger(estadoSolicitud.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAMOS
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("estadoSoli.jsp").forward(request, response);

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
        //LLAMAMOS A LA ENTIDAD PROYECTO
        Proyecto pro = null;
        //CREAMOS UN LISTADO QUE LE PASAREMOS LOS PROYECTOS DEL CLIENTE
        List<Proyecto> proyecto = null;

        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String Nombre_Proyecto = request.getParameter("cboProyecto");
        String NombreProyecto = null;
        String Equipo = null;
        String Servicio = null;
        String Estado = null;
        String RutCliente = (String) sesion.getAttribute("rut");
        String Boton = request.getParameter("btnAccion");

        try {
            pro = dao.estadoProyecto(Nombre_Proyecto);
            proyecto = dao.buscarProyecto(RutCliente);
            NombreProyecto = pro.getNombre_Proyecto();
            Equipo = pro.getNombre_Equipo();
            Servicio = pro.getServicio();
            Estado = pro.getEstado();
        } catch (Exception e) {
            Logger.getLogger(estadoSolicitud.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAMOS
        request.setAttribute("nombreProyecto", NombreProyecto);
        request.setAttribute("equipo", Equipo);
        request.setAttribute("servicio", Servicio);
        request.setAttribute("estado", Estado);
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("estadoSoli.jsp").forward(request, response);

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
