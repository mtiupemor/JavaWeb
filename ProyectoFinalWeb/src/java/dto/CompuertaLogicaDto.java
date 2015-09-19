/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author IIE
 */
public class CompuertaLogicaDto extends Observable implements Observer {

  private String idarbol;
  private String id;
  private double valor;
  private ArrayList<EventoDto> hijosEventos;
  private ArrayList<CompuertaLogicaDto> hijosCompuertas;
  private TYPO tipo;
//    private CompuertaLogicaDto compuerta;
  private Object padre;

  public CompuertaLogicaDto() {
    this.id = id;
    hijosEventos = new ArrayList();
    hijosCompuertas = new ArrayList();
    this.tipo = tipo;
  }

  /**
   * @return the valEventos
   */
  public Double getValEventos() {
    return valEventos;
  }

  /**
   * @param valEventos the valEventos to set
   */
  public void setValEventos(Double valEventos) {
    this.valEventos = valEventos;
  }

  /**
   * @return the valCompuertas
   */
  public Double getValCompuertas() {
    return valCompuertas;
  }

  /**
   * @param valCompuertas the valCompuertas to set
   */
  public void setValCompuertas(Double valCompuertas) {
    this.valCompuertas = valCompuertas;
  }

  public void setTipo(String tipo) {
    if (tipo == "AND") {
      this.tipo = CompuertaLogicaDto.TYPO.AND;
    }
    if (tipo == "OR") {
      this.tipo = CompuertaLogicaDto.TYPO.OR;
    }
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

  public static enum TYPO {

    AND, OR
  };
  private Double valEventos = 0.0d;
  private Double valCompuertas = 0.0d;
  //EventoIniciadorDto eventoIniciador;

  public CompuertaLogicaDto(String id, CompuertaLogicaDto.TYPO tipo) {
    this.id = id;
    hijosEventos = new ArrayList();
    hijosCompuertas = new ArrayList();
    this.tipo = tipo;
    switch (this.getTipotoString()) {
      case "AND":
        this.valor = 1.0d;
        this.valEventos = 1.0d;
        this.valCompuertas = 0.0d;
        break;
      case "OR":
        this.valor = 0.0d;
        this.valEventos = 0.0d;
        this.valCompuertas = 0.0d;
        break;
    }
  }

  public int getSizeHijosEventos() {
    return hijosEventos.size();
  }

  public int getSizeHijosCompuertas() {
    return hijosCompuertas.size();
  }

  /*
   ARBOL.Compuerta.prototype.setPadre=function(padre){
   if(padre instanceof ARBOL.EventoIniciador){
   this.Padre=padre;
   padre.setHijo(this);   
   ARBOL.eventoIniciador.CL=this;
   $(this).bind("OnSetCLHijo",padre.OnSetCLHijo);
   console.log("agregando padre de compuerta");
   console.log(padre.CL);
   //evento.addEventListener("addCLHijo", function(e) {
   //console.info("Event is: ", e);
   //console.log(e);
   //});
   }
   else if(padre instanceof ARBOL.Compuerta){
   this.Padre=padre;
            
   }
   };
   */
  /**
   * @param padre the padre to set
   */
  public void setPadre(EventoTopeDto padre) {
    this.addObserver(padre);
    this.padre = padre;
  }

  public void setPadre(CompuertaLogicaDto padre) {
    this.padre = padre;
  }

  public void setPadre(EventoDto padre) {
    this.addObserver(padre);
    this.padre = padre;

  }
  /*
   ARBOL.Compuerta.prototype.setHijo=function(hijo){    
   if(hijo instanceof ARBOL.Evento){
   this.hijosEventos.push(hijo);
   this.valor+=hijo.getValue();
   if(this.Padre instanceof ARBOL.EventoIniciador){                
   console.log("desencadenando evento para actualizar el arbol OnSetCLHijo");
   console.log(hijo);                
   var event1 = jQuery.Event("OnSetCLHijo",hijo);
   $(this).trigger(event1);  
   console.log("agregando evento a compuerta");
                  
                 
   }          
            
   }else if (hijo instanceof ARBOL.Compuerta){
   if(this.Compuerta=="undefined"){
   this.Compuerta=hijo;
   }
   else{
   hijo.Compuerta=this.Compuerta;  
   this.Copuerta=hijo;
   }
   }    
   };
   */

  public void setEventoHijo(EventoDto evento) {
    evento.addObserver(this);
    switch (this.getTipotoString()) {
      case "AND":
        this.valor *= evento.getValor();
        break;
      case "OR":
        this.valor += evento.getValor();
        break;
    }
    hijosEventos.add(evento);
    //evento.setPadre(this);
  }

  public void setCompuertaHijo(CompuertaLogicaDto CL) {
    double valCompuerta = getValorCompuerta(CL);
    switch (this.getTipotoString()) {
      case "AND":
        this.valor *= valCompuerta;
        break;
      case "OR":
        this.valor += valCompuerta;
        break;
    }
    hijosCompuertas.add(CL);
    // CL.setPadre(this);
  }
  /*
   ARBOL.Compuerta.prototype.OnUpdateCLPadre=function(event){
    
   };
   */

  public void OnUpdateCLPadre() {

  }

  /**
   * @return the hijosEventos
   */
  public ArrayList<EventoDto> getHijosEventos() {
    return hijosEventos;
  }

  /**
   * @return the hijosCompuertas
   */
  public ArrayList<CompuertaLogicaDto> getHijosCompuertas() {
    return hijosCompuertas;
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
   * @return the valor
   */
  public double getValor() {
    return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(double valor) {
    this.valor = valor;
  }

  /**
   * @return the type
   */
  public TYPO getTipo() {
    return this.tipo;
  }

  /**
   * @param tipo
   */
  public void setType(CompuertaLogicaDto.TYPO tipo) {
    this.tipo = tipo;
  }

  /**
   * @return the compuerta
   */
  /*
   public CompuertaLogicaDto getCompuerta() {
   return compuerta;
   }
   */
  /**
   * @param compuerta the compuerta to set
   */
  /*
   public void setCompuerta(CompuertaLogicaDto compuerta) {
   compuerta.addObserver(this);
   this.compuerta = compuerta;
   }
   */
  /**
   * @return the padre
   */
  public Object getPadre() {
    return padre;
  }

  public String getTipotoString() {
    String typo = "";
    if (this.tipo == CompuertaLogicaDto.TYPO.AND) {
      return "AND";
    }
    if (this.tipo == CompuertaLogicaDto.TYPO.OR) {
      return "OR";
    }

    return typo;
  }

  @Override
  public void update(Observable o, Object arg) {
    Double valorEventos = 0.0d;
    Double valorCompuerta = 0.0d;
    if (o instanceof EventoDto && hijosEventos.contains(o)) {
      //System.out.println("actualizando los valores de compuerta por Evento: " + this.getId() + ((EventoDto) o).getNombre() + " " + ((EventoDto) o).getValor());
      //recorrer recorrer la lista de eventos y actualizarla        
      switch (this.getTipotoString()) {
        case "AND":
          valorEventos = implementEventosAND(this.getHijosEventos());
          break;
        case "OR":
          valorEventos = implementEventosOR(this.getHijosEventos());
          break;

      }
      if (this.getHijosCompuertas().size() == 0) {
        this.valor = valorEventos;
      }

    } else if (o instanceof CompuertaLogicaDto && this.hijosCompuertas.contains(o)) {
      //recorrer la lista de compuertas para actualizar su valor
      //System.out.println("actualizando los valores de compuerta por Compuerta: " + ((EventoDto) o).getNombre() + " " + ((EventoDto) o).getValor());
      valorEventos = implementEventosAND(this.getHijosEventos());
      valorCompuerta = ((CompuertaLogicaDto) o).getValor();
      switch (this.getTipotoString()) {
        case "AND":
          this.valor = valorEventos * valorCompuerta;
          break;
        case "OR":
          this.valor = valorEventos + valorCompuerta;
          break;
      }

    }
    this.setChanged();
    this.notifyObservers();
  }

  public Double implementEventosAND(ArrayList<EventoDto> eventos) {
    Double valor = 1.0d;
    for (EventoDto eventoDto : eventos) {
      valor *= eventoDto.getValor();
    }
    return valor;
  }

  public Double implementEventosOR(ArrayList<EventoDto> eventos) {
    Double valor = 0.0d;
    for (EventoDto eventoDto : eventos) {
      valor += eventoDto.getValor();
    }
    return valor;
  }

  public Double getValorCompuerta(CompuertaLogicaDto compuerta) {
    //this.setValEventos(valEventos);=0.0d;
    //Double valCompuerta=0.0d;
    //Double valor=0.0d;
    switch (compuerta.getTipotoString()) {
      case "AND":
        compuerta.setValor(getValEventosAND(compuerta.getHijosEventos()));
        //compuerta.setValEventos(compuerta.getValor());
        break;
      case "OR":
        compuerta.setValor(getValEventosOR(compuerta.getHijosEventos()));
        //compuerta.setValEventos(compuerta.getValor());
        break;
    }
    //System.out.println("el id de compuerta: " + compuerta.getId() + " valor Hijos Eventos: " + compuerta.getValEventos());
    if (compuerta.getHijosCompuertas().size() > 0) {
      int x = 0;
      for (CompuertaLogicaDto compuertaAux : compuerta.getHijosCompuertas()) {
        x++;
        //System.out.println("Alogo x: " + x);
        compuertaAux.setValor(getValorCompuerta(compuertaAux));
        switch (compuerta.getTipotoString()) {
          case "AND":
            compuerta.setValor(compuerta.getValor() * compuertaAux.getValor());
            break;
          case "OR":
            compuerta.setValor(compuerta.getValor() + compuertaAux.getValor());
            break;
        }
        //System.out.println("En el For la compuerta: " + compuerta.getId() + " valor: " + compuerta.getValor() + "Val compuerta:");
      }
    } /*else {          
     switch (compuerta.getTipotoString()) {
     case "AND":
     compuerta.setValor(compuerta.getValor()*compuerta.getValEventos());          
     break;
     case "OR":                    
     compuerta.setValor(compuerta.getValor()+compuerta.getValCompuertas());            
     break;
     }
     }*/

    //System.out.println("el valor de la compuerta " + compuerta.getId() + " : " + compuerta.getValor());
    return compuerta.getValor();
  }

  public Double getValEventosAND(ArrayList<EventoDto> eventos) {
    Double valor = 1.0d;
    //iterar los eventos
    for (EventoDto eventoDto : eventos) {
      valor *= eventoDto.getValor();
    }
    return valor;
  }

  public Double getValEventosOR(ArrayList<EventoDto> eventos) {
    Double valor = 0.0d;
    //iterar los eventos
    for (EventoDto eventoDto : eventos) {
      valor += eventoDto.getValor();
    }
    return valor;
  }

  @Override
  public String toString() {
    String exit = "";
    exit = "{";
    exit += "\"id\":\"" + this.id + "\",";                            //string 
    exit += "\"valor\":" + this.valor + ",";                          //decimal
    exit += "\"valEventos\":" + this.valEventos + ",";                          //decimal
    exit += "\"valCompuertas\":" + this.valCompuertas + ",";         //decimal        
    exit += "\"padre\":" + this.padre + ",";                              //decimal
    exit += "\"tipo\":" + this.tipo + ",";                         //booleano
    exit += "\"hijosEventos\":" + this.hijosEventos + ",";      //clase
    exit += "\"hijosCompuertas\":" + this.hijosCompuertas + "";      //clase

    exit += "}";
    return exit;
  }

  public JSONObject toJsonObject() {
    JSONObject object = new JSONObject();
    JSONArray arrayHijoEventos=new JSONArray() ;
    object.put("class", "Compuerta");
    object.put("idArbol", this.idarbol);
    object.put("id", this.id);
    object.put("valor", this.valor);
    for(EventoDto e :this.hijosEventos){
      arrayHijoEventos.put(e.toJsonObject());
    }
    object.putOpt("hijosEventos",arrayHijoEventos );
    //object.put("hijosCompuertas", this.hijosCompuertas);
    //object.put(this.hijosEventos);
    //object.put(this.hijosCompuertas); 

    return object;
  }

  public String toJsonObject(String cadena) {
    JSONObject object = new JSONObject();
    JSONArray arrayHijoEventos=new JSONArray() ;
    object.put("class", "Compuerta");
    object.put("idArbol", this.idarbol);
    object.put("id", this.id);
    object.put("valor", this.valor);
    
    object.putOpt("hijosEventos", arrayHijoEventos);
    //object.put("hijosCompuertas", this.hijosCompuertas);
    return object.toString();
  }

  public CompuertaLogicaDto getObjectFromJSON(JSONObject objeto) {
    CompuertaLogicaDto cl = new CompuertaLogicaDto();
                   
    JSONArray obj=objeto.getJSONArray("id");    
    Iterator i = obj.iterator();            
    while(i.hasNext()){
      //cl.setId(o.getString("id"));
      JSONObject o =(JSONObject)i.next();
      System.out.println(o.getString("id"));
      System.out.println(o.getString("nombre"));
    }           
    return cl;
  }

}
