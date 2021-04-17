/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import Correo.enviarCorreo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import modelo.entidades.Proyecto;
import modelo.entidades.Solicitud;

/**
 *
 * @author mjara
 */
@WebServlet(name = "solicitudAgendar", urlPatterns = {"/solicitudAgendar"})
public class solicitudAgendar extends HttpServlet {

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
        //CREAMOS UN LISTADO QUE ALMACENAREMOS TODOS LO PROYECTOS DEL CLIENTE
        List<Proyecto> proyecto = null;

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(RutCliente);
        } catch (Exception e) {
            Logger.getLogger(solicitudAgendar.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAR
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("agendarHora.jsp").forward(request, response);
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
        //CREAMOS UN LISTADO QUE ALMACENAREMOS TODOS LOS PROYECTOS DEL CLIENTE
        List<Proyecto> listadoProyecto = null;
        //CREAMOS UN RANDOM PARA ASIGNAR UN COD ALEATORIO A LA SOLICITUD
        Random generadorAleatorios = new Random();

        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        int CodSolicitud = 1 + generadorAleatorios.nextInt(100000);
        int Codigo = CodSolicitud;
        String Hora = request.getParameter("txtHora");
        String Fecha = request.getParameter("txtFecha");
        String Estado = "PENDIENTE";
        String Proyecto = request.getParameter("cboProyecto");
        String RutCliente = (String) sesion.getAttribute("rut");
        boolean resp = false;

        //LLAMAMOS AL ENVIO DE CORREO
        enviarCorreo enviar = new enviarCorreo();
        //VARIABLES CORREO
        String mensaje = "Su solicitud " + CodSolicitud + " ah sido ingresada correctamente, Te enviaremos un correo para confirmar tu solicitud";
        Cliente cliente = null;
        Proyecto pro = null;
        String Correo = null;
        
        //CREAMOS UNA NUEVA SOLICITUD
        Solicitud soli = new Solicitud(Codigo, Hora, Fecha, Estado, Proyecto);

        try {
            if (dao.AgregarSolicitud(soli)) {
                cliente = dao.buscarCliente(RutCliente);
                Correo = cliente.getCorreo();
                listadoProyecto = dao.buscarProyecto(RutCliente);
                resp = true;
                
                //ENVIAMOS SOLICITUD A CORREO ELECTRONICO
                enviar.SendMail(mensaje, Correo, Estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(solicitudAgendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //RETORNAR
        request.setAttribute("respuesta", resp);
        request.setAttribute("proyecto", listadoProyecto);
        request.getRequestDispatcher("agendarHora.jsp").forward(request, response);

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
