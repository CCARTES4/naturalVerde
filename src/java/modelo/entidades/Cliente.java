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
public class Cliente {
    private String RutCliente;
    private String Nombre;
    private String Apellido;
    private int Telefono;
    private String Correo;

    public Cliente() {
    }

    public Cliente(String RutCliente, String Nombre, String Apellido, int Telefono, String Correo) {
        this.RutCliente = RutCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public String getRutCliente() {
        return RutCliente;
    }

    public void setRutCliente(String RutCliente) {
        this.RutCliente = RutCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "RutCliente=" + RutCliente + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Telefono=" + Telefono + ", Correo=" + Correo + '}';
    }
    
    
    
    
}
