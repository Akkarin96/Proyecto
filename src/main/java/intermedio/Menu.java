/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Intermedio;

import Classes.CrearArreglo;
import Classes.Ayuda;
import Classes.Consultas;
import Classes.FileChooser;
import Classes.FileReader;
import Classes.Votos;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.ArrayUtils;
/**
 *
 * @author alba_
 */
public class Menu {
    
    public String[][] getPadron() {
        return padron;
    }

    public void setPadron(String[][] padron) {
        this.padron = padron;
    }

    public String[][] getPartidos() {
        return partidos;
    }

    public void setPartidos(String[][] partidos) {
        this.partidos = partidos;
    }
       String[][] padron;
       String[][] partidos;
    
    public void menuInicio() throws IOException, ParseException{

       String datosPadron="";
       String datosPartidos="";
       int seleccion=0;
       while (seleccion<5) {
         do{   
         seleccion=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una de las siguientes opciones:"+"\n"+
                 "1- Iniciar Votaciones"+"\n"+
                 "2- Realizar Consultas"+"\n"+
                 "3- Imprimir Resultados de Votacion"+"\n"+
                 "4- Ayuda"+"\n"+
                 "5- Salir"));
         }while (seleccion>5);
         switch (seleccion){
             case 1:
                 FileChooser seleccionArchivos=new FileChooser();
                 JOptionPane.showMessageDialog(null,"Elija el archivo que contenga el padrón electoral");
                 String archivoPadron= seleccionArchivos.getFilePath();
                 JOptionPane.showMessageDialog(null,"Elija el archivo que contenga los datos de los partidos");
                 String archivoPartidos=seleccionArchivos.getFilePath();
                 FileReader lectorArchivos= new FileReader(archivoPadron, archivoPartidos);
                 lectorArchivos.dataLoad();
                 datosPadron=lectorArchivos.getFileData();
                 datosPartidos=lectorArchivos.getPartidosData();
                 CrearArreglo crearArrays=new CrearArreglo(datosPadron, datosPartidos);
                 crearArrays.crearArrays();
                 setPadron(crearArrays.getPadron());
                 setPartidos(crearArrays.getPartidos());
                 Votos votos= new Votos(getPadron(),getPartidos());
                 votos.Votaciones();
                 setPadron(votos.getPadron());
                 setPartidos(votos.getPartidos());
                 break;
             case 2:
                 int tipoConsulta=0;
                 if((ArrayUtils.isEmpty(padron))||ArrayUtils.isEmpty(partidos)){
                     JOptionPane.showMessageDialog(null, "Para realizar consultas, debe llenar los padrones primero!");
                     break;
                 }
                 else{
                    do{   
                        tipoConsulta=Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione una de las siguientes opciones:"+"\n"+
                        "1- Consulta por Nombres"+"\n"+
                        "2- Consulta por Primer Apellido"+"\n"+
                        "3- Consulta por Segundo Apellido"+"\n"+
                        "4- Volver al Menu Principal"));
                    }while (tipoConsulta>4);
                    Consultas cons=new Consultas(getPadron(),getPartidos());
                    String nombreBuscar="";
                    switch (tipoConsulta){
                        case 1:                    
                            nombreBuscar=JOptionPane.showInputDialog("Digite el nombre a consultar:");
                            cons.consultasNombre(nombreBuscar);
                            break;
                        case 2:
                            nombreBuscar=JOptionPane.showInputDialog("Digite el apellido a consultar:");
                            cons.consultasApellido1(nombreBuscar);
                        break; 
                        case 3: 
                            nombreBuscar=JOptionPane.showInputDialog("Digite el apellido a consultar:");
                            cons.consultasApellido2(nombreBuscar);
                            break;
                        case 4: 
                            break;
                        default: JOptionPane.showMessageDialog(null, "Opcion Invalida. Intente de nuevo");      
                    }
                    break; 
                    }
             case 3:
                 if((ArrayUtils.isEmpty(padron))||ArrayUtils.isEmpty(partidos)){
                     JOptionPane.showMessageDialog(null, "Para realizar consultas, debe llenar los padrones primero!");
                     break;
                 }
                 else{
                    String msg="";
                    int nulos=0;
                    Consultas res=new Consultas(getPadron(),getPartidos());
                    msg=res.ganadorOficial()+"\n"+"Total de votos nulos: "+res.obtenerVotosNulos();
                    JOptionPane.showMessageDialog(null, msg); 
                    break;
                 }
             case 4:
                 Ayuda ayuda=new Ayuda();
                 ayuda.mensajeAyuda();
                 break;
             case 5:
                 JOptionPane.showMessageDialog(null, "Gracias por usar el mensaje");
                 break;
             default:
                 JOptionPane.showMessageDialog(null, "Opcion invalida, intente de nuevo");                
         }
        }
    }
}