/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.lang.reflect.Array;

/**
 *
 * @author alba_
 */
public class Votos {
    short filasPadron=0;
    short columnasPadron=0;
    short filasPartidos=0;
    short columnasPartidos=0;
    String padron;
    String partidos;
    String[][] datosPadron;

    public Votos(short filasPad,short colPad,short filasPar,short colPar,String padronData, String partidosData) {
        this.filasPadron = filasPad;
        this.columnasPadron=colPad;
        this.filasPartidos=filasPar;
        this.columnasPartidos=colPar;
        this.padron=padronData;
        this.partidos=partidosData;
    }
    
    public void Votaciones(){
        crearMatrizPadron();
    }
    
    private void crearMatrizPadron(){
       
        datosPadron= new String [filasPadron][columnasPadron];
        int data=0;
        for (int x=0;x<=filasPadron-1;x++){
            for (int y=0;y<=columnasPadron-1;y++){
                datosPadron[x][y]="test"+data;
                data++;
            }
        }
        for (int x=0;x<=filasPadron-1;x++){
            for (int y=0;y<=columnasPadron-1;y++){
                System.out.println(datosPadron[x][y]);
            }
        }
    }
    

}
