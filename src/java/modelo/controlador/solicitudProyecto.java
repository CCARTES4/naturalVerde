/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import Correo.enviarCorreo;
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
import modelo.entidades.Cliente;
import modelo.entidades.Equipo;
import modelo.entidades.Proyecto;

/**
 *
 * @author mjara
 */
@WebServlet(name = "solicitudProyecto", urlPatterns = {"/solicitudProyecto"})
public class solicitudProyecto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //LLAMAMOS AL DAOCONTROLADOR
            daoControlador dao = new daoControlador();
            //CREAMOS UN LISTADO QUE ALMACENAREMOS TODOS LOS EQUIPOS EXISTENTES
            List<Equipo> listadoEquipo = null;

            try {
                listadoEquipo = dao.ListaEquipo();
            } catch (SQLException ex) {
                Logger.getLogger(solicitudProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }

            //RETORNAR
            request.setAttribute("equipo", listadoEquipo);
            request.getRequestDispatcher("solicitudPro.jsp").forward(request, response);

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

        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String Nombre = request.getParameter("txtNombre").toUpperCase();
        String Servicio = request.getParameter("cboServicio").toUpperCase();
        String Equipo = request.getParameter("cboEquipo").toUpperCase();
        String RutCliente = (String) sesion.getAttribute("rut");
        String Estado = "PENDIENTE";
        boolean resp = false;

        //CREAMOS UNA NUEVA SOLICITUD DE PROYECTO
        Proyecto pro = new Proyecto(Nombre, Servicio, Estado, RutCliente, Equipo);

        //LLAMAMOS AL ENVIO DE CORREO
        enviarCorreo enviar = new enviarCorreo();

        //VARIABLES DEL ENVIO DE CORREO
        Cliente cliente = null;
        String Correo = null;
        String mensaje = "Su proyecto " + Nombre + " ah sido ingresado correctamente, Te enviaremos un correo para confirmar tu solicitud";

        try {
            if (dao.AgregarProyecto(pro)) {
                cliente = dao.buscarCliente(RutCliente);
                Correo = cliente.getCorreo();
                resp = true;

                //ENVIAMOS CONFIRMACION DE SOLICITUD AL CORREO DEL CLIENTE
                enviar.SendMail(mensaje, Correo, Estado);
            } else {
                resp = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(solicitudProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //RETORNAR
        request.setAttribute("respuesta", resp);
        request.getRequestDispatcher("solicitudPro.jsp").forward(request, response);
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
