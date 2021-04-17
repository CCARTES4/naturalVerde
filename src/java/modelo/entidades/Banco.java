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
public class Banco {
    private String Nombre_Banco;

    public Banco() {
    }

    public Banco(String Nombre_Banco) {
        this.Nombre_Banco = Nombre_Banco;
    }

    public String getNombre_Banco() {
        return Nombre_Banco;
    }

    public void setNombre_Banco(String Nombre_Banco) {
        this.Nombre_Banco = Nombre_Banco;
    }

    @Override
    public String toString() {
        return "Banco{" + "Nombre_Banco=" + Nombre_Banco + '}';
    }
    
    
}
