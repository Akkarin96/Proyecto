/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import javax.swing.JOptionPane;
/**
 *
 * @author alba_
 */
public class Consultas {
    String[][] padronCompleto;
    String[][] partidosCompleto;
    int votosNulos=0;

    public int getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public Consultas (String[][] padron, String[][] partidos){
        this.padronCompleto=padron;
        this.partidosCompleto=partidos;
    }
    
    public void consultasNombre(String nombre){
        int[] resultados;
        resultados= new int[partidosCompleto.length];
        String datos="";
        String ganador="";
        String nombreFormato=nombre.toUpperCase();
        int indice=0;
        for (int x=0;x<=padronCompleto.length-1;x++){
            if (padronCompleto[x][5].contains(nombreFormato)){
                if(padronCompleto[x][8].equals("nulo")){
                    datos=datos+"\n"+"El voto de la Persona "+padronCompleto[x][5]+padronCompleto[x][6]+" ha sido anulado"+"\n";
                }
                else{
                    datos=datos+"\n"+"La Persona "+padronCompleto[x][5]+" ha votado por el Partido: "+padronCompleto[x][8]+"\n";
                    indice=asignarVotos(padronCompleto[x][8]);
                    resultados[indice]=resultados[indice]+1;
                }
                
            }
        }
        if(datos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Lo sentimos. No hay registro de votos con el nombre dado"); 
        }
        else{
            ganador=declararGanador(resultados);
            votosBusquedas(resultados, nombre);
            JOptionPane.showMessageDialog(null, datos);
            JOptionPane.showMessageDialog(null, ganador);
        }
    }
    
    public void consultasApellido1(String apellido){
        int[] resultados;
        resultados= new int[partidosCompleto.length];
        String datos="";
        String ganador="";
        int indice=0;
        String apellidoFormato=apellido.toUpperCase();
        for (int x=0;x<=padronCompleto.length-1;x++){
            if (padronCompleto[x][6].contains(apellidoFormato)){
                 if(padronCompleto[x][8].equals("nulo")){
                    datos=datos+"\n"+"El voto de la Persona "+padronCompleto[x][5]+padronCompleto[x][6]+" ha sido anulado"+"\n";
                }
                else{
                    datos=datos+"\n"+"La Persona "+padronCompleto[x][5]+padronCompleto[x][6]+" ha votado por el Partido: "+padronCompleto[x][8]+"\n";
                    indice=asignarVotos(padronCompleto[x][8]);
                    resultados[indice]=resultados[indice]+1;
                }
            }
        }
        if(datos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Lo sentimos. No hay registro de votos con el nombre dado"); 
        }
        else{
            ganador=declararGanador(resultados);
            votosBusquedas(resultados, apellido);
            JOptionPane.showMessageDialog(null, datos);
            JOptionPane.showMessageDialog(null, ganador);
            
        }
    }
    
    public void consultasApellido2(String apellido){
        int[] resultados;
        resultados= new int[partidosCompleto.length];
        String datos="";
        String ganador="";
        String apellidoFormato=apellido.toUpperCase();
        int indice=0;
        for (int x=0;x<=padronCompleto.length-1;x++){
            if (padronCompleto[x][7].contains(apellidoFormato)){
                if (padronCompleto[x][6].contains(apellidoFormato)){
                    if(padronCompleto[x][8].equals("nulo")){
                        datos=datos+"\n"+"El voto de la Persona "+padronCompleto[x][5]+padronCompleto[x][6]+" ha sido anulado"+"\n";
                    }
                    else{
                        datos=datos+"\n"+"La Persona "+padronCompleto[x][5]+padronCompleto[x][6]+ padronCompleto[x][7]+" ha votado por el Partido: "+padronCompleto[x][8]+"\n";
                        indice=asignarVotos(padronCompleto[x][8]);
                        resultados[indice]=resultados[indice]+1;
                    }
                }
            }
        }
        if(datos.isEmpty()){
            JOptionPane.showMessageDialog(null, "Lo sentimos. No hay registro de votos con el nombre dado"); 
        }
        else{
            ganador=declararGanador(resultados);
            JOptionPane.showMessageDialog(null, datos);
            votosBusquedas(resultados, apellido);
            
            JOptionPane.showMessageDialog(null, ganador);
        }
    }
        
        private int asignarVotos(String partido){
            int indice=0;
            if (partido.equals("nulo")){
                return -1;
            }
            else{
            for (int x=0;x<=partidosCompleto.length-1;x++){
                if (partido.equals(partidosCompleto[x][0])){
                    indice=x;
                    break;
                }
            }
            }
            return indice;
        }
        
        public int obtenerVotosNulos(){
            for (int x=0;x<=padronCompleto.length-1;x++){
                if (padronCompleto[x][8].equals("nulo")){
                    setVotosNulos(getVotosNulos()+1);
                }
            }
            return getVotosNulos();
        }
        
        private String declararGanador(int[] votos){
            int max=0;
            int indice=0;
            String msg="";
            for (int x=0;x<=votos.length-1;x++){
                if(max<votos[x]){
                    max=votos[x];
                    indice=x;
                    msg="El partido ganador de acuerdo a esta busqueda es: "+ partidosCompleto[indice][0]+ " con "+max+ " votos";
                }
                else if(max==votos[x]){
                    msg="Hay un empate entre 2 o más partidos";
                }
            }
            
            return msg;
        }
        
        public String ganadorOficial(){
            int max=0;
            int indice=0;
            String msg="";
            for (int x=0;x<=partidosCompleto.length-1;x++){
                int votosPartido=Integer.parseInt(partidosCompleto[x][1]);
                if(max<votosPartido){
                    max=votosPartido;
                    indice=x;
                    msg="El partido ganador de las elecciones es: "+ partidosCompleto[indice][0]+ " con "+max+ " votos";
                }
                else if(max==votosPartido){
                    msg="Hay un empate entre 2 o más partidos";
                }
            }
            return msg;
        }
        
        private void votosBusquedas(int[] votos, String busqueda){
            String msg="";
            for (int x=0;x<=votos.length-1;x++){
                msg=msg+"El partido "+partidosCompleto[x][0]+" obtuvo "+votos[x]+" votos de los "+busqueda+"\n";  
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    
}

