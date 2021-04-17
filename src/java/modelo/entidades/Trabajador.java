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
public class Trabajador {
    private String Rut_Trabajador;
    private String Nombre_Trabajador;
    private String Cargo;
    private String Nombre_Equipo;

    public Trabajador() {
    }

    public Trabajador(String Rut_Trabajador, String Nombre_Trabajador, String Cargo, String Nombre_Equipo) {
        this.Rut_Trabajador = Rut_Trabajador;
        this.Nombre_Trabajador = Nombre_Trabajador;
        this.Cargo = Cargo;
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public String getRut_Trabajador() {
        return Rut_Trabajador;
    }

    public void setRut_Trabajador(String Rut_Trabajador) {
        this.Rut_Trabajador = Rut_Trabajador;
    }

    public String getNombre_Trabajador() {
        return Nombre_Trabajador;
    }

    public void setNombre_Trabajador(String Nombre_Trabajador) {
        this.Nombre_Trabajador = Nombre_Trabajador;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public void setNombre_Equipo(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "Rut_Trabajador=" + Rut_Trabajador + ", Nombre_Trabajador=" + Nombre_Trabajador + ", Cargo=" + Cargo + ", Nombre_Equipo=" + Nombre_Equipo + '}';
    }
    
    
    
}
