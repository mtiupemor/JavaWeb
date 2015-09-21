/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.ArbolFallaDto;
import org.json.JSONObject;

/**
 *
 * @author lirio
 */
public class SistemaDto {

  private String id;
  private String idarbol;
  private String idpadre;
  private String nombre;
  //private String idarbolfalla;
  private ArbolFallaDto arbolFalla;
  private double frecuencia = 0d;
  private double valorExito = 0d;
  private SistemaDto falla;
  private SistemaDto exito;
 // private int flag = 1;
  private String tmpfalla;
  private String tmpexito;
  private String tmparbol;

  /**
   * @return the nombre
   */
  public SistemaDto() {
    falla = null;
    exito = null;
    arbolFalla = null;
  }

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
   * @return the arbolFalla
   */
  public ArbolFallaDto getArbolFalla() {
    return arbolFalla;
  }

  public String getArbolFallaBIS() {
    String valor = "";
    if (arbolFalla != null) {
      valor = arbolFalla.getId();
    }
    return valor;
  }

  /**
   * @param arbolFalla the arbolFalla to set
   */
  public void setArbolFalla(ArbolFallaDto arbolFalla) {
    this.arbolFalla = arbolFalla;
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
   * @return the falla
   */
  public SistemaDto getFalla() {
    return falla;
  }

  public String getFallaBIS() {
    String valor = "";
    if (falla != null) {
      valor = falla.getId();
    }
    return valor;
  }

  /**
   * @param falla the falla to set
   */
  public void setFalla(SistemaDto falla) {
    falla.setFrecuencia(falla.getArbolFalla().getEventoTope().getValor() * this.getFrecuencia());
    falla.setValorExito((1 - falla.getArbolFalla().getEventoTope().getValor()) * this.getFrecuencia());
    this.falla = falla;
//    this.flag = 1;
    falla.setIdpadre(this.id);
  }

  /**
   * @return the exito
   */
  public SistemaDto getExito() {
    return exito;
  }

  public String getExitoBIS() {
    String valor = "";
    if (exito != null) {
      valor = exito.getId();
    }
    return valor;
  }

  /**
   * @param exito the exito to set
   */
  public void setExito(SistemaDto exito) {
    exito.setFrecuencia(exito.getArbolFalla().getEventoTope().getValor() * this.getValorExito());
    exito.setValorExito((1 - exito.getArbolFalla().getEventoTope().getValor()) * this.getValorExito());
    this.exito = exito;
//    this.flag = 0;
    exito.setIdpadre(this.id);
  }

  /**
   * @return the frecuencia
   */
  public double isFrecuencia() {
    return getFrecuencia();
  }

  /**
   * @return the valorExito
   */
  public double getValorExito() {
    return valorExito;
  }

  /**
   * @param valorExito the valorExito to set
   */
  public void setValorExito(double valorExito) {
    this.valorExito = valorExito;
  }

  /**
   * @return the frecuencia
   */
  public double getFrecuencia() {
    return frecuencia;
  }

  /**
   * @param frecuencia the frecuencia to set
   */
  public void setFrecuencia(double frecuencia) {
    this.frecuencia = frecuencia;
  }

  @Override
  public String toString() {
    String exit = "";
    exit = "{";
    exit += "\"id\":\"" + this.id + "\",";                            //string 
    exit += "\"nombre\":\"" + this.nombre + "\",";
    exit += "\"frecuencia\":" + this.frecuencia + ",";             //decimal
    exit += "\"valorExito\":" + this.valorExito + ",";             //decimal    
    exit += "\"falla\":" + this.exito + ",";
    exit += "\"exito\":" + this.exito + ",";
    exit += "\"arbolFalla\":\"" + this.arbolFalla + "\",";    //string 

    exit += "}";
    return exit;
  }

  /**
   * @return the idarbol
   */
  public String getIdarbol() {
    return idarbol;
  }

  /**
   * @param idarbol the idarbol to set
   */
  public void setIdarbol(String idarbol) {
    this.idarbol = idarbol;
  }

/* 
  public int getFlag() {
    return flag;
  }

 
  public void setFlag(int flag) {
    this.flag = flag;
  }
*/
  /**
   * @return the idpadre
   */
  public String getIdpadre() {
    return idpadre;
  }

  /**
   * @param idpadre the idpadre to set
   */
  public void setIdpadre(String idpadre) {
    this.idpadre = idpadre;
  }

  /**
   * @return the tmpfalla
   */
  public String getTmpfalla() {
    return tmpfalla;
  }

  /**
   * @param tmpfalla the tmpfalla to set
   */
  public void setTmpfalla(String tmpfalla) {
    this.tmpfalla = tmpfalla;
  }

  /**
   * @return the tmpexito
   */
  public String getTmpexito() {
    return tmpexito;
  }

  /**
   * @param tmpexito the tmpexito to set
   */
  public void setTmpexito(String tmpexito) {
    this.tmpexito = tmpexito;
  }

  /**
   * @return the tmparbol
   */
  public String getTmparbol() {
    return tmparbol;
  }

  /**
   * @param tmparbol the tmparbol to set
   */
  public void setTmparbol(String tmparbol) {
    this.tmparbol = tmparbol;
  }

  public JSONObject toJsonObject() {
    JSONObject object = new JSONObject();
    object.put("class", "SistemaDto");
    object.put("id", this.id);
    object.put("idarbol", this.idarbol);
    object.put("idPadre", this.idpadre);
    object.put("nombre", this.nombre);
    object.putOpt("arbolFalla", this.arbolFalla);
    object.put("frecuencia", this.frecuencia);
    object.put("valorExito", this.valorExito);
    object.putOpt("falla", this.falla);
    object.putOpt("exito", this.exito);
    return object;
  }

  public String toJsonObject(String cadena) {
    JSONObject object = new JSONObject();
    object.put("class", "EventoTopeDto");
    object.put("class", "SistemaDto");
    object.put("id", this.id);
    object.put("idarbol", this.idarbol);
    object.put("idPadre", this.idpadre);
    object.put("nombre", this.nombre);
    object.putOpt("arbolFalla", this.arbolFalla);
    object.put("frecuencia", this.frecuencia);
    object.put("valorExito", this.valorExito);
    object.putOpt("falla", this.falla);
    object.putOpt("exito", this.exito);

    return object.toString();
  }

}
