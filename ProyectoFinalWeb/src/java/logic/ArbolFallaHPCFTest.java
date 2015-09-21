/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.google.gson.Gson;
import dto.ArbolFallaDto;
import dto.EventoTopeDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lirio
 */
public class ArbolFallaHPCFTest {
    private EventoTopeDto eventoTope;
    private String nombre;
    private ArbolHPCF arbolHPCF;
    public ArbolFallaHPCFTest(){
     this("");    
    }
    
    public ArbolFallaHPCFTest(String nombre){
    this.nombre=nombre;
    
    }
    
    public static void main(String []args){
        Gson g=new Gson();
        ArbolHPCF arbolHPCF =new ArbolHPCF();
        ArbolFallaDto miArbolHPCF=arbolHPCF.creaArbolFallaHPCF();
        System.out.println("antes de actualizar el valor"+miArbolHPCF.getEventoTope().getValor());
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolFallaHPCFTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         //Gson g=new Gson();
        //String jsonString = g.toJson(miArbolHPCF);
        //System.out.println(jsonString);
        System.out.println("despues de actualizar el objeto"+miArbolHPCF.getEventoTope().getValor());
        System.out.println("---------------------------------------------------------------------");
        ImprimeArbolFalla imprimeArbol= new ImprimeArbolFalla();
        imprimeArbol.imprimeArbol(miArbolHPCF);
        
    }
}
