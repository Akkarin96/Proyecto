/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author alba_
 */
public class Votos {

  
    String[][] padron;
    String[][] partidos;
    int nulos=0;

    public int getNulos() {
        return nulos;
    }

    public void setNulos(int nulos) {
        this.nulos = nulos;
    }
    
      public String[][] getPadron() {
        return padron;
    }

    public String[][] getPartidos() {
        return partidos;
    }

    public Votos(String [][]datosPadron, String [][]datosPartidos) {
        this.padron=datosPadron;
        this.partidos=datosPartidos;
    }
    
    public Votos(){}
    
    public void Votaciones() throws ParseException{
        generarVotos();
        asignarVotos();
        JOptionPane.showMessageDialog(null, "Votaciones cerradas!");
        
    }
    
    private void generarVotos() throws ParseException{
        for (int x=0;x<=padron.length-1;x++){
            String fechaExp=padron[x][3];
            LocalDate cedulaExp=convertirFecha(fechaExp);
            if (puedeVotar(cedulaExp)){
                padron[x][8]=obtenerVoto();
            }
            else{
                padron[x][8]="nulo";
            } 
        }
    }
    
    private LocalDate convertirFecha(String fechaExp) throws ParseException{
        LocalDate today = LocalDate.now();
        SimpleDateFormat formato= new SimpleDateFormat("yyyyMMdd");
        Date fecha=formato.parse(fechaExp);
        LocalDate fechaCedula=fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return fechaCedula; 
    }
    private LocalDate obtenerFechaActual(){
        LocalDate today = LocalDate.now();
        return today;
    }
    
    private boolean puedeVotar(LocalDate fechaExp){
        if(fechaExp.isAfter(obtenerFechaActual())){
            return true;
        }
        else{
            return false;
        }
    }
    
    private String obtenerVoto(){
        Random rand=new Random();
        int partidoRandom=rand.nextInt(0, partidos.length);
        String voto=partidos[partidoRandom][0].toString(); 
        return voto;
    }
    
    private void asignarVotos(){
        int votos=0;

        for (int x=0;x<=partidos.length-1;x++){
            for(int y=0;y<=padron.length-1;y++){
            if (padron[y][8].equals(partidos[x][0])){
                votos++;
                //para recorrer el rarreglo con la informacion del padron cargada y que en la octava columna asigne la votacion
            }
            else if (padron[y][8].equals("nulo")){
                setNulos(getNulos()+1);
            }
            }
            partidos[x][1]=String.valueOf(votos);
            votos=0;      
        }
    }
   
}