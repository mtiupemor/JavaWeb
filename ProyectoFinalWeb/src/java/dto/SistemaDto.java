/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.ArbolFallaDto;

/**
 *
 * @author lirio
 */
public class SistemaDto {
    private String id;
    private String idarbol;
    private String nombre;
    private String idarbolfalla;
    private ArbolFallaDto arbolFalla;
    private double frecuencia=0d;
    private double valorExito=0d;
    private SistemaDto falla;
    private SistemaDto exito;
    private int flag=1; //Bandera 1 es falla, 0 es exito;
    /**
     * @return the nombre
     */
    public SistemaDto(){
        
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
  public void setidarbolfalla(String idarbolfalla) {
    this.idarbolfalla = idarbolfalla;
  }

    /**
     * @return the falla
     */
    public SistemaDto getFalla() {
        return falla;
    }

    /**
     * @param falla the falla to set
     */
    public void setFalla(SistemaDto falla) {
        falla.setFrecuencia(falla.getArbolFalla().getEventoTope().getValor()*this.getFrecuencia());
        falla.setValorExito((1-falla.getArbolFalla().getEventoTope().getValor())*this.getFrecuencia());
        this.falla = falla;
        this.flag=1;
    }

    /**
     * @return the exito
     */
    public SistemaDto getExito() {
        return exito;
    }

    /**
     * @param exito the exito to set
     */
    public void setExito(SistemaDto exito) {
        exito.setFrecuencia(exito.getArbolFalla().getEventoTope().getValor() * this.getValorExito());
        exito.setValorExito((1-exito.getArbolFalla().getEventoTope().getValor())*this.getValorExito());
        this.exito = exito;
        this.flag=0;
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
    String exit="";
    exit="{";
    exit+="\"id\":\"" + this.id + "\",";                            //string 
    exit+="\"nombre\":\"" + this.nombre + "\",";    
    exit+="\"frecuencia\":" + this.frecuencia + ",";             //decimal
    exit+="\"valorExito\":" + this.valorExito + ",";             //decimal    
    exit+="\"falla\":" + this.exito + ",";                     
    exit+="\"exito\":" + this.exito + ",";                        
    exit+="\"arbolFalla\":\"" + this.arbolFalla + "\",";    //string 

    exit+="}";   
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
