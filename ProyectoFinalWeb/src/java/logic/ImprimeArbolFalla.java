/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;

/**
 *
 * @author IIE
 */
public class ImprimeArbolFalla {
        
     public void imprimeArbol(ArbolFallaDto arbol) {
    if (arbol != null) {      
      leerCompuerta(arbol.getEventoTope().getHijo()); 
    }
  }

  /**
   * 
   *
   * @param valorInsertar dato tipo T
   */
 
  private void leerCompuerta(CompuertaLogicaDto compuerta) {
    
    if (compuerta != null) {
      System.out.println("Compuerta: " + compuerta.getTipotoString());
      for(CompuertaLogicaDto c : compuerta.getHijosCompuertas() ){
        leerCompuerta(c);
  
      }      
    
      for (EventoDto e : compuerta.getHijosEventos()){
        System.out.println("Evento: " + e.getNombre());
        leerCompuerta(e.getHijo());
              
      }
    }
  }
  }