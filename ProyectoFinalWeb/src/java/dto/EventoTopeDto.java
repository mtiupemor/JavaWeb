/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/**
 *
 * @author IIE
 */
public class EventoTopeDto implements Observer{
    private String id;
    private String idarbol;
    private String nombre;
    private double valor= 0d;    
    private CompuertaLogicaDto hijo;
    
    public EventoTopeDto(){
    this.id=null;
    this.nombre=null;
    this.valor=0d;
    }
    
    public  EventoTopeDto(String id,String nombre){
        this.id=id;
        this.nombre =nombre;
        this.valor = 0d;        
    }
    
    public double getValor(){
    return this.valor;//=getHijo().getValor();
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
     * @return the hijo
     */
    public CompuertaLogicaDto getHijo() {
        return hijo;
    }
    /**
     * @param hijo the hijo to set
     */
    public void setHijo(CompuertaLogicaDto hijo) {
        hijo.addObserver(this);
        this.hijo = hijo;
    }

    @Override
    public void update(Observable o, Object arg) {
       if((o instanceof CompuertaLogicaDto) && (o == this.hijo))
       {
         this.setValor(((CompuertaLogicaDto)o).getValor());
       }
    }

  /**
   * @param valor the valor to set
   */
  public void setValor(double valor) {
    this.valor = valor;
  }
  /*
  @Override
  public String toString() {    
    String exit="";
    exit="{";
    exit+="\"id\":\"" + this.id + "\",";                            //string 
    exit+="\"nombre\":\"" + this.nombre + "\",";
    exit+="\"valor\":" + this.valor + ",";                          //decimal
    exit+="\"hijo\":" + this.hijo + "";                        //clase
    
    exit+="}";   
    return exit;            
  }*/

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
  
   public JSONObject toJsonObject(){
    JSONObject object=new JSONObject();
    object.put("class","EventoTope");
    object.put("id",this.id);
    object.put("idArbol",this.idarbol);
    object.put("bombre",this.nombre);
    object.put("valor",this.valor);
    object.putOpt("hijo",this.hijo.toJsonObject());
    return object;
  }
  
  public String toJsonObject(String cadena){
      JSONObject object=new JSONObject();
    object.put("class","EventoTope");
    object.put("id",this.id);
    object.put("idArbol",this.idarbol);
    object.put("bombre",this.nombre);
    object.put("valor",this.valor);
    object.putOpt("hijo",this.hijo.toJsonObject(""));
    return object.toString();
  }       
    
}
