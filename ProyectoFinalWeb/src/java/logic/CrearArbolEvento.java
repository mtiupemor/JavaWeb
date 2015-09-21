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
import dto.EventoIniciadorDto;
import dto.EventoTopeDto;
import dto.SistemaDto;
import java.util.Collection;

/**
 *
 * @author SChaves
 */
public class CrearArbolEvento {
 private boolean error;
  private String errorS;
  
  Collection<CompuertaLogicaDto> listaCompuertas;
  Collection<EventoDto> listaEventos;
  ArbolEventoDto evento;
  private int flag;
  private String raiz;

  public ArbolEventoDto getArbolEvento(String arbol) {
    raiz=arbol;
    evento = new ArbolEventoDto();
    ArbolEventoDAO info = new ArbolEventoDAO();
    String ini = info.getInfoArbolEvento(arbol, 1);
    String sis =info.getInfoArbolEvento(arbol, 2);

    EventoIniciadorDto eIni = new EventoIniciadorDto();
    eIni = getObjetoEventoIniciador(arbol);    
    evento.setEventoIniciador(eIni);
           
    SistemaDto s = new SistemaDto();
    s = getObjetoSistema(sis,arbol);
    evento.setSistema(s);
        
    getObjetos(s);
        
    evento.setEstructura(info.getEstructuraArbolEvento(arbol)); 
    error=info.getError();
    errorS=info.getErrorS();
    //System.out.println(evento.getEstructura());
    return evento;
  }

  private EventoIniciadorDto getObjetoEventoIniciador(String arbol) {
    EventoIniciadorDto e = new EventoIniciadorDto();
    EventoIniciadorDAO eIni = new EventoIniciadorDAO();
    e = eIni.obtenerObjetoEventoIniciador(arbol);
    //System.out.println(e);
    return e;
  }

  private SistemaDto getObjetoSistema(String id,String arbol) {
    SistemaDto s = new SistemaDto();
    SistemaDAO sys = new SistemaDAO();
    s = sys.obtenerObjetoSistema(id,arbol);
    //System.out.println(e);
    return s;
  }  
  
  private void getObjetos(SistemaDto objeto) {

    if (objeto != null) {
      if (!(objeto.getTmpfalla().isEmpty())){          
          SistemaDto s = new SistemaDto(); 
          s=getObjetoSistema(objeto.getTmpfalla(),raiz);
          objeto.setFalla(s);
      }
      if (!(objeto.getTmpexito().isEmpty())){          
          SistemaDto s = new SistemaDto(); 
          s=getObjetoSistema(objeto.getTmpfalla(),raiz);
          objeto.setExito(s);
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
