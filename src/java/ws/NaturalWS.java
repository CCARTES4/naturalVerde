/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.dao.daoControlador;
import modelo.entidades.Banco;
import modelo.entidades.Equipo;
import modelo.entidades.Historial;
import modelo.entidades.Insumo;
import modelo.entidades.Proyecto;
import modelo.entidades.Solicitud;
import modelo.entidades.Trabajador;
import modelo.entidades.Usuario;

/**
 *
 * @author mjara
 */
@WebService(serviceName = "NaturalWS")
public class NaturalWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaProyecto")
    public List<Proyecto> listaProyecto() {
        daoControlador dao = new daoControlador();
        try {
            return dao.listarProyecto();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaSolicitud")
    public List<Solicitud> listaSolicitud() {
        daoControlador dao = new daoControlador();
        try {
            return dao.ListarSolicitud();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaHistorial")
    public List<Historial> listaHistorial() {
        daoControlador dao = new daoControlador();
        try {
            return dao.ListarHistorial();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaInsumo")
    public List<Insumo> listaInsumo() {
        daoControlador dao = new daoControlador();
        try {
            return dao.ListaInsumo();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaEquipo")
    public List<Equipo> listaEquipo() {
        daoControlador dao = new daoControlador();
        try {
            return dao.ListaEquipo();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "estadoProyecto")
    public boolean estadoProyecto(@WebParam(name = "pro") Proyecto pro) {
        daoControlador dao = new daoControlador();
        try {
            dao.cambiarEstadoPro(pro);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "estadoSolicitud")
    public boolean estadoSolicitud(@WebParam(name = "soli") Solicitud soli) {
        daoControlador dao = new daoControlador();

        try {
            dao.cambiarEstadoSoli(soli);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarInsumo")
    public boolean agregarInsumo(@WebParam(name = "insu") Insumo insu) {
        daoControlador dao = new daoControlador();
        try {
            dao.AgregarInsumo(insu);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarHistorial")
    public boolean agregarHistorial(@WebParam(name = "his") Historial his) {
        daoControlador dao = new daoControlador();
        try {
            dao.AgregarHistorial(his);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaTrabajador")
    public List<Trabajador> listaTrabajador() {
        daoControlador dao = new daoControlador();
        try {
            return dao.listarTrabajador();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarProyecto")
    public List<Proyecto> buscarProyecto(@WebParam(name = "rutcliente") String rutcliente) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.buscarProyecto(rutcliente);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarHistorial")
    public List<Historial> buscarHistorial(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.buscarHistorial(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarInsumo")
    public List<Insumo> buscarInsumo(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.buscarInsumo(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buscarTrabajador")
    public List<Trabajador> buscarTrabajador(@WebParam(name = "nombreEquipo") String nombreEquipo) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.buscarTrabajador(nombreEquipo);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "detalleProyecto")
    public List<Proyecto> detalleProyecto(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.detalleProyecto(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fechaSolicitud")
    public List<Solicitud> fechaSolicitud(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.fechaSolicitud(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fechaProyecto")
    public List<Solicitud> fechaProyecto(@WebParam(name = "fecha") String fecha) {
        daoControlador dao = new daoControlador();
        
        try {
            return dao.fechaProyecto(fecha);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "detalleSolicitud")
    public List<Solicitud> detalleSolicitud(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        try {
            return dao.detalleSolicitud(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "loginAdmin")
    public boolean loginAdmin(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        daoControlador dao = new daoControlador();
        
        try {
            if(dao.LoginAdmin(usuario, contrasena)){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "estadoHistorial")
    public boolean estadoHistorial(@WebParam(name = "hist") Historial hist) {
        daoControlador dao = new daoControlador();
        try {
            dao.cambiarEstadoHist(hist);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "faseHistorial")
    public List<Historial> faseHistorial(@WebParam(name = "nombreProyecto") String nombreProyecto) {
        daoControlador dao = new daoControlador();
        try {
            return dao.faseHistorial(nombreProyecto);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "detalleHistorial")
    public List<Historial> detalleHistorial(@WebParam(name = "fase") int fase) {
        daoControlador dao = new daoControlador();
        try {
            return dao.detalleHistorial(fase);
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listaBanco")
    public List<Banco> listaBanco() {
        daoControlador dao = new daoControlador();
        try {
            return dao.listarBanco();
        } catch (SQLException ex) {
            Logger.getLogger(NaturalWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }





























}
