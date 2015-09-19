/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var  APS = APS || {};

APS.ArbolEventos = function (id,nombre){
    this.id;
    this.nombre;
    this.eventoIniciador;
    this.sistema;
};
APS.ArbolEventos.prototype.getId=function(){
    return  this.id;    
}
APS.ArbolEventos.prototype.setId=function(id){
    this.id=id;    
}
APS.ArbolEventos.prototype.getNombre=function(){
    return  this.nombre;    
}
APS.ArbolEventos.prototype.setNombre=function(nombre){
    this.nombre=nombre;    
}



APS.ArbolEventos.prototype.setSistema=function(sistema){
    if(sistema instanceof APS.Sistema){
        console.log("EventoIni",this.eventoIniciador);
        sistema.setFrecuencia(this.eventoIniciador.getValor()*sistema.getValorArbolFalla());
        sistema.setValorExito(this.eventoIniciador.getValor()*(1-sistema.getValorArbolFalla()));
        this.sistema=sistema;
    }
};
APS.ArbolEventos.prototype.getSistema=function(){
    
        return this.sistema;
};
APS.ArbolEventos.prototype.setEventoIniciador=function(EventoIniciador){
    if(EventoIniciador instanceof APS.EventoIniciador){
        this.eventoIniciador=EventoIniciador;
        
    }
};
APS.ArbolEventos.prototype.getEventoIniciador=function(){
    
        return this.eventoIniciador;
};



//#definicion de EventoIniciador
APS.EventoIniciador = function (id,nombre) 
{ 
    this.id=id;
    this.idArbol;
    this.nombre = nombre;
    this.valor=0;
    this.x;
    this.y;
    this.modelId;
    this.portIn;    
};

APS.EventoIniciador.prototype.getId=function(){
    return  this.id;    
}
APS.EventoIniciador.prototype.stId=function(id){
    this.id=id;    
}
APS.EventoIniciador.prototype.getIdArbol=function(){
    return  this.idArbol;    
}
APS.EventoIniciador.prototype.setIdArbol=function(idArbol){
    this.idArbol=idArbol;    
}
APS.EventoIniciador.prototype.getNombre=function(){
    return  this.nombre;    
}
APS.EventoIniciador.prototype.setNombre=function(nombre){
    this.nombre = nombre;    
}
APS.EventoIniciador.prototype.getValor=function(){
    return  this.valor;    
}
APS.EventoIniciador.prototype.setValor=function(valor){
    this.valor=valor;    
}
APS.EventoIniciador.prototype.Update=function(event)
{
    //Cambiar la implementacion
    //console.log("procesando la solicitud de compuerta");
    //this.valor=this.compuertaHijo.getValorCompuerta(this.compuertaHijo);
    
}
APS.EventoIniciador.prototype.OnUpdateValArbol=function(event)
{
    /*this.val=event.val;
    console.info("actualizando valor de arbol");
    console.info(this);
    */
    
};

//#fin de definicion de evento Iniciador

//#definicion del link
APS.Link = function (x,y,length) {
    this.x=x;
    this.y=y;
    this.length=length;        
};
//#fin de la definicion del link

//#definicion de Sistema
APS.Sistema = function (id,nombre) 
{ 
    this.id=id;
    this.idArbol; //id arbol eventos
    this.idArbolFalla; //id arbol falla
    this.nombre = nombre;
    this.arbolFalla; //arbol falla (object)
    this.frecuencia;
    this.valorExito;
    this.falla; // sistema hijo (object) como falla
    this.exito; // sistema hijo (object) como exito
    this.padre;
    this.f=1; //Bandera 1 es falla, 0 es exito; 
    this.x;
    this.y;
    this.modelId;
    this.portIn;
    this.editable=true;
    this.idNomenclatura;
    this.suscriptores = new Array();
    this.valorArbolFalla; //Variable temporal, sera eliminad cuando arbol eventos obtenga el valor de los arboles de falla creados
};

APS.Sistema.prototype.setValorArbolFalla=function(valorArbolFalla)
{   
       this.valorArbolFalla=valorArbolFalla;
   
};

APS.Sistema.prototype.getValorArbolFalla=function()
{   
       return this.valorArbolFalla;
   
};

APS.Sistema.prototype.setId=function(id)
{   
       this.id=id;
   
};

APS.Sistema.prototype.getId=function()
{   
       return this.id;
   
};
APS.Sistema.prototype.setIdArbol=function(idArbol)
{   
       this.idArbol=idArbol;
   
};

APS.Sistema.prototype.getIdArbol=function()
{   
       return this.idArbol;
   
};
APS.Sistema.prototype.setIdArbolFalla=function(idArbolFalla)
{   
       this.idArbolFalla=idArbolFalla;
   
};

