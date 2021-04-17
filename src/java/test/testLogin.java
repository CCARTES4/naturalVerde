/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.daoControlador;

/**
 *
 * @author mjara
 */
public class testLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        daoControlador dao = new daoControlador();
        
        try {
            if (dao.LoginAdmin("ADMIasdasdN", "123")) {
                System.out.println("Encontrado");
            } else {
                System.out.println("NO Encontrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(testLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
