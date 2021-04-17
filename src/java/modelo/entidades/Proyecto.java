/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

/**
 *
 * @author mjara
 */
public class Proyecto {
    private String Nombre_Proyecto;
    private String Servicio;
    private String Estado;
    private String RutCliente;
    private String Nombre_Equipo;

    public Proyecto() {
    }

    public Proyecto(String Nombre_Proyecto, String Servicio, String Estado, String RutCliente, String Nombre_Equipo) {
        this.Nombre_Proyecto = Nombre_Proyecto;
        this.Servicio = Servicio;
        this.Estado = Estado;
        this.RutCliente = RutCliente;
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public String getNombre_Proyecto() {
        return Nombre_Proyecto;
    }

    public void setNombre_Proyecto(String Nombre_Proyecto) {
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getRutCliente() {
        return RutCliente;
    }

    public void setRutCliente(String RutCliente) {
        this.RutCliente = RutCliente;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public void setNombre_Equipo(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "Nombre_Proyecto=" + Nombre_Proyecto + ", Servicio=" + Servicio + ", Estado=" + Estado + ", RutCliente=" + RutCliente + ", Nombre_Equipo=" + Nombre_Equipo + '}';
    }

    

    
    
    
    
}
