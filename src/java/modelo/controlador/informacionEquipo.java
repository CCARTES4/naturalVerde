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
import modelo.entidades.Proyecto;
import modelo.entidades.Trabajador;

/**
 *
 * @author mjara
 */
@WebServlet(name = "informacionEquipo", urlPatterns = {"/informacionEquipo"})
public class informacionEquipo extends HttpServlet {

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
        //LLAMAMOS LA SESION
        HttpSession sesion = request.getSession();
        //CREAMOS UNA LISTA QUE LE PASAREMOS TODOS LOS PROYECTOS
        List<Proyecto> proyecto = null;

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(RutCliente);
        } catch (Exception e) {
            Logger.getLogger(informacionEquipo.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAR
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("informacionEqui.jsp").forward(request, response);
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
        //IMPORTAMOS AL DAOCONTROLADOR
        daoControlador dao = new daoControlador();
        //CREAMOS UNA LISTA QUE LE ASIGNAREMOS TODOS LOS PROYECRTOS DEL CLIENTE
        List<Proyecto> proyecto = null;
        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");

        try {
            proyecto = dao.buscarProyecto(RutCliente);
        } catch (SQLException ex) {
            Logger.getLogger(insumoProyecto.class.getName()).log(Level.SEVERE, null, ex);
        }

        //RETORNAMOS
        request.setAttribute("proyecto", proyecto);
        request.getRequestDispatcher("informacionEqui.jsp").forward(request, response);
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
        //CREAMOS UNA LISTA QUE LE PASAREMOS TODOS LOS PROYECTOS
        List<Proyecto> listadoProyecto = null;
        //CREAMOS UNA LISTA QUE LE PASAREMOS TODOS LOS TRABAJADORES
        List<Trabajador> trabajador = null;

        //PARA MANTENER EL NOMBRE DEL PROYECTO
        String nombreProyecto = request.getParameter("txtProyecto");
        Proyecto detalle = null;
        String name = null;

        //LLAMAMOS A LA ENTIDAD PROYECTO
        Proyecto proyecto = null;

        //OBTENEMOS LA SESION
        HttpSession sesion = request.getSession();

        //VARIABLES
        String RutCliente = (String) sesion.getAttribute("rut");
        String Nombre_Equipo = request.getParameter("txtEquipo");
        String Nombre_Proyecto = request.getParameter("cboProyecto");
        String boton = request.getParameter("btnAccion");
        String equipo = null;
        String Nombre = Nombre_Proyecto;

        try {
            if (boton.equals("Seleccionar")) {
                proyecto = dao.buscarEquipo(Nombre_Proyecto);
                equipo = proyecto.getNombre_Equipo();
                listadoProyecto = dao.buscarProyecto(RutCliente);
            } else if (boton.equals("Mostrar")) {
                trabajador = dao.buscarTrabajador(Nombre_Equipo);
                listadoProyecto = dao.buscarProyecto(RutCliente);
                detalle = dao.estadoProyecto(nombreProyecto);
                name = detalle.getNombre_Proyecto();
            }

        } catch (Exception e) {
            Logger.getLogger(informacionEquipo.class.getName()).log(Level.SEVERE, null, e);
        }

        //RETORNAMOS
        request.setAttribute("name", name);
        request.setAttribute("Nombre", Nombre);
        request.setAttribute("proyecto", listadoProyecto);
        request.setAttribute("equipo", equipo);
        request.setAttribute("trabajador", trabajador);
        request.getRequestDispatcher("informacionEqui.jsp").forward(request, response);

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
