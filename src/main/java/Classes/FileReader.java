/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author josep
 */
public class FileReader {
    String padronPath="";
    String padronData="";
    String partidosPath="";
    String partidosData="";

    public String getPartidosData() {
        return partidosData;
    }

    public void setPartidosData(String partidosData) {
        this.partidosData = partidosData;
    }
    String[] padron;

    public String getFileData() {
        return padronData;
    }

    public void setFileData(String padronData) {
        this.padronData = padronData;
    }
    
    public FileReader (String padronPath,String partidosData){
        this.padronPath=padronPath;
        this.partidosPath=partidosData;
    }
     private void readFile(String padronFile, String partidosFile)throws IOException{
        String data="";
        Scanner myReader;
        for (int x=0; x<=1;x++)
        try {
            if (x==0){
                File myObj = new File(padronFile);
                myReader = new Scanner(myObj);
            }
            else{
                 File myObj = new File(partidosFile);
                 myReader = new Scanner(myObj);
            }
            while (myReader.hasNextLine()) {
                data =data+"\n"+myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            //Scanner myReader = new Scanner(myObj);
            if (x==0){
               setFileData(data);
               data="";
            }
            else{
                setPartidosData(data);
            }
            
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
         
  }
     
    private void spaceRemovers(){
        String withoutWhitespace = getFileData().replaceAll("[\\s&&[^\\n]]+", " ").replaceAll("(?m)^\\s|\\s$", "").replaceAll("\\n+", "\n").replaceAll("^\n|\n$", "") ;
        setFileData(withoutWhitespace);
        String cleanPartido=getPartidosData().replaceAll("[\\s&&[^\\n]]+", " ").replaceAll("(?m)^\\s|\\s$", "").replaceAll("\\n+", "\n").replaceAll("^\n|\n$", "") ;
        setPartidosData(cleanPartido);
    }
    public void dataLoad() throws IOException, ParseException{
        readFile(this.padronPath,this.partidosPath);

        //setFileData(getFileData());
        //setPartidosPath(partidosPath);
        spaceRemovers();
        if ((padronPath.isEmpty())||(partidosPath.isEmpty())){
            JOptionPane.showMessageDialog(null, "Error: Uno o más archivos no fueron cargados");
        }
        else{
             JOptionPane.showMessageDialog(null, "Archivos leidos exitosamente!");
            
            }
       
       /* JOptionPane.showMessageDialog(null, """
                                            Data on Padron File: 
                                            """+getFileData());
        JOptionPane.showMessageDialog(null, """
                                            Data on Partidos File: 
                                            """ +getPartidosData());*/
       
    
    }
                                       
}             
           
  
     