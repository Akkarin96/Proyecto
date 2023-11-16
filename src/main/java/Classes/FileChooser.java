/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
//Manejo de archivos//
import javax.swing.JFileChooser;
//Permite elegir el archivo dentro de la computadora//
import javax.swing.JOptionPane;
//Muestra los mensajes graficamente//
import org.apache.commons.io.FilenameUtils;
//Para Obtener la ubicacion del archivo//

/**
 *
 * @author alba_
 */
public class FileChooser {
    
    public String obtenerRutaArchivo(){
    FilenameUtils fileUtils=new FilenameUtils();
    String ubicacionArchivo="";
    JFileChooser seleccionArchivo = new JFileChooser();
            int status = seleccionArchivo.showOpenDialog(null);
            //Despliaga la ventana de busqueda de archivo//
            if (status == JFileChooser.APPROVE_OPTION) {
                File archivo = seleccionArchivo.getSelectedFile();
                //asignacion del archivo seleccionado a la variable file//
                if (archivo == null) {
                    JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo");
                }
                else{
                    String fileExtension=fileUtils.getExtension(seleccionArchivo.getSelectedFile().getAbsolutePath());
                    //validar el formato del archivo//
                    if (!fileExtension.equals("txt")){
                        JOptionPane.showMessageDialog(null, "Archivo invalido");
                    }
                else{
                    ubicacionArchivo = seleccionArchivo.getSelectedFile().getAbsolutePath();
                    }
                }
            }
        return ubicacionArchivo;
    }
}
