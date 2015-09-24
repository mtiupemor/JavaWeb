<%-- 
    Document   : creaArbolEventos
    Created on : 18/09/2015, 12:53:38 AM
    Author     : Ramon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="shortcut icon" href="favicon.png">
    <title>Crea tu árbol de eventos</title>

    <link rel="stylesheet" href="../css/joint.css" />
        <link rel="stylesheet" href="../css/arbolEventos.css" />
        <link rel="stylesheet" href="../css/compuerta.css" />
        <link rel="stylesheet" href="../css/logic.css" />
        <script src="../js/joint.js"></script>                
        <script src="../js/joint.shapes.arbolEventos.js"></script>
        <script src="../js/joint.shapes.logic.js"></script>
        <script src="../js/joint.shapes.logic.min.js"></script>
        <script src="../js/arboleventos.js"></script>
        
        <script>
            var lon =200;
            var lat =400;
            var eventoIniciador;
            var idSistema="";
            var idExito="";
            var id1="";
            var sistema;
            var exito;
            var frecuencia;
            var exitoFin;
            var xySistema;
            var xyExito;
            var exitosNull=[]; //Almacena los exitos que han quedado nulos
            var sistemasNull=[];//Almacena los sistemas que han quedado nulos
            var arbolEventos = new APS.ArbolEventos("","");
            var calculado =0; //Para no redibujar los elementos en calcular   
           $(document).ready(function () {

                var graph = new joint.dia.Graph;

                var paper = new joint.dia.Paper({
                    el: $('#paper'),
                    width: 1000,
                    height: 800,
                    gridSize: 1,
                    model: graph,
                    snapLinks: true,
                    embeddingMode: true,
                    defaultLink: new joint.shapes.logic.Wire,
                    validateEmbedding: function (childView, parentView) {
                        return false;//parentView.model instanceof joint.shapes.arbol.Coupled;
                    },
                    validateConnection: function (sourceView, sourceMagnet, targetView, targetMagnet) {
                        return sourceMagnet != targetMagnet;
                    }
                });
                
                //cargando sistemas  o arboles de fallas//
                //txtNombreSistema
                    $.ajax({
                        url: "../getArbolesFalla",
                        type: "POST",
                        data: {consulta : "all"},
                        dataType: "json", 
                        success: function(respuesta)                          
                        {                                             
                        //graph.fromJSON(respuesta);
                        var options="<option ";
                        $.each(respuesta, function(posicion, arbol){
                            console.log(' >',
                                'Posición: ', posicion," ",arbol                      
                            );
                                
                                $.each(arbol,function(clave,valor){
                                    console.log(' >',
                                'clave: ', clave," ",valor  
                                 );
                                 options+="value='"+valor+"'>"+clave+"</option>";
                            });
                           
                                });
                          $("#txtNombreSistema").html(options);
                        
                    
           

                        },
                        error: function(XMLHttpRequest, textStatus, errorThrown) {
                        alert("No se encontro el servicio solicitado"+errorThrown);
                        //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
                        console.log(XMLHttpRequest.status);
                    }   
               }); 
                

                //Llamada a evento iniciador
                $("#eventoIniciador").click(function (evt) {
                    
                    var eventoIniciadorNombre =$("#txtNombreEventoIniciador").val();
                    eventoIniciador = new joint.shapes.arbolEventos.EventoIniciador({
                        position: {x: 20, y: 300},
                        size: {width: 100, height: 40},
                        label: 'I am HTML',
                        inPorts: ['in']
                    });
                    eventoIniciador.eventoIniciador = new APS.EventoIniciador(eventoIniciador.id,eventoIniciadorNombre);
                    eventoIniciador.eventoIniciador.setValor($("#txtValorEventoIniciador").val());
                    arbolEventos.setId("abcd1234"); //Agregar id dinamicamente funcion CLIO                    
                    arbolEventos.setEventoIniciador(eventoIniciador.eventoIniciador);
                    
                    console.log(arbolEventos);
                    
                    graph.addCells([eventoIniciador]);
                    $("#txtValorEvento").val($("#txtValorEventoIniciador").val());
                    
                    
                    //Agregar titulo del evento iniciador
                    var nombreEventoIniciador = new joint.shapes.basic.Rect({
                        position: { x: 20, y: 50 },
                        size: { width: 100, height: 30 },
                        attrs: { rect: { fill: '#E74C3C' }, text: { text: eventoIniciadorNombre} }
                    });
                    graph.addCells([nombreEventoIniciador]);
                
                }); //FIN evento iniciador
                
                //Funcion que agrega los elementos con el nombre de los sistemas
                function agregarNombreSistema(lon1,nombreSistema){
                    var nombreSistema = new joint.shapes.basic.Rect({
                        position: { x: lon1, y: 30 },
                        size: { width: 100, height: 30 },
                        attrs: { rect: { fill: '#E74C3C' }, text: { text: nombreSistema} }
                    });
                    graph.addCells([nombreSistema]);
                }
  
                  //Llamada a sistema
                $("#sistema").click(function (evt) {
                  var valorArbolFalla = $("#txtNombreSistema").val(); //Deberia obtenerlo de los arboles creados
                  var sistemaNombre =$("#txtNombreSistema option:selected").html();       
                  if (document.getElementById("rbtFalla").checked)
                  {
                        if(graph.getCell(idSistema)!=null){
                            lon=xySistema.x+150;  //Desplazamiento de x
                            lat=xySistema.y+100;  
                            crearSistema();
                            
                            conectar(graph.getCell(idSistema),'in',sistema,'in');
                            exitosNull.push(idExito); //Se agrega el sistema anterior porque queda nulo
                            sistema.sistema = new APS.Sistema(sistema.id,sistemaNombre);//Creo el nuevo sistema
                            sistema.sistema.setValorArbolFalla(valorArbolFalla);
                            sistema.findView(paper).updateBox();

                            
                            for(var x=0,l=graph.getElements();x<l.length;x++){
                                if (l[x].id == idSistema){
                                    l[x].sistema.setFalla(sistema.sistema);
                                    console.log("Encontrado: ",l[x]);
                                    break;
                                }
                            }
                        console.log(arbolEventos);    
                        }else{
                            crearSistema();
                            id1 = sistema.get('id'); //Obtiene el id del primer sistema
                            conectar(eventoIniciador,'in',sistema,'in')//se conecta el evento iniciador con el primer sistema
                            sistema.sistema = new APS.Sistema(id1,sistemaNombre); //Es el primer sistema, se agrega al arbol junto con evento iniciador
                            sistema.sistema.setValorArbolFalla(valorArbolFalla);
                            arbolEventos.setSistema(sistema.sistema);
                            //sistema.sistema.setExito(exito);
                            console.log(arbolEventos);
                            //idExito = exito.get('id'); //Obtiene el id del nuevo exito
                            //exitosNull.push(idExito); //Se agrega el sistema anterior porque queda nulo
                            sistema.findView(paper).updateBox();
                        }
                  }else{
                        if(graph.getCell(idSistema)!=null){
                          lon=xyExito.x+150;
                          lat=xyExito.y;
                          crearSistema();
                          //graph.getCell(idExito).embed(sistema);//Agrega el nuevo sistema como hijo del sistema anterior
                          conectar(graph.getCell(idExito),'in',sistema,'in');
                          sistemasNull.push(idSistema); //Se agrega el exito anterior porque ha quedado nulo
                          sistema.sistema = new APS.Sistema(sistema.id,sistemaNombre);//Creo el nuevo sistema tipo exito
                          sistema.sistema.setValorArbolFalla(valorArbolFalla);
                          sistema.findView(paper).updateBox();
                          //sistema.sistema.setExito(exito);
                            for(var x=0,l=graph.getElements();x<l.length;x++){
                                if (l[x].id == idSistema){
                                    console.log("Exito idExito:",l[x]);
                                    l[x].sistema.setExito(sistema.sistema);
                                    console.log("Encontrado: ",l[x]);
                                    break;
                                }
                            }
                        }else{
                            alert("Agrega primero un sistema");
                            //idSistema = sistema.get('id'); //Obtiene el id del primer sistema
                            //conectar(eventoIniciador,'in',sistema,'in')//se conecta el evento iniciador con el primer sistema
                        }
                  }
                  console.log(arbolEventos);
                  idSistema=sistema.get('id'); //Obtiene el id del nuevo sistema
                  idExito = exito.get('id'); //Obtiene el id del nuevo exito
                }); //Fin sistema
                //Llamada a exito  
                
                //Funcion para crear los sistemas
                function crearSistema(){
                    var nombreSistema = $("#txtNombreSistema option:selected").html();
                    sistema = new joint.shapes.arbolEventos.Sistema({
                        position: {x: lon, y: lat},
                        size: {width: 100, height: 40},
                        inPorts: ['in']
                    });
                    sistema.type="sistema";
                    xySistema = sistema.get('position');//Obtiene la posición del sistema creado
                    graph.addCells([sistema]);
                    crearExito(xySistema.x,xySistema.y-100); //Crea un elemento exito 100 pixeles arriba del sistema
                    xyExito = exito.get('position');
                    //sistema.embed(exito); //Lo agrega como hijo del sistema creado
                    conectar(sistema,'in',exito,'in');
                    //Agrego la caja con el nombre del sistema
                    agregarNombreSistema(lon,nombreSistema);
                    //Vacio el textbox
                    //document.getElementById("txtNombreSistema").value="";
                }
                
                //Función para crear los elementos exitos (cada que se agrega un sistema se dibuja un cuadro exito
                function crearExito(lon1,lat1){
                    exito = new joint.shapes.arbolEventos.Exito({
                        position: {x: lon1, y: (lat1)},
                        size: {width: 100, height: 40},
                        inPorts: ['in']
                    });
                    exito.type="exito"; 
                    graph.addCells([exito]);
                }

                //Función conectar, crea los links entre los elementos
                var conectar = function(source, sourcePort, target, targetPort) {
                    var link = new joint.shapes.logic.Wire({
                    source: { id: source.id, selector: source.getPortSelector(sourcePort) },
                    target: { id: target.id, selector: target.getPortSelector(targetPort) }
                    });
                link.addTo(graph).reparent();
                };
                //Termna funcion conectar
                
                //Función frecuencia, crea los cuadros de frecuencias que contendran los valores calculados
                function crearFrecuencia(lon1,lat1){
                    frecuencia = new joint.shapes.arbolEventos.Frecuencia({
                        position: {x: lon1, y: lat1},
                        size: {width: 100, height: 40},
                        inPorts: ['in']
                    });
                  graph.addCells([frecuencia]);
                }
                
                //Funcion crearExitoFin, crea los cuadros de exito para formar bien el arbol
                function crearExitoFin(lon1,lat1){
                    exitoFin = new joint.shapes.arbolEventos.Exito({
                        position: {x: lon1, y: (lat1)},
                        size: {width: 100, height: 40},
                        inPorts: ['in']
                    });
                    exitoFin.type="exitoFin"; 
                    graph.addCells([exitoFin]);
                }

                //Función calcular, crea los elementos exitos y frecuencias finales para formar el arbol
                $("#calcular").click(function (evt) {
                    if(calculado==0){
                        //x de el ultimo sistema creado
                        var xMax = graph.getCell(sistema.id).get('position').x;
                        xMax+=150;
                        //crear el elemento frecuencia para el ultimo sistema
                        crearFrecuencia(xMax,graph.getCell(sistema.id).get('position').y + 28);
                        frecuencia.frecuencia=graph.getCell(sistema.id).sistema.getFrecuencia();
                        frecuencia.findView(paper).updateBox();
                        //Conecta ultimo sistema con su frecuencia
                        conectar(sistema,'in',frecuencia,'in');
                        //crear el elemento exito para el ultimo exito (Solo para dibujar bien el arbol.
                        crearExitoFin(xMax,graph.getCell(exito.id).get('position').y);
                        //Conectar el ultimo exito
                        conectar(exito,'in',exitoFin,'in');
                        //recorrer exitosNull y conectarlos par dibujar el arbol
                        exitosNull.forEach(function(idExitoNull){
                            crearExitoFin(xMax,graph.getCell(idExitoNull).get('position').y);
                            conectar(graph.getCell(idExitoNull),'in',exitoFin,'in');
                        });
                        //recorrer sistemasNull, crear sus frecuencias y conectarlos
                        sistemasNull.forEach(function(idSistemaNull){
                            crearFrecuencia(xMax,graph.getCell(idSistemaNull).get('position').y + 28);
                            conectar(graph.getCell(idSistemaNull),'in',frecuencia,'in');
                            console.log(graph.getCell(idSistemaNull).sistema.getFrecuencia());
                            frecuencia.frecuencia=graph.getCell(idSistemaNull).sistema.getFrecuencia();
                            frecuencia.findView(paper).updateBox();
                        });
                        //Agrego la caja con titulo Frecuencia
                        agregarNombreSistema(xMax,"Frecuencia");
                        calculado=1;
                    }
                });
                
                //Esta función se manda a llamar cada que se agrega un elemento, se usa para reubicar los elementos
                graph.on('add', function(sistema) { 

                    if(sistema.type==="exito"){
                        var cont =0;
                        var yExito = graph.getCell(sistema.id).get('position').y; //Se obtiene valor y del nuevo elemento exito
                        for (var cont = exitosNull.length - 1; cont >= 0 ; cont--){
                            if( yExito <= graph.getCell(exitosNull[cont]).get('position').y){
                                yExito= graph.getCell(exitosNull[cont]).get('position').y - yExito + 100;
                                graph.getCell(exitosNull[cont]).translate(0,-yExito);
                                yExito = graph.getCell(exitosNull[cont]).get('position').y;
                            }
                        }
                    }
                    if(sistema.type==="sistema"){
                        
                        var cont =0;
                        var ySistema=graph.getCell(sistema.id).get('position').y;
                        for (var cont = sistemasNull.length - 1; cont >= 0 ; cont--){
                            if( ySistema >= graph.getCell(sistemasNull[cont]).get('position').y){
                                ySistema= ySistema - graph.getCell(sistemasNull[cont]).get('position').y + 100;
                                graph.getCell(sistemasNull[cont]).translate(0,ySistema);
                                ySistema = graph.getCell(sistemasNull[cont]).get('position').y;
                            }
                        }
                    }
                });
                
                //Función para redimencionar el paper conforme se van creando los elementos
                function redimencionar(yExito){
                    /*if(yExito<=50){
                        paper.fitToContent();
                    }*/
                }
                
                   /*****funcion dato modal********/
                  $("#SaveTitle").on("click", function(){
                      var titulo_arbol = $("#nameArbol").val();
                      $("#titulo").html(titulo_arbol);              
                      arbolEventos.setNombre(titulo_arbol);
                      console.log("Poniendo Nombre",titulo_arbol,arbolEventos.getNombre());
                  });
                /************************/
            }); //FIN DE READY
    </script>
    <%@include file="head_arbol.jsp" %> 
  </head>


  <body>
    <header>
      <%@include file="header_arbol.jsp" %> 
    </header>

    <div class="wrapper">
      <section id="informacion">
        <div class="container">
          <br/><br/><br/>
          <div class="section-heading ">
            <h2>Crea tu árbol de eventos</h2>
            <div class="divider"></div>
                      <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            Nombra tu árbol
          </button>
            </div>
          <div class="row">
            <div class="col-md-12">
              <div>  
                
                <form id="eventos">
                <table border="1">
                <tr>
                <td rowspan="7">
                    <div id="paper" >

                    </div>
                </td>
                </tr>
                <tr>
                <td width="250" align="CENTER">
                    Nombre: <input type="text" id="txtNombreEventoIniciador" value="" />
                    Valor: <input type="text" id="txtValorEventoIniciador" value="" />
                    <input type="button" id="eventoIniciador" value="Evento iniciador" />
                </td>
                </tr>
                <tr>
                <td width="250" align="CENTER">
                    Nombre: 
                      <select id="txtNombreSistema" name="nombreSistema" >
                        <!--<optgroup label="Sistemas">-->

                          <!-- while (unIteradorEmpleado.hasNext()) {
                            EmpleadoDTO unEmpleado = (EmpleadoDTO) unIteradorEmpleado.next(); -->

                         <!-- <option value="0.27"> HPCF</option>
                          <option value="0.33"> RCIC</option>
                          <option value="0.12"> RHR</option>
                          <option value="0.25"> ADS</option>
                          <option value="0.7"> ICS</option>
                          <option value="0.48"> GDCS</option>
                          <option value="0.88"> PCCS</option>
                          <option value="0.17"> HPVCSCF</option>
                         -->
                          <!--  } -->
                       <!-- </optgroup>-->
                      </select>
                    <br>
                    Tipo: <input id="rbtFalla" type="radio" name="sistema" value="falla" checked>Falla
                    <input id="rbtExito" type="radio" name="sistema" value="exito">exito
                    <br>
                    <input type="button" id="sistema" value="Sistema" />
                </td>
                </tr>
                <tr>
                <td width="250" align="CENTER">
                    <input type="button" id="calcular" value="Calcular" />
                </td>
                </tr>
                </table>
                </form>

                <div id="paper-link-out"><b></b></div>
                <p></p> 


              </div>
            </div>  
          </div>
        </div>
      </section>
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title" id="myModalLabel">Nombre de árbol</h4>
            </div>
            <div class="modal-body">
              <input type="text" id="nameArbol" />
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-primary" id="SaveTitle" data-dismiss="modal">Guardar</button>
            </div>
          </div>
        </div>
      </div>
      <footer>
        <div class="container">
          <a href="#" >
            <img src="../img/freeze/logomin.png" alt="" class="logo">
          </a>
          <div class="rights">
            <p>Copyright &copy; 2015</p>
          </div>
        </div>
      </footer>
    </div>

  </body>
</html>