APS.Sistema.prototype.getIdArbolFalla=function()
{   
       return this.idArbolFalla;
   
};
APS.Sistema.prototype.setNombre=function(nombre)
{   
       this.nombre=nombre;
   
};
APS.Sistema.prototype.getNombre=function()
{   
       return this.nombre;
   
};
APS.Sistema.prototype.setArbolFalla=function(arbolFalla)
{   
       this.arbolFalla=arbolFalla;
   
};
APS.Sistema.prototype.getArbolFalla=function()
{   
       return this.arbolFalla;
   
};

APS.Sistema.prototype.getFrecuencia=function()
{   
       return this.frecuencia;
   
};

APS.Sistema.prototype.setFrecuencia=function(frecuencia)
{   
       this.frecuencia=frecuencia;
   
};

APS.Sistema.prototype.setValorExito=function(valorExito)
{
       this.valorExito=valorExito;
      
};
APS.Sistema.prototype.getValorExito=function()
{   
       return this.valorExito;
   
};
APS.Sistema.prototype.setFalla=function(falla)
{
    //falla.setFrecuencia(falla.getArbolFalla().getEventoTope().getValor()*this.getFrecuencia());
    //falla.setValorExito((1-falla.getArbolFalla().getEventoTope().getValor())*this.getFrecuencia());
    falla.setFrecuencia(falla.getValorArbolFalla()*this.getFrecuencia());
    falla.setValorExito((1-falla.getValorArbolFalla())*this.getFrecuencia());
    this.flag=1;
    this.falla=falla;
   
};
APS.Sistema.prototype.getFalla=function()
{   
       return this.falla;
   
};
APS.Sistema.prototype.setExito=function(exito)
{   
    //exito.setFrecuencia(exito.getArbolFalla().getEventoTope().getValor() * this.getValorExito());
    //exito.setValorExito((1-exito.getArbolFalla().getEventoTope().getValor())*this.getValorExito());
    exito.setFrecuencia(exito.getValorArbolFalla() * this.getValorExito());
    exito.setValorExito((1-exito.getValorArbolFalla())*this.getValorExito());
    this.flag=0;
    this.exito=exito;
   
};
APS.Sistema.prototype.getExito=function()
{   
       return this.exito;
   
};
APS.Sistema.prototype.setPadre=function(padre)
{   
       this.padre=padre;
   
};
APS.Sistema.prototype.getPadre=function()
{   
       return this.padre;
   
};
APS.Sistema.prototype.setF=function(f)
{   
       this.f=f;
   
};
APS.Sistema.prototype.getF=function()
{   
       return this.f;
   
};
APS.Sistema.prototype.setX=function(x)
{   
       this.x=x;
   
};
APS.Sistema.prototype.getX=function()
{   
       return this.x;
   
};
APS.Sistema.prototype.setY=function(y)
{   
       this.y=y;
   
};
APS.Sistema.prototype.getY=function()
{   
       return this.y;
   
};
APS.Sistema.prototype.setModelId=function(modelId)
{   
       this.modelId=modelId;
   
};
APS.Sistema.prototype.getModelId=function()
{   
       return this.modelId;
   
};
APS.Sistema.prototype.setPortIn=function(portIn)
{   
       this.portIn=portIn;
   
};
APS.Sistema.prototype.getPortIn=function()
{   
       return this.portIn;
   
};
APS.Sistema.prototype.setEditable=function(editable)
{   
       this.editable=editable;
   
};
APS.Sistema.prototype.getEditable=function()
{   
       return this.editable;
   
};
APS.Sistema.prototype.setIdNomenclatura=function(idNomenclatura)
{   
       this.idNomenclatura=idNomenclatura;
   
};
APS.Sistema.prototype.getIdNomenclatura=function()
{   
       return this.idNomenclatura;
   
};

/////////////////////////////////////////////////////////////////////////
APS.Sistema.prototype.suscribir=function(objeto){
    this.suscriptores.push(objeto);
};

APS.Sistema.prototype.Update=function(objeto){
    //this.valor=this.getHijo().getValor();
    
};

APS.Sistema.prototype.isValido=function(){
    return (this.valor >0 &&this.valor<1)?true:false;
      
};
APS.EventoIniciador.prototype.isValido=function(){
    return (this.valor >0 &&this.valor<1)?true:false;
      
};

////////////////////// Cambiar ///////////////////////////////

APS.EventoIniciador.prototype.toJSON=function(){
    var object='{"class":"EventoTope","idarbol":"'+this.idarbol+'","id":"'+this.id+'","nombre":"'+this.nombre+'","valor":'+this.valor+',"x":'+this.x+',"y":'+this.y+',"modelId":'+this.modelID+',"portIn":'+this.portIn+',"compuertaHijo":'+this.compuertaHijo+'}';                      
    return object;
}

/*ARBOL.setHijoEventoTope=function(compuerta){
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

*/
   
