/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.EventObject;

/**
 *
 * @author lirio
 */

public class EventoObjectEvent extends EventObject{
    public EventoDto evento;
    public EventoObjectEvent(Object source,EventoDto evento) {
        super(source);
        this.evento=evento;
    }
    
    public EventoDto getEvento(){
       return this.evento;
    }
    
}
