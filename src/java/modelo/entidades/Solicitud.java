/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.Date;

/**
 *
 * @author mjara
 */
public class Solicitud {
    private int CodSolicitud;
    private String Hora;
    private String Fecha;
    private String Estado;
    private String Nombre_Proyecto;

    public Solicitud() {
    }

    public Solicitud(int CodSolicitud, String Hora, String Fecha, String Estado, String Nombre_Proyecto) {
        this.CodSolicitud = CodSolicitud;
        this.Hora = Hora;
        this.Fecha = Fecha;
        this.Estado = Estado;
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    public int getCodSolicitud() {
        return CodSolicitud;
    }

    public void setCodSolicitud(int CodSolicitud) {
        this.CodSolicitud = CodSolicitud;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getNombre_Proyecto(){
        return Nombre_Proyecto;
    }
    
    public void setNombre_Proyecto(String Nombre_Proyecto){
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "CodSolicitud=" + CodSolicitud + ", Hora=" + Hora + ", Fecha=" + Fecha + ", Estado=" + Estado + ", Nombre_Proyecto=" + Nombre_Proyecto + '}';
    }

    
    
    
    
    
    
}
