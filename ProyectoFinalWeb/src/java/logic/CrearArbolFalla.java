/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.ArbolFallaDAO;
import dao.CompuertaLogicaDAO;
import dao.EventoDao;
import dao.EventoTopeDAO;
import dto.ArbolFallaDto;
import dto.CompuertaLogicaDto;
import dto.EventoDto;
import dto.EventoTopeDto;
import dto.ValorFueraDeRango;
import java.util.Collection;

/**
 *
 * @author SChaves
 */
public class CrearArbolFalla {

 private boolean error;
  private String errorS;
  
  Collection<CompuertaLogicaDto> listaCompuertas;
  Collection<EventoDto> listaEventos;
  ArbolFallaDto falla;
  private int flag;

  public ArbolFallaDto getArbolFalla(String arbol) {    
    falla = new ArbolFallaDto();
    EventoTopeDto e = new EventoTopeDto();
    e = getObjetoEventoTope(arbol);
    falla.setEventoTope(e);        
    getObjetos(e);
    ArbolFallaDAO aDAO = new ArbolFallaDAO();
    falla.setEstructura(aDAO.getEstructuraArbolFalla(arbol)); 
    error=aDAO.getError();
    errorS=aDAO.getErrorS();
    //System.out.println(falla.getEstructura());
    return falla;
  }

  private EventoTopeDto getObjetoEventoTope(String arbol) {
    EventoTopeDto e = new EventoTopeDto();
    EventoTopeDAO eTope = new EventoTopeDAO();
    e = eTope.obtenerObjetoEventoTope(arbol);
    System.out.println(e);
    return e;
  }

  private void getObjetos(Object objeto) {

    if (objeto != null) {
      //System.out.println("Compuerta: " + compuerta.getId());
      //System.out.println("Compuerta: " + compuerta.getId());
      String id = "";
      id = getIdObject(objeto);
      //System.out.println("cmp: " + id);
      CompuertaLogicaDAO cLog = new CompuertaLogicaDAO();
      listaCompuertas = cLog.obtenerCompuertasLogicas(id);
      //System.out.println("Compuerta: " + id);
      if (listaCompuertas.size() > 0) {
        for (CompuertaLogicaDto c : listaCompuertas) {
          //System.out.println("compuerta padre: " + id + " hijo: " + c.getId());
          CompuertaLogicaDto cl = new CompuertaLogicaDto(c.getId(), c.getTipo());          
          if (objeto instanceof CompuertaLogicaDto) {
            ((CompuertaLogicaDto) objeto).setCompuertaHijo(cl);
          }
          if (objeto instanceof EventoDto) {
            ((EventoDto) objeto).setHijo(cl);
          }
          if (objeto instanceof EventoTopeDto) {
            ((EventoTopeDto) objeto).setHijo(cl);
          }
          
          System.out.println(((CompuertaLogicaDto) objeto));
          
          getObjetos(cl);
        }
      }

      EventoDao evento = new EventoDao();
      listaEventos = evento.obtenerEventos(id);
      if (listaEventos.size() > 0) {
        for (EventoDto e : listaEventos) {
          //System.out.println("evento padre: " + id + " hijo: " + e.getId());
          EventoDto ev = new EventoDto();
          ev.setId(e.getId());
          ev.setNombre(e.getNombre());
          if (objeto instanceof CompuertaLogicaDto) {
            ((CompuertaLogicaDto) objeto).setEventoHijo(ev);
          }
          //System.out.println("evento manda: " + ev.getId());
          getObjetos(ev);
        }
      }
    }
  }

  private String getIdObject(Object obj) {
    String id = "";
    //System.out.println(obj);
    if (obj instanceof CompuertaLogicaDto) {
      id = ((CompuertaLogicaDto) obj).getId();
    }
    if (obj instanceof EventoDto) {
      id = ((EventoDto) obj).getId();
    }
    if (obj instanceof EventoTopeDto) {
      id = ((EventoTopeDto) obj).getId();      
    }
    
    return id;
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
