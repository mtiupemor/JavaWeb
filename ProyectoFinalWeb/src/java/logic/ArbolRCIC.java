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
 * @author IIE
 */
public class ArbolRCIC {

  dto.ArbolFallaDto arbolFalla;
  EventoDto evento1;
  EventoDto evento2;
  EventoDto evento3;
  EventoDto evento4;
  EventoDto evento5;
  EventoDto evento6;
  EventoDto evento7;

  public dto.ArbolFallaDto creaArbolFallaRCIC() {
    ArbolFallaDto arbolFalla = new ArbolFallaDto();
    EventoTopeDto et = new EventoTopeDto();
    
    et.setNombre("Falla del RCIC a inyectar");
    arbolFalla.setEventoTope(et);
    
    evento1 = new EventoDto();
    evento2 = new EventoDto();
    evento3 = new EventoDto();
    evento4 = new EventoDto();
    evento5 = new EventoDto();
    evento6 = new EventoDto();
    evento7 = new EventoDto();
    
    evento1.setId("A");
    evento1.setNombre("Falla del RCIC a iniciar o funcionar por 8 hr.");
    try {      
      evento1.setValor(.2d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento2.setId("B");    
    evento2.setNombre("Falla del RCIC durante largo plazo de operacion.");
    try {
      evento2.setValor(.1d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento3.setId("C");    
    evento3.setNombre("Falla del RCIC a iniciar.");
    try {
      evento3.setValor(.2d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento4.setId("D");    
    evento4.setNombre("RCIC indisponible por mantenimiento de prueba.");
    try {
      evento4.setValor(.1d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento5.setId("E");
    evento5.setNombre("Pérdida de DC.");
    try {
      evento5.setValor(.1d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento6.setId("F");
    evento6.setNombre("Falla del RCI durante largo plazo de operación.");
    try {
      evento6.setValor(.1d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    evento7.setId("G");
    evento7.setNombre("En condición de SBO.");
    try {
      evento7.setValor(.1d);
    } catch (ValorFueraDeRango ex) {
      Logger.getLogger(ArbolRCIC.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    et.setId("putito");
    CompuertaLogicaDto compuerta1 = new CompuertaLogicaDto("X1", CompuertaLogicaDto.TYPO.OR);
    //compuerta1.setPadre(et);
    compuerta1.setEventoHijo(evento1);
    compuerta1.setEventoHijo(evento2);
    
    CompuertaLogicaDto compuerta2 = new CompuertaLogicaDto("X2", CompuertaLogicaDto.TYPO.OR);
    evento1.setHijo(compuerta2);

    //compuerta2.setPadre(evento1);
    compuerta2.setEventoHijo(evento3);
    compuerta2.setEventoHijo(evento4);
    compuerta2.setEventoHijo(evento5);
    
    CompuertaLogicaDto compuerta3 = new CompuertaLogicaDto("X3", CompuertaLogicaDto.TYPO.AND);
    evento2.setHijo(compuerta3);
    //compuerta3.setPadre(evento2);
    compuerta3.setEventoHijo(evento6);
    compuerta3.setEventoHijo(evento7);
    
    evento1.setHijo(compuerta2);
    evento2.setHijo(compuerta3);    
    
    et.setHijo(compuerta1);

    String a="{\"cells\":[{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[],\"position\":{\"x\":713,\"y\":49},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"z\":4,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2}}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":381,\"y\":323},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"z\":5,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"arbol.CompuertaAND\",\"size\":{\"width\":48,\"height\":48},\"inPorts\":[\"\"],\"outPorts\":[\"\"],\"position\":{\"x\":774,\"y\":231},\"angle\":0,\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"z\":7,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in27\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out28\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out28\"},\"target\":{\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in\"},\"id\":\"cdc07023-089f-44e9-bda4-02fdb9642858\",\"embeds\":\"\",\"z\":8,\"attrs\":{}},{\"type\":\"link\",\"source\":{\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"76963d38-1ab7-4acb-953e-27f50f618132\",\"embeds\":\"\",\"z\":9,\"attrs\":{}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":893,\"y\":335},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"z\":11,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"3544c930-bfd5-48a7-a58f-f5d3da99bde5\",\"embeds\":\"\",\"z\":12,\"attrs\":{}}]}";    
    a+=a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a+a;
    arbolFalla.setEstructura(a);
    arbolFalla.setId("rasputin");
    arbolFalla.setNombre("putifar");
    
    InsertarArbolFalla tree2 = new InsertarArbolFalla();    
    tree2.insertar(arbolFalla);
    
    return arbolFalla;    
    
  }
  
}
