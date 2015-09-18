/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.ArbolFallaDAO;
import dao.CompuertaLogicaDAO;
import dao.EventoDao;
import dao.EventoIniciadorDAO;
import dao.EventoTopeDAO;
import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;

/**
 *
 * @author SChaves
 */
public class InsertarArbolFalla {

  private String raiz;

  public void insertar(ArbolFallaDto arbol) {

    if (arbol != null) {
      ArbolFallaDAO tree = new ArbolFallaDAO();
      raiz = arbol.getId();
      if (tree.getArbolFalla(raiz)) {
        eliminarEstrucuraArbol(raiz);
      } else {
        tree.agregaArbol(arbol);      
      }
      tree.agregaArbolGrafico(arbol);
      tree.agregaArbolLogico(arbol);
        
      insertarObjeto(arbol.getEventoTope().getHijo());
      
      EventoTopeDAO tope = new EventoTopeDAO();      
      arbol.getEventoTope().setIdarbol(raiz);
      tope.agregaEventoTope(arbol.getEventoTope());
    }
  }

  /**
   * Metodo que incerta un dato tipo DatoArbol del tipo T
   *
   * @param valorInsertar dato tipo T
   */
  //insertar un nuevo nodo en el arbol de busqueda binaria
  private void insertarObjeto(CompuertaLogicaDto compuerta) {

    if (compuerta != null) {
      CompuertaLogicaDAO cLog = new CompuertaLogicaDAO();
      compuerta.setIdarbol(raiz);
      cLog.agregaCompuertaLogica(compuerta);
      for (CompuertaLogicaDto c : compuerta.getHijosCompuertas()) {
        insertarObjeto(c);
      }

      for (EventoDto e : compuerta.getHijosEventos()) {
        e.setIdarbol(raiz);
        insertarObjeto(e.getHijo());
        EventoDao iEvento = new EventoDao();
        iEvento.agregaEvento(e);
      }
    }
  }

  private void eliminarEstrucuraArbol(String a) {
    ArbolFallaDAO delAF = new ArbolFallaDAO();
    delAF.deleteArbolFallaGrafico(a);
    delAF.deleteArbolFallaLogico(a);
    
    CompuertaLogicaDAO delCL = new CompuertaLogicaDAO();
    delCL.deleteCompuertasLogicas(a);
    
    EventoDao delE = new EventoDao();
    delE.deleteEventos(a);
    
    EventoTopeDAO delET = new EventoTopeDAO();
    delET.deleteEventoTope(a);
  }

}
