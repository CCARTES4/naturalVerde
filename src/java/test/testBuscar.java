/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;
import modelo.dao.daoControlador;
import modelo.entidades.Historial;
import modelo.entidades.Insumo;
import modelo.entidades.Proyecto;
import modelo.entidades.Solicitud;
import modelo.entidades.Trabajador;
import oracle.net.aso.i;

/**
 *
 * @author mjara
 */
public class testBuscar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        daoControlador dao = new daoControlador();
        List<Solicitud> nana = dao.fechaSolicitud("SISTEMA DE REGADO");
        
        for (Solicitud soli : nana) {
            System.out.println(soli.toString());
        }
        
        
    }

}
