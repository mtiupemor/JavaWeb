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
import org.json.JSONObject;
import server.logica.AnalizaObjetoJSON;

/**
 *
 * @author SChaves
 */
public class PruebaEventoDtoJson {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    //EventoDto evento=new EventoDto();
    //System.out.println(evento.toJsonObject().toString());
    //String a="{\"cells\":[{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[],\"position\":{\"x\":713,\"y\":49},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"z\":4,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2}}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":381,\"y\":323},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"z\":5,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"arbol.CompuertaAND\",\"size\":{\"width\":48,\"height\":48},\"inPorts\":[\"\"],\"outPorts\":[\"\"],\"position\":{\"x\":774,\"y\":231},\"angle\":0,\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"z\":7,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in27\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out28\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out28\"},\"target\":{\"id\":\"f8b8ac2e-2290-427b-b7b0-6322adcb201c\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in\"},\"id\":\"cdc07023-089f-44e9-bda4-02fdb9642858\",\"embeds\":\"\",\"z\":8,\"attrs\":{}},{\"type\":\"link\",\"source\":{\"id\":\"aa67c2db-98c5-4bd2-86ac-2fd3d334d29c\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"76963d38-1ab7-4acb-953e-27f50f618132\",\"embeds\":\"\",\"z\":9,\"attrs\":{}},{\"type\":\"arbol.Evento\",\"size\":{\"width\":170,\"height\":100},\"inPorts\":[\"in\"],\"outPorts\":[\"out\"],\"position\":{\"x\":893,\"y\":335},\"angle\":0,\"label\":\"I am HTML\",\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"z\":11,\"attrs\":{\".inPorts>.port0>.port-label\":{\"text\":\"in\"},\".inPorts>.port0>.port-body\":{\"port\":{\"id\":\"in\",\"type\":\"in\"}},\".inPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-dy\":2},\".outPorts>.port0>.port-label\":{\"text\":\"out\"},\".outPorts>.port0>.port-body\":{\"port\":{\"id\":\"out\",\"type\":\"out\"}},\".outPorts>.port0\":{\"ref\":\".body\",\"ref-x\":0.5,\"ref-y\":-10}}},{\"type\":\"link\",\"source\":{\"id\":\"6a00c933-5979-406e-8c08-b623c3497c94\",\"selector\":\"g:nth-child(1) g:nth-child(4) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"out\"},\"target\":{\"id\":\"12039a75-385c-462b-ad0b-8cd8444f5bfb\",\"selector\":\"g:nth-child(1) g:nth-child(3) g:nth-child(1) circle:nth-child(1)     \",\"port\":\"in27\"},\"id\":\"3544c930-bfd5-48a7-a58f-f5d3da99bde5\",\"embeds\":\"\",\"z\":12,\"attrs\":{}}]}";    
    //String a="{\"compuerta\":\"compuerta\",\"id\":\"hola\",\"nombre\":\"wey\"}";
    
    
    //String a="{\"arbol\":{\"class\":\"Compuerta\",\"id\":\"e7c78af6-a095-40db-81d3-2a3117a05069\",\"valor\":0.8,\"valEventos\":0,\"tipo\":\"OR\",\"valCompuertas\":0,\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"hijosEventos\":[{\"class\":\"Evento\",\"id\":\"e74c728e-891b-46ca-b72c-45614af16ea\",\"nombre\":\"Evento1\",\"valor\":0.6,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"},{\"class\":\"Evento\",\"id\":\"8fc7d569-5052-4c55-ab17-015735b0fef7\",\"nombre\":\"Evento1\",\"valor\":0.3,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"}],\"hijosCompuertas\":[],\"padre\":\"undefined\",\"valido\":false,\"suscriptores\":[{\"class\":\"EventoTope\",\"idarbol\":\"undefined\",\"id\":\"0b2bc19f-555e-4344-b21b-20886c66dc67\",\"nombre\":\"EventoTope\",\"valor\":0.8,\"x\":\"undefined\",\"y\":\"undefined\",\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"compuertaHijo\":\"e7c78af6-a095-40db-81d3-2a3117a05069\"}]}}";
//    String a="{\"arbol\":{\"class\":\"EventoTope\",\"idarbol\":\"undefined\",\"id\":\"4f72b404-6fec-48a0-8f6f-eb8ce5587d98\",\"nombre\":\"EventoTope\",\"valor\":0.06,\"x\":\"undefined\",\"y\":\"undefined\",\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"compuertaHijo\":{\"class\":\"Compuerta\",\"id\":\"3e1536e5-29b3-4b0d-8782-e5c4cc873dbe\",\"valor\":0.06,\"valEventos\":1,\"tipo\":\"AND\",\"valCompuertas\":0,\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"hijosEventos\":[{\"class\":\"Evento\",\"id\":\"00e3b783a915-4b15-be26-487db18da56b\",\"nombre\":\"Evento1\",\"valor\":0.2,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"},{\"class\":\"Evento\",\"id\":\"64909f53-9c7d-4458-8960-1ad5528ad481\",\"nombre\":\"Evento1\",\"valor\":0.3,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"}],\"hijosCompuertas\":[],\"padre\":\"undefined\",\"valido\":false}}}";    
    //String a="{\"arbol\":{\"class\":\"EventoTope\",\"idarbol\":\"undefined\",\"id\":\"4f72b404-6fec-48a0-8f6f-eb8ce5587d98\",\"nombre\":\"EventoTope\",\"valor\":0.06,\"x\":\"undefined\",\"y\":\"undefined\",\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"Compuerta\":{\"class\":\"Compuerta\",\"id\":\"3e1536e5-29b3-4b0d-8782-e5c4cc873dbe\",\"valor\":0.06,\"valEventos\":1,\"tipo\":\"AND\",\"valCompuertas\":0,\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"EventoDto\":[{\"class\":\"Evento\",\"id\":\"00e3b783a915-4b15-be26-487db18da56b\",\"nombre\":\"Evento1\",\"valor\":0.2,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"},{\"class\":\"Evento\",\"id\":\"64909f53-9c7d-4458-8960-1ad5528ad481\",\"nombre\":\"Evento1\",\"valor\":0.3,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"}],\"hijosCompuertas\":[],\"padre\":\"undefined\",\"valido\":false}}}";    
    String a="{\"arbol\":{\"class\":\"EventoTope\",\"idarbol\":\"undefined\",\"id\":\"4f72b404-6fec-48a0-8f6f-eb8ce5587d98\",\"nombre\":\"EventoTope\",\"valor\":0.06,\"x\":\"undefined\",\"y\":\"undefined\",\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"Compuerta\":{\"class\":\"Compuerta\",\"id\":\"3e1536e5-29b3-4b0d-8782-e5c4cc873dbe\",\"valor\":0.06,\"valEventos\":1,\"tipo\":\"AND\",\"valCompuertas\":0,\"modelId\":\"undefined\",\"portIn\":\"undefined\",\"EventoDto\":[{\"class\":\"EventoDto\",\"id\":\"00e3b783a915-4b15-be26-487db18da56b\",\"nombre\":\"Evento1\",\"valor\":0.2,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"},{\"class\":\"EventoDto\",\"id\":\"64909f53-9c7d-4458-8960-1ad5528ad481\",\"nombre\":\"Evento1\",\"valor\":0.3,\"editable\":\"true\",\"idNomenclatura\":\"undefined\"}],\"hijosCompuertas\":[],\"padre\":\"undefined\",\"valido\":false}}}";        
    //System.out.println(a);
    JSONObject x = new JSONObject(a);
    //System.out.println(x);
    
    AnalizaObjetoJSON abj = new AnalizaObjetoJSON();
    ArbolFallaDto arbol = new ArbolFallaDto();
    EventoTopeDto e = new EventoTopeDto();
    abj.analizaJSON(e, x ,"arbol");
    arbol.setEventoTope(e);
    arbol.setId("tree11");
    
    System.out.println("****************** Imprime el pinche arbol");
    ImprimeArbolFalla falla = new ImprimeArbolFalla();
    falla.imprimeArbol(arbol);
    
    System.out.println("****************** Inserta a BD el pinche arbol");
    
//    InsertarArbolFalla af = new InsertarArbolFalla();
//    af.insertarLogico(arbol);
    
    
    
    //System.out.println(x);
    //CompuertaLogicaDto cl = new CompuertaLogicaDto();
    //CompuertaLogicaDto c = new CompuertaLogicaDto();    
    //c=cl.getObjectFromJSON(x);
    
  }
  
 
}
