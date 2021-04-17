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
public class Equipo {
    private String Nombre_Equipo;

    public Equipo() {
    }

    public Equipo(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    public String getNombre_Equipo() {
        return Nombre_Equipo;
    }

    public void setNombre_Equipo(String Nombre_Equipo) {
        this.Nombre_Equipo = Nombre_Equipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "Nombre_Equipo=" + Nombre_Equipo + '}';
    }
    
    
    
}
