/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FilenameUtils; //permite obtener informacion del archivo

/**
 *
 * @author alba_
 */
public class FileChooser {
    
    public String getFilePath(){
    FilenameUtils fileUtils=new FilenameUtils();
    String fileName="";
    JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file == null) {
                    JOptionPane.showMessageDialog(null, "No se selecciono archivo!");
                }
                else{
                    String fileExtension=fileUtils.getExtension(chooser.getSelectedFile().getAbsolutePath());
                    //JOptionPane.showMessageDialog(null, fileExtension);
                    if (!fileExtension.equals("txt")){
                        JOptionPane.showMessageDialog(null, "Archivo invalido!");
                    }
                else{
                    fileName = chooser.getSelectedFile().getAbsolutePath();
                    }
                }
            }
        return fileName;
    }
} // se obtiene la direccion o ruta a la hora de seleccionar los archivos