/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.ArbolEventoDAO;
import dao.ArbolFallaDAO;
import dao.CompuertaLogicaDAO;
import dao.EventoDao;
import dao.EventoIniciadorDAO;
import dao.EventoTopeDAO;
import dao.SistemaDAO;
import dto.ArbolEventoDto;
import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.SistemaDto;

/**
 *
 * @author SChaves
 */
public class InsertarArbolEvento {

  private String raiz;
  private boolean error;
  private String errorS;

  public boolean insertarLogico(ArbolEventoDto arbol) {
    boolean exit = false;
    //System.out.println("entra insertar arbol");
    if (arbol != null) {
      
      ArbolEventoDAO tree = new ArbolEventoDAO();
      raiz = arbol.getId();
      //System.out.println(raiz);
      
      eliminarArbolLogico(raiz);
      tree.agregaArbolEventoLogico(arbol);
      /*        
      if (!(tree.getArbolEventoLogico(raiz))) {
        eliminarArbolLogico(raiz);
      } else {
        exit = !(tree.agregaArbolEventoLogico(arbol));
      }
      */
      insertarObjeto(arbol.getSistema(),arbol.getId());
      EventoIniciadorDAO tope = new EventoIniciadorDAO();
      arbol.getEventoIniciador().setIdarbol(raiz);
      tope.agregaEventoIniciador(arbol.getEventoIniciador());
      /*
      if ((!tope.agregaEventoIniciador(arbol.getEventoIniciador()))) {
        exit = (exit == true ? true : false);
      }
              
      //tope.agregaEventoTope(arbol.getEventoTope());
      */
       exit=true;       
    }
    return exit;
  }

  /**
   * Metodo que incerta un dato tipo DatoArbol del tipo T
   *
   * @param valorInsertar dato tipo T
   */
  //insertar un nuevo nodo en el arbol de busqueda binaria
  private void insertarObjeto(SistemaDto sistema,String padre) {
    //System.out.println("entra a sistema");
    if (sistema != null) {
      System.out.println(sistema.getId());
      SistemaDAO sys = new SistemaDAO();
      sistema.setIdarbol(raiz);
      sistema.setIdpadre(padre);
      sys.agregaSistema(sistema);
      insertarObjeto(sistema.getExito(),sistema.getId());
      insertarObjeto(sistema.getFalla(),sistema.getId());      
    }
  }

  public boolean insertarGrafico(String arbol, String nombre, String estructura) {
    boolean exit = false;
    if (!(arbol.isEmpty())) {
      ArbolEventoDAO tree = new ArbolEventoDAO();
      if (tree.getArbolEvento(arbol)) {
        eliminarArbolGrafico(arbol);
        eliminarArbol(arbol);
      }
      exit = (!(tree.agregaArbolEvento(arbol, nombre)));

      if (!(tree.agregaArbolEventoGrafico(arbol, estructura))) {
        exit = (exit == true ? true : false);
      }
    }
    return exit;
  }

  private boolean eliminarArbolLogico(String a) {
    ArbolEventoDAO delAE = new ArbolEventoDAO();
    delAE.deleteArbolEventoLogico(a);
    if (!(delAE.getError())) {
      error = delAE.getError();
      errorS = delAE.getErrorS();
      return true;
    }

    SistemaDAO delSis = new SistemaDAO();
    delSis.deleteSistemas(a);
    if (!(delSis.getError())) {
      error = delSis.getError();
      errorS = delSis.getErrorS();
      return true;
    }
/*
    EventoDao delE = new EventoDao();
    delE.deleteEventos(a);
    if (!(delE.getError())) {
      error = delE.getError();
      errorS = delE.getErrorS();
      return true;
    }
*/
    
    EventoIniciadorDAO delEI = new EventoIniciadorDAO();
    delEI.deleteEventoIniciador(a);
    if (!(delEI.getError())) {
      error = delEI.getError();
      errorS = delEI.getErrorS();
      return true;
    }
    return false;
  }

  private boolean eliminarArbolGrafico(String a) {
    ArbolEventoDAO delAE = new ArbolEventoDAO();
    delAE.deleteArbolEventoGrafico(a);
    if (!(delAE.getError())) {
      error = delAE.getError();
      errorS = delAE.getErrorS();
      return true;
    }
    return false;
  }

  private boolean eliminarArbol(String a) {
    ArbolEventoDAO delAE = new ArbolEventoDAO();
    delAE.deleteArbolEvento(a);
    if (!(delAE.getError())) {
      error = delAE.getError();
      errorS = delAE.getErrorS();
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
