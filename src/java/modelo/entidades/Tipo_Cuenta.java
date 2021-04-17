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
public class Tipo_Cuenta {
    private String Tipo_Cuenta;

    public Tipo_Cuenta() {
    }

    public Tipo_Cuenta(String Tipo_Cuenta) {
        this.Tipo_Cuenta = Tipo_Cuenta;
    }

    public String getTipo_Cuenta() {
        return Tipo_Cuenta;
    }

    public void setTipo_Banco(String Tipo_Cuenta) {
        this.Tipo_Cuenta = Tipo_Cuenta;
    }

    @Override
    public String toString() {
        return "Tipo_Cuenta{" + "Tipo_Cuenta=" + Tipo_Cuenta + '}';
    }
    
    
}
