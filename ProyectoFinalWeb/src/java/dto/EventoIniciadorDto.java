/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author lirio
 */
public class EventoIniciadorDto {

  private String id = "";
  private String idarbol;
  private String nombre;
  private Double valor;

  public EventoIniciadorDto() {
    this("");
  }

  public EventoIniciadorDto(String nombre) {
    this.nombre = nombre;
  }

  public EventoIniciadorDto(String id, String nombre) {
    this.id = id;
    this.nombre = nombre;
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
   * @return the valor
   */
  public Double getValor() {
    return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(Double valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    String exit = "";
    exit = "{";
    exit += "\"id\":\"" + this.id + "\",";                            //string 
    exit += "\"nombre\":\"" + this.nombre + "\",";
    exit += "\"valor\":" + this.valor + ",";                          //decimal

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
}
