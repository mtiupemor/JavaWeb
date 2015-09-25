/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var ARBOL = ARBOL || {};
ARBOL.eventoTope;
//#definicion de EventoTope
    
ARBOL.Falla=function(){
    this.nombre;
    this.valor;
};

ARBOL.EventoTope = function (id,nombre) 
{ 
    this.id=id;
    this.nombre = nombre;
    this.valor=0;
    this.tipo="EventoTope";    
    this.x;
    this.y;
    this.modelId;
    this.portIn;
    this.compuertaHijo;
};

ARBOL.EventoTope.prototype.hasHijo=function(hijo){
    if(hijo instanceof ARBOL.Compuerta){ 
       return hijo===this.compuertaHijo;   
    }
    return false;        
};

ARBOL.EventoTope.prototype.getValor=function(){
    return  this.valor;    
};

ARBOL.EventoTope.prototype.Update=function(compuerta)
{
    console.log("procesando la solicitud de compuerta"+compuerta.getTipo());
    this.valor=compuerta.getValorCompuerta(compuerta);
    //this.valor=this.compuertaHijo.getValor();    
    console.log("Actualizando valor evento Tope"+this.valor);
};

ARBOL.EventoTope.prototype.setValor=function(valor){
    this.valor=valor;    
};
ARBOL.EventoTope.prototype.setHijo=function(compuerta){
    if(compuerta instanceof ARBOL.Compuerta){
    this.compuertaHijo=compuerta;    
    this.compuertaHijo.suscribir(this);
    this.valor=this.compuertaHijo.getValor();
    }
    else
        console.log("no es valido el objeto de espera un objeto ARBOL.Compuerta");    
};

ARBOL.EventoTope.prototype.getHijo=function(){
    return this.compuertaHijo;
};
    
    
ARBOL.EventoTope.prototype.OnUpdateValArbol=function(event)
{
    /*this.val=event.val;
    console.info("actualizando valor de arbol");
    console.info(this);
    */
    
    
};

ARBOL.EventoTope.prototype.OnSetCLHijo=function(event)
{
    console.log("aqui dentro Evento Iniciador");
    ARBOL.EventoTope.val=ARBOL.EventoTope.CL.val;    
    console.log(this.val);
};


ARBOL.EventoTope.prototype.toJSON=function(){
    var object;
    if(typeof this.compuertaHijo != 'undefined')
        object='{"class":"EventoTope","idarbol":"'+this.idarbol+'","id":"'+this.id+'","nombre":"'+this.nombre+'","valor":'+this.valor+',"x":"'+this.x+'","y":"'+this.y+'","modelId":"'+this.modelID+'","portIn":"'+this.portIn+'","compuertaHijo":'+this.compuertaHijo.toJSON()+'}';        
    else
        object='{"class":"EventoTope","idarbol":"'+this.idarbol+'","id":"'+this.id+'","nombre":"'+this.nombre+'","valor":'+this.valor+',"x":"'+this.x+'","y":"'+this.y+'","modelId":"'+this.modelID+'","portIn":"'+this.portIn+'","compuertaHijo":"undefined"}';                  
                              
        
    return object;
}

//#fin de definicion de Evento Iniciador

//#definicion del link
ARBOL.Link = function (x,y,length) {
    this.x=x;
    this.y=y;
    this.length=length;        
};
//#fin de la definicion del link

//#definicion de la compuerta
ARBOL.Compuerta = function (id,tipo) {
    this.idarbol;
    this.id=id;    
    this.valor=0;
    this.valEventos;
    this.valCompuertas;
    this.hijosEventos=new Array();
    this.hijosCompuertas=new Array();    
    this.padre;
    this.tipo;
    this.valido=false;
    //$(this).on('changeValueEvent',this.UpdateValue);
    this.suscriptores = new Array();           
    switch (tipo) {
      case "AND":
        this.valor = 1.0;
        this.valEventos = 1.0;
        this.valCompuertas = 0.0;
        this.tipo=tipo;
        break;
      case "OR":
        this.valor = 0.0;
        this.valEventos = 0.0;
        this.valCompuertas = 0.0;
        this.tipo=tipo;
        break;
    }
this.suscriptores = new Array();
};

