/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.google.gson.Gson;
import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.ValorFueraDeRango;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SChaves
 */
public class TestRecuperaArbol {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    /*
    ArbolFallaDto a = new ArbolFallaDto();
    CrearArbolFalla call = new CrearArbolFalla();
    ImprimeArbolFalla imp = new ImprimeArbolFalla();
    System.out.println("--------");
    //a=call.getArbolFalla("putito");  
      */
    Gson g=new Gson();
  
    CompuertaLogicaDto edto=new CompuertaLogicaDto();
    CompuertaLogicaDto edto2=new CompuertaLogicaDto();
    edto.setCompuertaHijo(edto2);
    String jsonString = g.toJson(edto);
    System.out.println(jsonString);    
    //System.out.println(edto);
    /*
    System.out.println(jsonString);
    imp.imprimeArbol(a);               
    System.out.println("--------");
            */
  }
  
}
