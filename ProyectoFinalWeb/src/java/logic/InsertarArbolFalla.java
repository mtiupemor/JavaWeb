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
  private boolean error;
  private String errorS;

  public boolean insertarLogico(ArbolFallaDto arbol) {
    boolean exit = false, exit2 = false;
    if (arbol != null) {
      ArbolFallaDAO tree = new ArbolFallaDAO();
      raiz = arbol.getId();
      eliminarArbolLogico(raiz);
      tree.agregaArbolFallaLogico(arbol);
      
      /*
      tree.getArbolFallaLogico(raiz);     
      
      if (tree.getError()) {
        exit=tree.agregaArbolFallaLogico(arbol);        
      } else {
        exit=eliminarArbolLogico(raiz);
      }
      if (!(exit)){
      */
        insertarObjeto(arbol.getEventoTope().getHijo());
        EventoTopeDAO tope = new EventoTopeDAO();
        arbol.getEventoTope().setIdarbol(raiz);
        tope.agregaEventoTope(arbol.getEventoTope());

      exit=true;
      
      //tope.agregaEventoTope(arbol.getEventoTope());
    }
    return exit;
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

  public boolean insertarGrafico(String arbol, String nombre, String estructura) {
    boolean exit = false,exit2 = false;
    if (!(arbol.isEmpty())) {
      ArbolFallaDAO tree = new ArbolFallaDAO();
      if (tree.getArbolFalla(arbol)) {
        eliminarArbolGrafico(arbol);
        eliminarArbol(arbol);
      }
      
      exit=tree.agregaArbolFalla(arbol, nombre);
      exit2=tree.agregaArbolFallaGrafico(arbol, estructura);
      /*
      exit = (!(tree.agregaArbolFalla(arbol, nombre)));

      if (!(tree.agregaArbolFallaGrafico(arbol, estructura))) {
        exit = (exit == true ? true : false);
      }
      */
      exit=!exit;
      exit2=!exit2;
      exit=exit && exit2;
    }
    //System.out.println(exit);
     
    return exit;
  }

  private boolean eliminarArbolLogico(String a) {
    ArbolFallaDAO delAF = new ArbolFallaDAO();
    delAF.deleteArbolFallaLogico(a);
    if (!(delAF.getError())) {
      error = delAF.getError();
      errorS = delAF.getErrorS();
      return true;
    }

    CompuertaLogicaDAO delCL = new CompuertaLogicaDAO();
    delCL.deleteCompuertasLogicas(a);
    if (!(delCL.getError())) {
      error = delCL.getError();
      errorS = delCL.getErrorS();
      return true;
    }

    EventoDao delE = new EventoDao();
    delE.deleteEventos(a);
    if (!(delE.getError())) {
      error = delE.getError();
      errorS = delE.getErrorS();
      return true;
    }

    EventoTopeDAO delET = new EventoTopeDAO();
    delET.deleteEventoTope(a);
    if (!(delET.getError())) {
      error = delET.getError();
      errorS = delET.getErrorS();
      return true;
    }
    return false;
  }

  private boolean eliminarArbolGrafico(String a) {
    ArbolFallaDAO delAF = new ArbolFallaDAO();
    delAF.deleteArbolFallaGrafico(a);
    if (!(delAF.getError())) {
      error = delAF.getError();
      errorS = delAF.getErrorS();
      return true;
    }
    return false;
  }

  private boolean eliminarArbol(String a) {
    ArbolFallaDAO delAF = new ArbolFallaDAO();
    delAF.deleteArbolFalla(a);
    if (!(delAF.getError())) {
      error = delAF.getError();
      errorS = delAF.getErrorS();
      return true;
    }
    return false;
  }

  /**
   * @return the error
   */
  public boolean getError() {
    return error;
  }

  /**
   * @param error the error to set
   */
  public void setError(boolean error) {
    this.error = error;
  }

  /**
   * @return the errorS
   */
  public String getErrorS() {
    return errorS;
  }

  /**
   * @param errorS the errorS to set
   */
  public void setErrorS(String errorS) {
    this.errorS = errorS;
  }

}