ARBOL.Compuerta.prototype.hasHijoEvento=function(hijoEvento){
    if(this.hijosEventos.length==0){
        return false
    }else{
          for(var evento in this.hijosEventos) {
                if(hijoEvento.id==this.hijosEventos[evento].id)
                    return true;
             }
         }
         return false;
};

ARBOL.Compuerta.prototype.suscribir=function(objeto){
    this.suscriptores.push(objeto);
};

ARBOL.Compuerta.prototype.Update=function(event)
{   
        console.log("procesando el evento:"+event.getNombre());
        this.valor=this.getValorCompuerta(this);

    /*else if(event instanceof ARBOL.Compuerta)
    {
        console.log("procesando actualizacion de compuerta "+event.type);
        this.valor=this.getValorCompuerta(this);
    }*/
        
    for(var x=0,l = this.suscriptores.length;x<l;x++){
           this.suscriptores[x].Update(this);
    }
    console.log(this.toJSON());
};




ARBOL.Compuerta.prototype.getId=function(){
    return this.id;
};

ARBOL.Compuerta.prototype.setValor=function(valor){
    this.valor=valor;
};

ARBOL.Compuerta.prototype.getValor=function(){
    return this.valor;
};


ARBOL.Compuerta.prototype.suscribir=function(objeto){
    this.suscriptores.push(objeto);
};

ARBOL.Compuerta.prototype.setTipo=function(tipo)
{
   if(tipo=="OR" || tipo=="AND" || tipo=="OREX" || tipo=="ANDPRI")
   { 
      this.tipo=tipo;
   }
};

ARBOL.Compuerta.prototype.getTipo=function()
{
       return this.tipo;
};

ARBOL.Compuerta.prototype.setId=function()
{
       return this.id;
};


ARBOL.Compuerta.prototype.setPadre=function(padre){
    /* if(padre instanceof ARBOL.EventoTope){
        this.Padre=padre;
        padre.setHijo(this);   
        ARBOL.EventoTope.CL=this;
        $(this).bind("OnSetCLHijo",padre.OnSetCLHijo);
        console.log("agregando padre de compuerta");
        console.log(padre.CL);
        //evento.addEventListener("addCLHijo", function(e) {
	    //console.info("Event is: ", e);
        //console.log(e);
        //});
        }
        else if(padre instanceof ARBOL.Compuerta)
        {
            this.Padre=padre;
        }
        */
};

ARBOL.Compuerta.prototype.getHijosEventos=function(){
    return this.hijosEventos;
}

ARBOL.Compuerta.prototype.getHijosCompuertas=function(){
    return this.hijosCompuertas;
}
        
ARBOL.Compuerta.prototype.setHijoEvento=function(evento){    
        if(evento instanceof ARBOL.Evento){
            this.hijosEventos.push(evento);            
            switch (this.tipo) {
              case "AND":
                this.valor *= evento.getValor();
                break;
              case "OR":
                this.valor += evento.getValor();
                break;
            }
            evento.suscribir(this);
            //this.pubsub.subscribe('Evento.data', this, UpdateValue);
            //this.pubsub.publish( 'invoice.data', [ data ] );
            //ARBOL.Event.subscribe(evento);
            console.log("sucribiendo a compuerta");
            
                      
          }          
};

ARBOL.Compuerta.prototype.setHijoCompuerta=function(compuerta){    
        if(compuerta instanceof ARBOL.Compuerta){
            this.hijosCompuertas.push(compuerta); 
            compuerta.suscribir(this);
          }
};

ARBOL.Compuerta.prototype.isValido=function(){
    if(this.hijosEventos.length>0&&this.hijosCompuertas.length>0){
                this.valido=true;                
            }else if(this.hijosEventos.length>1||this.hijosCompuertas.length>1)
                {
                    this.valido=true;
                }else{
                    this.valido=false;                    
                }  
    return this.valido;    
};

ARBOL.Compuerta.prototype.getValEventosAND=function(arrayEventos) {
    var valor = 1.0;
    //iterar los eventos
    var eventoTemp=new ARBOL.Evento();    
    for (var evento in arrayEventos) {        
       valor *= arrayEventos[evento].getValor();
       console.log(evento);
    }
    return valor;
  }

  ARBOL.Compuerta.prototype.getValEventosOR=function(arrayEventos) {
        var valor = 0.0;
    //iterar los eventos      
    try{
        for (var evento in arrayEventos) {
         valor +=arrayEventos[evento].getValor();//arrayEventos[evento].getValor();         
         console.log(evento);
            }     
    return valor;
        }
        catch(err){
            console.log(err);
            
        }
  }


