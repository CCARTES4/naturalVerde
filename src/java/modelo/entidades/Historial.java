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
public class Historial {
    private int Fase;
    private String Fecha;
    private String Descripcion;
    private String Estado;
    private String Nombre_Proyecto;

    public Historial() {
    }

    public Historial(int Fase, String Fecha, String Descripcion, String Estado, String Nombre_Proyecto) {
        this.Fase = Fase;
        this.Fecha = Fecha;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    public int getFase() {
        return Fase;
    }

    public void setFase(int Fase) {
        this.Fase = Fase;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNombre_Proyecto() {
        return Nombre_Proyecto;
    }

    public void setNombre_Proyecto(String Nombre_Proyecto) {
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    @Override
    public String toString() {
        return "Historial{" + "Fase=" + Fase + ", Fecha=" + Fecha + ", Descripcion=" + Descripcion + ", Estado=" + Estado + ", Nombre_Proyecto=" + Nombre_Proyecto + '}';
    }
    
    
}
