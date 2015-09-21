/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.google.gson.Gson;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lirio
 */
public class TestCompuerta {

    /**
     * @param args the command line arguments
     */
    EventoDto evento1;
    EventoDto evento2;
    EventoDto evento3;    
    EventoDto evento4;
    EventoDto evento5;
    CompuertaLogicaDto compuerta1;
    public TestCompuerta(){
        evento1=new EventoDto();
        evento2=new EventoDto();
        evento3=new EventoDto();
        evento4=new EventoDto();
        try { 
       evento1.setNombre("Falla del HPCF-B");
       evento1.setValor(0.2d);
       
       evento2.setNombre("Falla del HPCF-C");
       evento2.setValor(0.1d);
       
       evento3.setNombre("Falla de potencia en la divición 2");
       evento3.setValor(0.2d);
       
       evento4.setNombre("Falla del HPCF-B");
       evento4.setValor(0.3d);
       
    }  catch (ValorFueraDeRango ex) {
            Logger.getLogger(ArbolHPCF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       CompuertaLogicaDto compuerta2=new CompuertaLogicaDto("2",CompuertaLogicaDto.TYPO.OR);
       compuerta2.setEventoHijo(evento3);       
       
       CompuertaLogicaDto compuerta3=new CompuertaLogicaDto("3",CompuertaLogicaDto.TYPO.OR);
       compuerta3.setEventoHijo(evento4);
       
       compuerta1=new CompuertaLogicaDto("4",CompuertaLogicaDto.TYPO.AND);
       compuerta1.setEventoHijo(evento1);
       
       compuerta1.setCompuertaHijo(compuerta2);
       compuerta1.setCompuertaHijo(compuerta3);
       
       
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        TestCompuerta tc=new TestCompuerta();
        //System.out.println("el valor de compuerta es:"+tc.compuerta1.getValorCompuerta(tc.compuerta1));
        
           Gson g=new Gson();
  
    
    String jsonString = g.toJson(tc.compuerta1);
    System.out.println(jsonString);    
        
    }
    
}
