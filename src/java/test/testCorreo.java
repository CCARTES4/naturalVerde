/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Correo.enviarCorreo;

/**
 *
 * @author mjara
 */
public class testCorreo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        enviarCorreo ec = new enviarCorreo();
        ec.SendMail("El empleado se ha guardado correctamente", "mjaral@outlook.com", "PROBANDO");
    }

}
