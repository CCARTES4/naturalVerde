/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.controlador;

import Correo.enviarCorreo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import modelo.entidades.Banco;
import modelo.entidades.Carrito;
import modelo.entidades.Cliente;
import modelo.entidades.Insumo;
import modelo.entidades.Proyecto;
import modelo.entidades.Tipo_Cuenta;

/**
 *
 * @author mjara
 */
@WebServlet(name = "pagoInsumo", urlPatterns = {"/pagoInsumo"})
public class pagoInsumo extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pagoInsumo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pagoInsumo at " + request.getContextPath() + "</h1>");
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
        daoControlador dao = new daoControlador();

        //CREAMOS UN RANDOM PARA ASIGNAR UN COD ALEATORIO A LA SOLICITUD
        Random generadorAleatorios = new Random();
        int Codigo = 1 + generadorAleatorios.nextInt(100000);

        HttpSession sesion = request.getSession();
        String RutCliente = (String) sesion.getAttribute("rut");
        boolean resultado = false;

        //VARIABLES 
        int CodCarrito = Codigo;
        String numCuenta = request.getParameter("txtCuenta");
        String Nombre_Banco = request.getParameter("cboBanco");
        String Tipo_Cuenta = request.getParameter("cboTipo");
        int numCuotas = Integer.parseInt(request.getParameter("txtCuotas"));
        int Total = Integer.parseInt(request.getParameter("txtTotal"));
        String Nombre_Proyecto = request.getParameter("txtNombre");
        int valorCuota = (Total / numCuotas);

        //LLAMAMOS AL ENVIO DE CORREO
        enviarCorreo enviar = new enviarCorreo();

        //VARIABLES DEL ENVIO DE CORREO
        Cliente cliente = null;
        String Correo = null;
        String Asunto = "";
        String mensaje = "Su Pago ah sido realizado Correctamente \n"
                + "Detalles de su Pago: \n"
                + "Codigo Carrito: " + CodCarrito +"\n"
                + "Numero de Cuenta: " + numCuenta + "\n"
                + "Nombre del Banco: " + Nombre_Banco + "\n"
                + "Tipo de Cuenta: " + Tipo_Cuenta + "\n"
                + "Cuotas: " + numCuotas + "\n"
                + "Valor Cuota: $" + valorCuota + "\n"
                + "Total A Pagar: $" + Total + "\n";
        
        

        Carrito carro = new Carrito(CodCarrito, Nombre_Proyecto, numCuenta, Nombre_Banco, Tipo_Cuenta, numCuotas, Total, valorCuota);

        try {
            if (dao.IngresarCarrito(carro)) {
                resultado = true;
                cliente = dao.buscarCliente(RutCliente);
                Asunto = "PAGO INSUMOS";
                Correo = cliente.getCorreo();

                enviar.SendMail(mensaje, Correo, Asunto);   
            } else {
                resultado = false;
            }
        } catch (Exception e) {
            Logger.getLogger(insumoProyecto.class.getName()).log(Level.SEVERE, null, e);
        }
        request.setAttribute("codcarrito", CodCarrito);
        request.setAttribute("numcuenta", numCuenta);
        request.setAttribute("nombrebanco", Nombre_Banco);
        request.setAttribute("tipocuenta", Tipo_Cuenta);
        request.setAttribute("numcuotas", numCuotas);
        request.setAttribute("total", Total);
        request.setAttribute("nombrepro", Nombre_Proyecto);
        request.setAttribute("valorCuota", valorCuota);
        request.setAttribute("resultado", resultado);
        request.getRequestDispatcher("detallePago.jsp").forward(request, response);
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
