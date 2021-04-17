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
public class Carrito {
    private int CodCarrito;
    private String Nombre_Proyecto;
    private String NumCuenta;
    private String Nombre_Banco;
    private String Tipo_Cuenta;
    private int NumCuota;
    private int TotalPagar;
    private int ValorCuota;

    public Carrito() {
    }

    public Carrito(int CodCarrito, String Nombre_Proyecto, String NumCuenta, String Nombre_Banco, String Tipo_Cuenta, int NumCuota, int TotalPagar, int ValorCuota) {
        this.CodCarrito = CodCarrito;
        this.Nombre_Proyecto = Nombre_Proyecto;
        this.NumCuenta = NumCuenta;
        this.Nombre_Banco = Nombre_Banco;
        this.Tipo_Cuenta = Tipo_Cuenta;
        this.NumCuota = NumCuota;
        this.TotalPagar = TotalPagar;
        this.ValorCuota = ValorCuota;
    }

    

    public int getCodCarrito() {
        return CodCarrito;
    }

    public void setCodCarrito(int CodCarrito) {
        this.CodCarrito = CodCarrito;
    }

    public String getNombre_Proyecto() {
        return Nombre_Proyecto;
    }

    public void setNombre_Proyecto(String Nombre_Proyecto) {
        this.Nombre_Proyecto = Nombre_Proyecto;
    }

    public String getNumCuenta() {
        return NumCuenta;
    }

    public void setNumCuenta(String NumCuenta) {
        this.NumCuenta = NumCuenta;
    }

    public String getNombre_Banco() {
        return Nombre_Banco;
    }

    public void setNombre_Banco(String Nombre_Banco) {
        this.Nombre_Banco = Nombre_Banco;
    }

    public String getTipo_Cuenta() {
        return Tipo_Cuenta;
    }

    public void setTipo_Cuenta(String Tipo_Cuenta) {
        this.Tipo_Cuenta = Tipo_Cuenta;
    }

    public int getNumCuota() {
        return NumCuota;
    }

    public void setNumCuota(int NumCuota) {
        this.NumCuota = NumCuota;
    }

    public int getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(int TotalPagar) {
        this.TotalPagar = TotalPagar;
    }

    public int getValorCuota() {
        return ValorCuota;
    }

    public void setValorCuota(int ValorCuota) {
        this.ValorCuota = ValorCuota;
    }

    @Override
    public String toString() {
        return "Carrito{" + "CodCarrito=" + CodCarrito + ", Nombre_Proyecto=" + Nombre_Proyecto + ", NumCuenta=" + NumCuenta + ", Nombre_Banco=" + Nombre_Banco + ", Tipo_Cuenta=" + Tipo_Cuenta + ", NumCuota=" + NumCuota + ", TotalPagar=" + TotalPagar + ", ValorCuota=" + ValorCuota + '}';
    }
    
    
    
}
