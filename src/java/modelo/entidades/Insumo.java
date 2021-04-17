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
public class Insumo {
    private int CodInsumo;
    private String Descripcion;
    private String Tienda;
    private int Cantidad;
    private int Precio;
    private String Nombre_Proyecto;

    public Insumo() {
    }

    public Insumo(int CodInsumo, String Descripcion, String Tienda, int Cantidad, int Precio, String Nombre_Proyecto) {
        this.CodInsumo = CodInsumo;
        this.Descripcion = Descripcion;
        this.Tienda = Tienda;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    public int getCodInsumo() {
        return CodInsumo;
    }

    public void setCodInsumo (int CodInsumo) {
        this.CodInsumo = CodInsumo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTienda() {
        return Tienda;
    }

    public void setTienda(String Tienda) {
        this.Tienda = Tienda;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public String getNombre_Proyecto() {
        return Nombre_Proyecto;
    }

    public void setNombre_Proyecto(String Nombre_Proyecto) {
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    @Override
    public String toString() {
        return "Insumo{" + "CodInsumo=" + CodInsumo + ", Descripcion=" + Descripcion + ", Tienda=" + Tienda + ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", Nombre_Proyecto=" + Nombre_Proyecto + '}';
    }

    
    
    
    
    
    
}
