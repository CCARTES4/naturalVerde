/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.entidades.Proyecto;
import modelo.entidades.Solicitud;

/**
 *
 * @author mjara
 */
@WebServlet(name = "estadoHora", urlPatterns = {"/estadoHora"})
public class estadoHora extends HttpServlet {

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
        //LLAMAMOS A LA SESION
        HttpSession sesion = request.getSession();
        //CREAMOS UNA LISTA PARA PASARLE TODOS LOS PROYECTOS ASIGNADOS A UN USUARIO
        List<Proyecto> proyecto = null;

        //VARIABLES
        String rutcliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(rutcliente);
        } catch (Exception e) {
            Logger.getLogger(estadoHora.class.getName()).log(Level.SEVERE, null, e);
        }
        //RETORNAMOS
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("estadoHora.jsp").forward(request, response);
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
        //LLAMAMOS A LA ENTIDAD SOLICITUD
        Solicitud solicitud = null;
        //CREAMOS ARREGLO SOLICITUD PARA PASARLE LAS FECHAS EXISTENTES
        List<Solicitud> fechaSolicitud = null;
        //CREAMOS ARREGLO PROYECTO PARA PASEARLE LOS PROYECTOS EXISTENTES
        List<Proyecto> proyecto = null;
        //LLAMAMOS A LA ENTIDAD PROYECTO
        Proyecto detalles = null;

        //LLAMAMOS A LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String Nombre_Proyecto = request.getParameter("cboProyecto");
        String nombrePro = null;
        String fechaPro = request.getParameter("cboFecha");
        String fecha = null;
        String hora = null;
        String estado = null;
        String rutcliente = (String) sesion.getAttribute("rut");
        String boton = request.getParameter("btnAccion");

        try {
            //FUNCION BOTON SELECCIONAR
            if (boton.equals("Seleccionar")) {
                proyecto = dao.buscarProyecto(rutcliente);
                detalles = dao.estadoProyecto(Nombre_Proyecto);
                nombrePro = detalles.getNombre_Proyecto();
                fechaSolicitud = dao.fechaSolicitud(Nombre_Proyecto);
                //FUNCION BOTON MOSTRAR
            } else if (boton.equals("Mostrar")) {
                proyecto = dao.buscarProyecto(rutcliente);
                solicitud = dao.filtrarFecha(fechaPro);
                nombrePro = solicitud.getNombre_Proyecto();
                fecha = solicitud.getFecha();
                hora = solicitud.getHora();
                estado = solicitud.getEstado();
            }

        } catch (Exception e) {
            Logger.getLogger(estadoHora.class.getName()).log(Level.SEVERE, null, e);
        }
        //RETORNAMOS
        request.setAttribute("nombreProyecto", Nombre_Proyecto);
        request.setAttribute("nombrePro", nombrePro);
        request.setAttribute("fecha", fecha);
        request.setAttribute("hora", hora);
        request.setAttribute("estado", estado);
        request.setAttribute("proyecto", proyecto);
        request.setAttribute("fechaSoli", fechaSolicitud);
        request.getRequestDispatcher("estadoHora.jsp").forward(request, response);
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
