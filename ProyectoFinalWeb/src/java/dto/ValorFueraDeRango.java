/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author IIE
 */
public class ValorFueraDeRango extends Exception {
    public ValorFueraDeRango(){};
    
    public ValorFueraDeRango(String msg){
        super(msg);
    }
    
    
}
