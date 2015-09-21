/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.EventListener;

/**
 *
 * @author lirio
 */
interface EventoEventListener extends EventListener{
    void valorUpdate(EventoDto evento);    
}