ARBOL.Compuerta.prototype.getValorCompuerta=function(compuerta) {
    //this.setValEventos(valEventos);=0.0;
    //var valCompuerta=0.0;
    //var valor=0.0d;          
//    console.log(compuerta,"numero de hijos",compuerta.getHijosCompuertas().length);
    try{
        /*
    var compuertaint=new ARBOL.Compuerta('','TEMP');
    compuerta.getTipo=compuertaint.getTipo;
    compuerta.getValor=compuertaint.getValor;
    compuerta.getHijosCompuertas=compuertaint.getHijosCompuertas;
    compuerta.getHijosEventos=compuertaint.getHijosEventos;
    compuerta.getid=compuertaint.getId;*/
        
    /*
    compuerta.getHijosCompuertas=compuertaint.getHijosCompuertas(compuerta);
    for (var compuertaAux in compuerta.getHijosCompuertas())
        console.log(compuertaAux);
    */
    switch (compuerta.getTipo()) {
      case "AND":
        compuerta.setValor(this.getValEventosAND(compuerta.getHijosEventos()));
        //compuerta.setValEventos(compuerta.getValor());
        break;
      case "OR":
        compuerta.setValor(this.getValEventosOR(compuerta.getHijosEventos()));
        //compuerta.setValEventos(compuerta.getValor());
        break;
    }
    console.log("el id de compuerta: " + compuerta.getTipo() + " valor Hijos Eventos: " + compuerta.getValor());
    if (compuerta.getHijosCompuertas().length > 0) {
      var x = 0;
      for (var compuertaAux in compuerta.getHijosCompuertas()) {
        x++;       
        compuerta.hijosCompuertas[compuertaAux].setValor(this.getValorCompuerta(compuerta.hijosCompuertas[compuertaAux]));
        console.log("Valor de compuerta en for:" + compuerta.hijosCompuertas[compuertaAux].getTipo() + " valor: " + compuerta.hijosCompuertas[compuertaAux].getValor());
        switch (compuerta.getTipo()) {
          case "AND":
            compuerta.setValor(compuerta.getValor() * compuerta.hijosCompuertas[compuertaAux].getValor());
            break;
          case "OR":
            compuerta.setValor(compuerta.getValor() + compuerta.hijosCompuertas[compuertaAux].getValor());
            break;
        }
        console.log("En el For la compuerta: " + compuerta.getTipo() + " valor: " + compuerta.getValor());
      }
    } 

    console.log("el valor de la compuerta " + compuerta.getId() + " : " + compuerta.getValor());
    return compuerta.getValor();
    }
    catch(err){
        console.log(err);
    }
  }
  
ARBOL.Compuerta.prototype.getValEventos=function(){
    return this.valEventos;
};

                                                                                                                        
ARBOL.Compuerta.prototype.toJSON=function(){
    var arregloEventos=new Array();
    arregloEventos ="[";
    for(var x=0,l=this.hijosEventos.length;x<l;x++) {
        arregloEventos+=this.hijosEventos[x].toJSON();
        if(x<l-1) arregloEventos+=",";
    }
    arregloEventos+="]";
    /*    var arregloCompuertas=new Array();
    arregloCompuertas ="[";
    for(var x=0,l=this.hijosCompuertas.length;x<l;x++) {
        arregloCompuertas+=this.hijosCompuertas[x].toJSON();
        if(x<l-1) arregloCompuertas+=",";
    }
    arregloCompuertas+="]";*/
    
    /*
    var arregloSuscriptores=new Array();
    arregloSuscriptores="[";
    for(var x=0,l=this.suscriptores.length;x<l;x++) {
        arregloSuscriptores+=this.suscriptores[x].toJSON();
        if(x<l-1) arregloSuscriptores+=",";
    }
    
    arregloSuscriptores+="]";*/
//    var object='{"class":"Compuerta","id":"'+this.id+'","valor":'+this.valor+',"valEventos":'+this.valEventos+',"tipo":"'+this.tipo+'","valCompuertas":'+this.valCompuertas+',"modelId":"'+this.modelID+'","portIn":"'+this.portIn+'","hijosEventos":'+arregloEventos+',"hijosCompuertas":'+arregloCompuertas+',"padre":"'+this.padre+'","valido":'+this.valido+',"suscriptores":'+arregloSuscriptores+'}';
    //var object='{"class":"Compuerta","id":"'+this.id+'","valor":'+this.valor+',"valEventos":'+this.valEventos+',"tipo":"'+this.tipo+'","valCompuertas":'+this.valCompuertas+',"modelId":"'+this.modelID+'","portIn":"'+this.portIn+'","hijosEventos":'+arregloEventos+',"hijosCompuertas":'+arregloCompuertas+',"padre":"'+this.padre+'","valido":'+this.valido+'}';
    var object='{"class":"Compuerta","id":"'+this.id+'","valor":'+this.valor+',"valEventos":'+this.valEventos+',"tipo":"'+this.tipo+'","valCompuertas":'+this.valCompuertas+',"modelId":"'+this.modelID+'","portIn":"'+this.portIn+'","hijosEventos":'+arregloEventos+',"padre":"'+this.padre+'","valido":'+this.valido+'}';
    return object;                                                                                           
}    
//#fin de la definicion de la compuerta


