/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.padron;
import Classes.FileReader;
import Classes.FileChooser;
import java.io.IOException;
//Validar errores con el formato del archivo//


/**
 *
 * @author alba_
 */
public class Padron {

    public static void main(String[] args) throws IOException {
        FileChooser fc= new FileChooser();
        String padronPath=fc.obtenerRutaArchivo();
        FileReader fr= new FileReader(padronPath);
        fr.cargarPadron();
    }
}
