/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.EventoIniciadorDto;
import org.json.JSONObject;

/**
 *
 * @author lirio
 */
public class ArbolFallaDto {

  private String id;
  private String nombre;
  private String estructura;
  private EventoTopeDto eventoTope;
  private Double FallaDeSistema;

  public ArbolFallaDto() {
    this("");

  }

  public ArbolFallaDto(String nombre) {
    this.nombre = nombre;
    this.id = nombre;
  }

  public String toString() {
    return this.getNombre();
  }

  /**
   * @return the eventoIniciador
   */
  public EventoTopeDto getEventoTope() {
    return this.eventoTope;
  }

  /**
   * @param eventoIniciador the eventoIniciador to set
   */
  public void setEventoTope(EventoTopeDto eventoTope) {
    this.eventoTope = eventoTope;

  }

  /**
   * @return the nombre
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * @param nombre the nombre to set
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * @return the FallaDeSistema
   */
  public Double getFallaDeSistema() {
    return FallaDeSistema = eventoTope.getValor();
  }

  /**
   * @param FallaDeSistema the FallaDeSistema to set
   */
  public void setFallaDeSistema(Double FallaDeSistema) {
    this.FallaDeSistema = FallaDeSistema;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the estructura
   */
  public String getEstructura() {
    return estructura;
  }

  /**
   * @param estructura the estructura to set
   */
  public void setEstructura(String estructura) {
    this.estructura = estructura;
  }

public JSONObject toJsonObject(){
    JSONObject object=new JSONObject();
    object.put("class","ArbolFalla");
    object.put("id",this.id);
    object.put("nombre",this.nombre);
    object.put("estructura",this.estructura);
    object.putOpt("eventoTope",this.eventoTope);
    object.put("fallaSistema",this.FallaDeSistema);

    return object;
  }
  
  public String toJsonObject(String cadena){
    JSONObject object=new JSONObject();
    object.put("class","ArbolFalla");
    object.put("id",this.id);
    object.put("nombre",this.nombre);
    object.put("estructura",this.estructura);
    object.putOpt("eventoTope",this.eventoTope);
    object.put("fallaSistema",this.FallaDeSistema);
    
    return object.toString();
  }   
  
}
