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
/*
ARBOL.Evento = function (id,name) { 
    this.name = name;    
    this.valor=0;
    this.tipo;
    this.ancho=150; //propiedades del objeto grafico
    this.alto=80; //propiedades del objeto grafico
    this.habilitar=false;
};

ARBOL.Evento.prototype.setLinkPadre=function(link)
{
   if( link instanceof ARBOL.Link){ 
       this.linkPadre=link;
   }
};

ARBOL.Evento.prototype.setLinkHijo=function(link)
{
   if(link instanceof ARBOL.Link){ 
       this.linkHijo=link;
   
   }
};
*/
public class EventoDto extends Observable implements Observer{
    private String idarbol; 
    private String id;
    private String nombre;
    private Double valor=0.0d;
    private CompuertaLogicaDto hijo;
    private CompuertaLogicaDto padre;
    private boolean editable = true;
    
    private String idNomenclatura;
    
    private static int i=0;
    private static String patron="";   
    
    /*Constructor de la clase*/
    public  EventoDto()
    {
        this.idNomenclatura=createIdNomenclatura();
        this.id="";
    }
    
    public String createIdNomenclatura()
    { 
     String ids[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};    
     String id="";
     if(i<ids.length)
     {
         id= patron+ids[i]; 
     }else
        {
           i=0;
           patron+=ids[i];
           id= patron+ids[i];
        }
     i++;
     return id; 
    }

/**
     * @return the idNomenclatura
     */
    public String getIdNomenclatura() {
        return idNomenclatura;
    }

    /**
     * @param idNomenclatura the idNomenclatura to set
     */
    public void setIdNomenclatura(String idNomenclatura) {
        this.idNomenclatura = idNomenclatura;
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
    public void setValor(Double valor) throws ValorFueraDeRango {
        
        if (valor <=0.0d || valor >1.0d){
            throw new ValorFueraDeRango("El valor no debe ser <=0 y >1");            
        }else{
            this.valor = valor;
             this.setChanged();
             this.notifyObservers(this);
        }
        
    }

    /**
     * @return the hijo
     */
    public CompuertaLogicaDto getHijo() {     
        return hijo;
    }

    public String getHijoBIS() {     
        String hijoBIS="";
        if (hijo != null){
          hijoBIS=hijo.getId();
        }
        return hijoBIS;
    }    
    
    public String getPadreBIS() {     
        String padreBIS="";
        if (padre != null){
          padreBIS=padre.getId();
        }
        return padreBIS;
    }        
    /**
     * @param hijo the hijo to set
     */
    public void setHijo(CompuertaLogicaDto hijo) {
        hijo.addObserver(this);
        this.hijo = hijo;
        //this.hijo.setPadre(this);
    }

    /**
     * @return the padre
     */
    public CompuertaLogicaDto getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(CompuertaLogicaDto padre) {
        this.addObserver(padre);
       // this.padre = padre;
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

    @Override
    public void update(Observable o, Object arg) {
        
        if(o instanceof CompuertaLogicaDto){
         System.out.println("escuchando a compuerta"+((CompuertaLogicaDto)o).getId());
         this.valor=((CompuertaLogicaDto)o).getValor();
         this.setChanged();
         this.notifyObservers();
        }
        
    }

  /**
   * @return the editable
   */
  public boolean isEditable() {
    return editable;
  }

  /**
   * @param editable the editable to set
   */
  public void setEditable(boolean editable) {
    this.editable = editable;
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
  
 public JSONObject toJsonObject(){
    JSONObject object=new JSONObject();
    object.put("class","Evento");
    object.put("id",this.id);
    object.put("nombre",this.nombre);
    object.put("valor",this.valor);
    object.put("i",this.id);
    object.put("editable",this.editable);
    object.put("idNomenclatura",this.idNomenclatura);
    if(this.hijo!=null)
    object.putOpt("hijo", this.hijo.toJsonObject());
    object.put("hijo", "null");
    //object.putOpt("padre",this.padre.toJsonObject());
    return object;
  }
  
  public String toJsonObject(String cadena){
    JSONObject object=new JSONObject();
    object.put("class","Evento");
    object.put("id",this.id);
    object.put("nombre",this.nombre);
    object.put("valor",this.valor);
    object.put("i",this.id);
    object.put("editable",this.editable);
    object.put("idNomenclatura",this.idNomenclatura);
    object.putOpt("hijo", this.hijo.toJsonObject(""));
    object.putOpt("padre",this.padre.toJsonObject(""));
    return object.toString();
  }   
  
  
  
}
