/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dto.ArbolEventoDto;
import dto.SistemaDto;

/**
 *Clase para imprimir el arbol de eventos completos
 * @author IIE
 */
public class ImprimeArbolEventos {
    public void imprimeArbol(ArbolEventoDto arbolEvento){
        if (arbolEvento != null){
            leerSistema(arbolEvento.getSistema());
        }
    }
    
    private void leerSistema(SistemaDto sistema){
        if(sistema != null){
            System.out.println("Sistema: " + sistema.getNombre());
            System.out.println("Valor arbol: " + sistema.getArbolFalla().getEventoTope().getValor());
            System.out.println("Frecuencia: " + sistema.getFrecuencia());
            System.out.println("valorExito: " + sistema.getValorExito());
            leerSistema(sistema.getExito());
            leerSistema(sistema.getFalla());
            }

        }
}
