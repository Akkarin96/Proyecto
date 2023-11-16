/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author alba_
 */
public class FileReader {
    String rutaArchivo="";
    
    
    
    private String contenidoArchivo="";
    
    
    public FileReader (String rutaArchivo){
        this.rutaArchivo=rutaArchivo;
    }
     private void readFile()throws IOException{
        String info="";
        try {
            File objeto = new File(rutaArchivo);
            Scanner leerArchivo = new Scanner(objeto);
            while (leerArchivo.hasNextLine()) {
                info =info+"\n"+leerArchivo.nextLine();
                System.out.println(info);
            }
            leerArchivo.close();
        } catch (FileNotFoundException e) {
        System.out.println("Ha ocurrido un error X.X ");
        e.printStackTrace();
        //Se lee linea por linea del archivo y se asigna a una variable//
    }
        
         setContenidoArchivo(info);
         
  }
     
    private void spaceRemovers(){
        String sinEspacios = getContenidoArchivo().replaceAll("[\\s&&[^\\n]]+", " ")
                .replaceAll("(?m)^\\s|\\s$", "").replaceAll("\\n+", "\n")
                .replaceAll("^\n|\n$", "") ;
        setContenidoArchivo(sinEspacios);
    }
    public void cargarPadron() throws IOException{
        readFile();
        //setContenidoArchivo(getContenidoArchivo());//
        spaceRemovers();
        if (rutaArchivo.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se ha seleccionado un archivo valido");
        }
        else{
        JOptionPane.showMessageDialog(null, "Data on File: "+"\n" +getContenidoArchivo());
    }
    }
    
    
    

    /**
     * @return the contenidoArchivo
     */
    public String getContenidoArchivo() {
        return contenidoArchivo;
    }

    /**
     * @param contenidoArchivo the contenidoArchivo to set
     */
    public void setContenidoArchivo(String contenidoArchivo) {
        this.contenidoArchivo = contenidoArchivo;
    }
                                       
}             
           
  
     

