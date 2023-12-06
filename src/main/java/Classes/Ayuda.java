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
public class Ayuda {
    public void mensajeAyuda(){
        String msgCarga="Para utilizar la aplicación debe contar con los siguientes archivos en formato .txt (Cualquier otro formato es inválido):"+"\n"+
                    "-Padron de Votantes"+"\n"+
                    "-Lista de Partidos"+"\n"+
                    "Dichos archivos DEBEN SER CARGADOS EN DICHO ORDEN, caso contrario la App no va a funcionar"+"\n"+
                    "Una vez cargados, la App automaticamente creará y asignará los votos automáticamente. Una vez finalizado cada proceso le notificará al usuario";
        String msgConsultas="Después de finalizar con las votaciones, podrá realizar las consultas descritas a continuación: "+"\n"+
                "-Consulta por nombres"+"\n"+
                "-Consulta por Primer Apellido"+"\n"+
                "-Consulta por Segundo Apellido"+"\n"+
                "-Consulta Resultados"+"\n"+
                "Cabe destacar que las consultas devolverán resultados equivalentes al criterio de búsqueda"+"\n"+
                "Por ejemplo: Si buscas Ar la aplicación puede retornar: Armando, Maria, Omar etc";
        String msgAdicional="Tiene más consultas sobre el uso de esta app? Envie su correo con su mensaje al ***@***.com";
        JOptionPane.showMessageDialog(null, msgCarga);
        JOptionPane.showMessageDialog(null, msgConsultas);
        JOptionPane.showMessageDialog(null, msgAdicional);
    }
}
    

