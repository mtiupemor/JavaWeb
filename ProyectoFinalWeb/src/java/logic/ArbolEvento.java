/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.ArbolEventoDto;
import dto.ArbolFallaDto;
import dto.EventoIniciadorDto;
import dto.SistemaDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IIE
 */
public class ArbolEvento {
    ArbolEventoDto arbolEvento;
    public ArbolEvento(){
    arbolEvento=new ArbolEventoDto();
    }
    public static  void main(String []args){
        ArbolEvento arbolEvento=new ArbolEvento();
        
        //Crear el arbol de eventos LOCA Grande
        EventoIniciadorDto ei=new EventoIniciadorDto();
        ei.setValor(0.2d);
        ei.setId("EI");
        ei.setNombre("cayoyas");
        
        arbolEvento.arbolEvento.setEventoIniciador(ei);
        arbolEvento.arbolEvento.setId("aaa");
        //Se iran creando los sitemas
        //Se crea el primer sistema Apagado del reactor
        SistemaDto apagadoReactor=new SistemaDto();
        ArbolHPCF arbolHPCF =new ArbolHPCF();
        ArbolFallaDto miArbolHPCF=arbolHPCF.creaArbolFallaHPCF();
        apagadoReactor.setArbolFalla(miArbolHPCF);
        apagadoReactor.setNombre("Apagado del reactor");
        apagadoReactor.setId("A");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        //apagadoReactor.setFrecuencia(ei.getValor()*miArbolHPCF.getEventoTope().getValor());
        //apagadoReactor.setValorExito(ei.getValor()*(1-miArbolHPCF.getEventoTope().getValor()));
        //Se crea el segundo sistema HPCS, que es el exito del sistema Apagado del reactor 
        //se le agrega el mismo arbol HPCF creado
        SistemaDto sistemaHPCS =new SistemaDto();
        sistemaHPCS.setArbolFalla(miArbolHPCF);
        sistemaHPCS.setNombre("HPCS");
        sistemaHPCS.setId("B");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sistemaHPCS.setFrecuencia(apagadoReactor.getValorExito()*miArbolHPCF.getEventoTope().getValor());
        //sistemaHPCS.setValorExito(apagadoReactor.getValorExito()*(1 - miArbolHPCF.getEventoTope().getValor()));
        //Se crea el tercer sistema LPCS, que es la falla del sistema HPCS
        SistemaDto sistemaLPCS=new SistemaDto();
        sistemaLPCS.setArbolFalla(miArbolHPCF);
        sistemaLPCS.setNombre("LPCS");
        sistemaLPCS.setId("C");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sistemaLPCS.setFrecuencia(ei.getValor()*miArbolHPCF.getEventoTope().getValor());
        //Se crea el cuarto sistema LPCI, que es el exito del sistema HPCS y tambien el exito del sistema LPCS
        //se le agrega el mismo arbol RCIC creado
        SistemaDto sistemaLPCI=new SistemaDto();
        sistemaLPCI.setArbolFalla(miArbolHPCF);
        sistemaLPCI.setNombre("LPCI");
        sistemaLPCI.setId("D");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        SistemaDto sistemaLPCI2=new SistemaDto();
        sistemaLPCI2.setArbolFalla(miArbolHPCF);
        sistemaLPCI2.setNombre("LPCI");
        sistemaLPCI2.setId("E");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Se crea el sistema recuperación que será la falla del sistema LPCI
        //Se le agrega el arol RCIC ya creado
        SistemaDto recuperacion=new SistemaDto();
        recuperacion.setArbolFalla(miArbolHPCF);
        recuperacion.setNombre("recuperacion");
        recuperacion.setId("F");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SistemaDto recuperacion2=new SistemaDto();
        recuperacion2.setArbolFalla(miArbolHPCF);
        recuperacion2.setNombre("recuperacion");
        recuperacion2.setId("G");
        try {
            arbolHPCF.evento3.setValor(0.2d);
            arbolHPCF.evento6.setValor(0.1d);
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        arbolEvento.arbolEvento.setSistema(apagadoReactor);
        
        apagadoReactor.setExito(sistemaHPCS);   //A
        sistemaHPCS.setExito(sistemaLPCI);      //B
        sistemaLPCI.setFalla(recuperacion);     //D
        sistemaHPCS.setFalla(sistemaLPCS);      //D
        sistemaLPCS.setExito(sistemaLPCI2);     //E
        sistemaLPCI2.setFalla(recuperacion2);   //F
        
        //Se conectan los sitemas
        
        InsertarArbolEvento e = new InsertarArbolEvento();        
        e.insertarLogico(arbolEvento.arbolEvento);
        
        
        /*
        //arbolEvento.arbolEvento.addSistema(apagadoSistema);
        //arbolEvento.arbolEvento.addSistema(sistemaRCIC);
       System.out.println("............................................................................."); 
       ImprimeArbolEventos imprimeArbol = new ImprimeArbolEventos();
       imprimeArbol.imprimeArbol(arbolEvento.arbolEvento);
       System.out.println(".............................................................................");        
//        Gson g=new Gson();
//        String jsonString = g.toJson(miArbolHPCF);
//        System.out.println(jsonString);

                */
    }
    
    
    
    
}
