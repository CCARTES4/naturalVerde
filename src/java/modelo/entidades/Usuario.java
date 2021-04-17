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
public class Usuario {

    private String RutCliente;
    private String Contrasena;
    private String Tipo_Usuario;

    public Usuario() {
    }

    public Usuario(String RutCliente, String Contrasena, String Tipo_Usuario) {
        this.RutCliente = RutCliente;
        this.Contrasena = Contrasena;
        this.Tipo_Usuario = Tipo_Usuario;
    }

    public String getRutCliente() {
        return RutCliente;
    }

    public void setRutCliente(String RutCliente) {
        this.RutCliente = RutCliente;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getTipo_Usuario() {
        return Tipo_Usuario;
    }

    public void setTipo_Usuario(String Tipo_Usuario) {
        this.Tipo_Usuario = Tipo_Usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "RutCliente=" + RutCliente + ", Contrasena=" + Contrasena + ", Tipo_Usuario=" + Tipo_Usuario + '}';
    }

    

}
