/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import modelo.dao.daoControlador;
import modelo.entidades.Proyecto;

/**
 *
 * @author mjara
 */
public class testModificar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        daoControlador dao = new daoControlador();
        Proyecto pro = new Proyecto("AJUSTE PATIO", "PAISAJISMO", "TERMINADO", "19891214k", "REBOOT SOFTWARE");
        
        if(dao.cambiarEstadoPro(pro)){
            System.out.println("cambiado");
        } else {
            System.out.println("No cambiado");
        }
    }
    
}
