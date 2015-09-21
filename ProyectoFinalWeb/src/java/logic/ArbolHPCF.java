/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.EventoTopeDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lirio
 */
public class ArbolHPCF {
    dto.ArbolFallaDto arbolFalla;
    EventoDto evento1;
    EventoDto evento2;
    EventoDto evento3;
    public EventoDto evento4;
    EventoDto evento5;
    EventoDto evento6;
    EventoDto evento7;
    EventoDto evento8;
    public dto.ArbolFallaDto creaArbolFallaHPCF(){
       arbolFalla=new ArbolFallaDto();
       EventoTopeDto et=new EventoTopeDto();
        evento1=new EventoDto();
        evento2=new EventoDto();
        evento3=new EventoDto();
        evento4=new EventoDto();
        evento5=new EventoDto();
        evento6=new EventoDto();
        evento7=new EventoDto();
        evento8=new EventoDto();
       et.setNombre("Falla del HPCF");
       arbolFalla.setEventoTope(et);
       
       
       
       
       try {       
       evento1.setNombre("Falla del HPCF-B");
       evento1.setValor(0.2);
       
       evento2.setNombre("Falla del HPCF-C");
       evento2.setValor(0.1);
       
       evento3.setNombre("Falla de potencia en la divición 2");
       evento3.setValor(0.2);
       
       evento4.setNombre("Falla del HPCF-B");
       evento4.setValor(0.3);
       
       evento5.setNombre("HPCF-B indisponible por mantenimiento");
       evento5.setValor(0.24);
       
       evento6.setNombre("Falla de potencia en la divición 3");
       evento6.setValor(0.1);
       
       evento7.setNombre("Falla del HPCF-C");
       evento7.setValor(0.12);
       
       evento8.setNombre("HPCF-C indisponible por mantenimiento");
       evento8.setValor(0.1);
       
        } catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolHPCF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       CompuertaLogicaDto compuerta2=new CompuertaLogicaDto("2",CompuertaLogicaDto.TYPO.OR);
       compuerta2.setEventoHijo(evento3);
       compuerta2.setEventoHijo(evento4);
       compuerta2.setEventoHijo(evento5);
       
       CompuertaLogicaDto compuerta3=new CompuertaLogicaDto("3",CompuertaLogicaDto.TYPO.OR);
       compuerta3.setEventoHijo(evento6);
       compuerta3.setEventoHijo(evento7);
       compuerta3.setEventoHijo(evento8);
       
       evento1.setHijo(compuerta2);
       evento2.setHijo(compuerta3);
       
       CompuertaLogicaDto compuerta1=new CompuertaLogicaDto("4",CompuertaLogicaDto.TYPO.AND);
       compuerta1.setEventoHijo(evento1);
       compuerta1.setEventoHijo(evento2);
     
       et.setHijo(compuerta1);
     
       //InsertarArbolFalla tree = new InsertarArbolFalla();       
      // tree.insertar(arbolFalla);
   
       return arbolFalla;
    }
}
