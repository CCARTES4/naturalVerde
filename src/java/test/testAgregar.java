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
public class testAgregar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        daoControlador dao = new daoControlador();
        Proyecto pro = new Proyecto("AJUSTE PATIO", "PAISAJISMO", "TERM", "19891214k", "REBOOT SOFTWARE");

        if (dao.AgregarProyecto(pro)) {
            System.out.println("cambiado");
        } else {
            System.out.println("No cambiado");
        }
    }

}