//#definicion de Evento
ARBOL.Evento = function (id,nombre) 
{ 
    this.id=id;
    this.nombre = nombre;
    this.valor=0;    
    this.x;
    this.y;
    this.modelId;
    this.portIn;
    this.portout;
    this.compuertaHijo;
    this.compuertaPadre;
    this.editable=true;
    this.idNomenclatura;
    this.idarbol;
    this.suscriptores = new Array();
};


ARBOL.Evento.prototype.suscribir=function(objeto){
    this.suscriptores.push(objeto);
};

ARBOL.Evento.prototype.Update=function(objeto){
    this.valor=this.getHijo().getValor();
    console.log("Valor de Evento en Update"+this.valor);
    for(var x=0,l = this.suscriptores.length;x<l;x++){
            this.suscriptores[x].Update(this);
       }
    
};

ARBOL.Evento.prototype.setPadre=function(padre)
{
   if( padre instanceof ARBOL.Compuerta){ 
       this.compuertaPadre=padre;
   }else
   console.log("Solo se puede agregar un elemento del tipo ARBOL.Compuerta");   
};

ARBOL.Evento.prototype.setHijo=function(hijo)
{
   if(hijo instanceof ARBOL.Compuerta&& (typeof this.compuertaHijo=='undefined')){ 
       this.compuertaHijo=hijo;
       hijo.suscribir(this);
   }else if(this.compuertaHijo instanceof ARBOL.Compuerta){
                  console.log("Solo puede tener un Hijo Compuerta");
       
        }else{
       console.log("Solo se puede agregar un elemento del tipo ARBOL.Compuerta");
   }
};

ARBOL.Evento.prototype.hasHijoCompuerta=function(hijo){
    if(hijo instanceof ARBOL.Compuerta){ 
       return hijo===this.compuertaHijo;   
    }
    return false;    
};

ARBOL.Evento.prototype.getHijo=function(){
    return this.compuertaHijo;
    
};
ARBOL.Evento.prototype.setValor=function(valor)
{
   if((typeof valor==="number") && (valor >0 &&valor<1)){  
       this.valor=valor;
       //$(this).trigger("changeValueEvent",this);
       //ARBOL.Event.fire(this);
       //console.log("test valor");
       //alert(this.Contenedor);//.val('dos');
       for(var x=0,l = this.suscriptores.length;x<l;x++){
//           console.log("------",this.suscriptores[x]);
            this.suscriptores[x].Update(this);
           
           
       }
   }
   else
     console.log("Solo se aceptan valores mayores a 0 y menores a 1")
};

ARBOL.Evento.prototype.isValido=function(){
    return (this.valor >0 &&this.valor<1)?true:false;
      
};


ARBOL.Evento.prototype.getValor=function()
{   
        if(typeof this.compuertaHijo!='undefined')
       return this.valor=this.compuertaHijo.getValorCompuerta(this.compuertaHijo);
        else return this.valor;
   
};


ARBOL.Evento.prototype.setNombre=function(nombre)
{   
       this.nombre=nombre;
   
};

ARBOL.Evento.prototype.getNombre=function()
{   
       return this.nombre;
   
};

