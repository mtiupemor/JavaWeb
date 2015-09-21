/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

//import com.google.gson.Gson;
import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoTopeDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IIE
 */
public class ArbolFallaRCICTest {
    private EventoTopeDto eventoTope;
    private String nombre;
    private ArbolRCIC arbolRCIC;
    public ArbolFallaRCICTest(){
     this("");    
    }
    
    public ArbolFallaRCICTest(String nombre){
    this.nombre=nombre;
    
    }
    
    public static void main(String []args){
       // Gson g=new Gson();
        ArbolRCIC arbolRCIC =new ArbolRCIC();
        ArbolFallaDto miArbolRCIC=arbolRCIC.creaArbolFallaRCIC();
        System.out.println("antes de actualizar el valor" + miArbolRCIC.getEventoTope().getValor());
        try {
            arbolRCIC.evento3.setValor(0.2d);
            arbolRCIC.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolFallaRCICTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Falla del ERCI despues de actualizar" + miArbolRCIC.getEventoTope().getValor());
          
       System.out.println(miArbolRCIC.getEventoTope().toJsonObject().toString());
       
        System.out.println("---------------------------------------------------------------------");
        
        //ImprimeArbolFalla imprimeArbol= new ImprimeArbolFalla();
        //imprimeArbol.imprimeArbol(miArbolRCIC);
        
        //System.out.println(miArbolRCIC);
        
        //Gson g=new Gson();      
        
        //String jsonString = g.toJson(miArbolRCIC);
        //System.out.println(jsonString);
    
        
    }
}
