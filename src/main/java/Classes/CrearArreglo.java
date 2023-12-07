/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author alba_
 */
public class CrearArreglo {
    String padronData="";
    String partidosData="";
    int filasPadron=0;
    int columnasPadron=0;
    int filasPartidos=0;
    String[] padronLineas;
    String[] padronColumnas;
    String[] partidosLineas;
    String[] partidosColumnas;
    String[][] padron;
    String[][] partidos;

     public CrearArreglo(String contenidoPadron,String contenidoPartidos){
        this.padronData=contenidoPadron;
        this.partidosData=contenidoPartidos;
    }
     
    public String[][] getPartidos() {
        return partidos;
    }

    public void setPartidos(String[][] partidos) {
        this.partidos = partidos;
    }
    
    public String[][] getPadron() {
        return padron;
    }

    public void setPadron(String[][] padron) {
        this.padron = padron;
    }

    public String[] getPartidosLineas() {
        return partidosLineas;
    }

    public void setPartidosLineas(String[] partidosLineas) {
        this.partidosLineas = partidosLineas;
    }

    public String[] getPartidosColumnas() {
        return partidosColumnas;
    }

    public void setPartidosColumnas(String[] partidosColumnas) {
        this.partidosColumnas = partidosColumnas;
    }

    public String[] getPadronLineas() {
        return padronLineas;
    }

    public void setPadronLineas(String[] padronLineas) {
        this.padronLineas = padronLineas;
    }

    public String[] getPadronColumnas() {
        return padronColumnas;
    }

    public void setPadronColumnas(String[] padronColumnas) {
        this.padronColumnas = padronColumnas;
    }

    public int getFilasPartidos() {
        return filasPartidos;
    }

    public void setFilasPartidos(short filasPartidos) {
        this.filasPartidos = filasPartidos;
    }
    short columnasPartidos=0;

    public int getFilasPadron() {
        return filasPadron;
    }

    public void setFilasPadron(short filasPadron) {
        this.filasPadron = filasPadron;
    }

    public int getColumnasPadron() {
        return columnasPadron;
    }

    public void setColumnasPadron(short columnasPadron) {
        this.columnasPadron = columnasPadron;
    }

    public short getColumnasPartidos() {
        return columnasPartidos;
    }

    public void setColumnasPartidos(short columnasPartidos) {
        this.columnasPartidos = columnasPartidos;
    }

    public void crearArrays() throws ParseException{
       if ((padronData.equals(""))||(partidosData.equals("")) ){
           JOptionPane.showMessageDialog(null,"Error 404: Archivos Padron/Partidos no encontrados!");
        }
       else{
        ArraySize(padronData,"padron");
        ArraySize(partidosData, "partidos");
        setPadron(llenaArreglos(filasPadron, columnasPadron, padronData));
        setPartidos(llenaArreglos(filasPartidos, columnasPartidos, partidosData));
        JOptionPane.showMessageDialog(null,"Creacion y relleno de arrays completa");
        /*Votos votos=new Votos(padron,partidos);
        votos.Votaciones();*/
       }
        
    }
    
    private void ArraySize(String data,String contenido){//This method grabs the data from previous files, and defines how many rows/columns will be needed for both Padron/Partidos Array
        short numeroFilas=0;
        short numeroColumnas=0;
        String[] filas = data.split("\\r?\\n|\\r");//splits lines into arrays
        String[] columnas=filas[0].split(",");//splits array into columns
        numeroFilas=(short) (filas.length);
        numeroColumnas=(short)(columnas.length+1);
        if(contenido.equals("padron")){
            setColumnasPadron(numeroColumnas);
            setFilasPadron(numeroFilas);
            setPadronLineas(filas);
            setPadronColumnas(columnas);
        }
        else{
            setColumnasPartidos(numeroColumnas);
            setFilasPartidos(numeroFilas);
            setPartidosColumnas(columnas);
            setPartidosLineas(filas);  
        }   
    }
    private String[][] llenaArreglos(int filasMatriz,int columnasMatriz,String archivoData){//this method creates the array according to the given size, splits the data into rows/colums and fill the array
        String[] filas = archivoData.split("\\r?\\n|\\r");//splits lines into arrays
        String matriz[][]=new String[filasMatriz][columnasMatriz];
        for (int x=0;x<=filas.length-1;x++ ){
            String[] columnas=filas[x].split(",");//splits array into columns
            for (int y=0;y<=columnas.length-1;y++ ){
                matriz[x][y]=columnas[y];
            }
        }
        return matriz;
    }
    }
    