ARBOL.Evento.prototype.toJSON=function(){//this.editable=true;
    this.idNomenclatura;
    this.idarbol;
    var object='{"class":"Evento","id":"'+this.id+'","nombre":"'+this.nombre+'","valor":'+this.valor+',"editable":"'+this.editable+
            '","idNomenclatura":"'+this.idNomenclatura+'"}';
    //console.log(JSON.stringify(this));
    return object;
}
    
//#fin de la definicion de Evento

//#Definición de Arbol
ARBOL.ArbolFalla=function(id,nombre){
    this.id="";
    this.nombre="";
    this.eventoTope;
    this.arbolGrafico;
};

ARBOL.ArbolFalla.prototype.toObjctLogicJSON=function(){
    var objeto='{"class":"ArbolFalla","id":"'+this.id+'","nombre":"'+this.nombre+'","valor":'+this.eventoTope.getValor()+',"eventoTope":'+this.eventoTope.toJSON()+'}';   
    return objeto;
};

ARBOL.ArbolFalla.prototype.toObjctGraphicJSON=function(){
    var objeto='{"class":"ArbolFalla","id":"'+this.id+'","nombre":"'+this.nombre+'","arbolGrafico":'+this.arbolGrafico+'}';   
    return objeto;
};

ARBOL.ArbolFalla.prototype.setArbolGrafico=function(arbolGrafico){
    return this.arbolGrafico=arbolGrafico;
};

ARBOL.ArbolFalla.prototype.getArbolGrafico=function(){
    return this.arbolGrafico;
};


ARBOL.ArbolFalla.prototype.getEventoTope=function(){
    return this.eventoTope;
    
}
ARBOL.ArbolFalla.prototype.setEventoTope=function(eventoTope){
    if(eventoTope instanceof ARBOL.EventoTope){
        console.log("Agregando Evento Tope");
       this.eventoTope=eventoTope; 
    }
};

ARBOL.ArbolFalla.prototype.setNombre=function(nombre){
  this.nombre=nombre;  
};

ARBOL.ArbolFalla.prototype.getNombre=function(){
  return this.nombre;  
};


ARBOL.ArbolFalla.prototype.setId=function(id){
  this.id=id;
};


ARBOL.ArbolFalla.prototype.getId=function(id){
  this.id=id;    
};

ARBOL.ArbolFalla.prototype.getValor=function(id){
  return this.eventoTope.getValor();
};



ARBOL.ArbolFalla.prototype.toJSON=function(){    
    var objeto='{"class":"ArbolFalla","id":"'+this.id+'","nombre":"'+this.nombre+'","valor:"'+this.eventoTope.getValor()+'","eventoTope":'+this.eventoTope.toJSON()+',"arbolGrafico":'+this.arbolGrafico+'}';   
    return objeto;
};   





//#ASIGNACIONES Y CREACION DE ARBOL
ARBOL.setEventoTope=function(EventoTope){
    if(EventoTope instanceof ARBOL.EventoTope)
    {
       this.EventoTope=EventoTope;
    }
    else
        console.log("no es el objeto esperado EventoTope");
    
};
   

ARBOL.getEventoTope=function(){
    return this.EventoTope;
};

ARBOL.setHijoEventoTope=function(compuerta){
    if(compuerta instanceof ARBOL.Compuerta)
    {
       if(this.EventoTope!="undefined"){
           this.EventoTope.setHijo(compuerta);     
           // $(this).bind("OnSetCLHijo",ARBOL.OnSetCLHijo);
           this.EventoTope.OnUpdateValArbol=function(event){
            this.EventoTope.val=event.val;
            console.info("actualizando valor de arbol");
            console.info(this);
        }
        $(this).bind("OnUpdateValArbol",this.EventoTope.OnUpdateValArbol);
        }      
    }
    else
            console.log("no es el objeto esperado se esperaba una compuerta");
};



///eventos


ARBOL.OnUpdateValArbol=function(event){
    ARBOL.EventoTope.val=ARBOL.EventoTope.CL.val;
};



ARBOL.OnSetCLHijo=function(event){
    this.EventoTope.val+=event.val;
    console.log("ARBOL.OnSetCLHijo agregando un hijo");
    console.log(event);
    console.info(ARBOL.EventoTope);
};

//#FIN DE ASIGNACIONES Y CREACION DE ARBOL