var eT=new ARBOL.EventoTope();
var arbolGrafico;
$(document).ready(function () {

  function calculaOperaciones(link,sourceView, sourceMagnet, targetView, targetMagnet){
    console.log("en funcion");
    console.log(link.get('source'));
      // if(valorCompuerta==="CompuertaAND"){}
      // alert("Tu valor valculado es: " + valorEvento*2);
      // else if(valorCompuerta==="CompuertaOR")
      // alert("no");
  }

  var graph = new joint.dia.Graph;

  var paper = new joint.dia.Paper({
      el: $('#paper'),
      width: 1100,
      height: 450,
      gridSize: 1,
      model: graph,
      snapLinks: true,
      embeddingMode: true,
      defaultLink: new joint.shapes.logic.Wire,
      validateEmbedding: function (childView, parentView) {
          return false;//parentView.model instanceof joint.shapes.arbol.Coupled;
      },
      validateConnection: function (sourceView, sourceMagnet, targetView, targetMagnet)
      {
            var msj="";
        graph.on('change:source change:target', function(link){
          var puertoOrigen = link.get('source').port;
          var origenId = link.get('source').id;
          var puertoDestino = link.get('target').port;
          var destinoId = link.get('target').id;

          console.log("val1 "+origenId);
          console.log("val2"+destinoId);

          if(origenId == destinoId)
          {
            msj="Mismo";
            link.remove();
          }else{
            msj="Diferente";
            if(typeof origenId!='undefined' && typeof destinoId!='undefined')
            {
              var partida=puertoOrigen.slice(0,2);
              var destino=puertoDestino.slice(0,2);
              console.log("puertos: primero>"+partida+" segundo>"+destino);
              calculaOperaciones(link,sourceView, sourceMagnet, targetView, targetMagnet);

              /*ou->ou*/
              if(partida=="ou" && destino=="ou")
              {
                console.log("Primer validacion");
                link.remove();
              }else if (partida=="in" && destino=="in") 
              {
                        console.log("Segunda validacion");
                        link.remove();
                    } else if (partida=="in" && destino=="ou")
                    {
                        console.log("Tercera validacion");
                        link.remove();
                    }
                  }
            }
            var m = [
              'The port <b>' + puertoOrigen,
              '</b> of element with ID <b>' + origenId,
              '</b> is connected to port <b>' + puertoDestino,
              '</b> of elemnt with ID <b>' + destinoId + '</b> : '+ '<b>'+msj+'</b>'
            ].join('');
                    
          //enviamos cordenadas
          out(m);
          });  
                   return sourceMagnet != targetMagnet;
                    }
             });


/*here*/
                /*
                 * To change this license header, choose License Headers in Project Properties.
                 * To change this template file, choose Tools | Templates
                 * and open the template in the editor.
                 */

               /* var connect = function (source, sourcePort, target, targetPort) {
                    if(source instanceof joint.shapes.arbol.Evento && target instanceof joint.shapes.arbol.Evento ){
                            console.log("Evento no se puede unir con evento");
                    }else{
                        console.log("Entra");
                    var link = new joint.shapes.arbol.Link({
                        source: {id: source.id, selector: source.getPortSelector(sourcePort)},
                        target: {id: target.id, selector: target.getPortSelector(targetPort)}
                    });
                    link.addTo(graph).reparent();
                }
                };*/



                /*
                 eventoIniciador.el=new ARBOL.EventoIniciador;
                 console.log(eventoIniciador);
                 */


                /* Metodo para asignar ID del evento*/
               // evento.setIdModel("500ffe65-583f-4205-92b3-1545dd618d4x");


//graph.addCells([evento,cAND]);

//connect(a3,'y',a1,'a');

//connect(c1,'in',a1,'xy');

                /* rounded corners */
                /*
                 _.each([c1,a1,a2,a3,a4,cAND], function(element) {
                 element.attr({ '.body': { 'rx': 6, 'ry': 6 }});
                 });
                 */

                /* custom highlighting */

                var highlighter = V('circle', {
                    'r': 14,
                    'stroke': '#ff7e5d',
                    'stroke-width': '6px',
                    'fill': 'transparent',
                    'pointer-events': 'none'
                });

                paper.off('cell:highlight cell:unhighlight').on({
                    'cell:highlight': function (cellView, el, opt) {

                        if (opt.embedding) {
                            V(el).addClass('highlighted-parent');
                        }

                        if (opt.connecting) {
                            var bbox = V(el).bbox(false, paper.viewport);
                            highlighter.translate(bbox.x + 10, bbox.y + 10, {absolute: true});
                            V(paper.viewport).append(highlighter);
                        }
                    },
                    'cell:unhighlight': function (cellView, el, opt) {

                        if (opt.embedding) {
                            V(el).removeClass('highlighted-parent');
                        }

                        if (opt.connecting) {
                            highlighter.remove();
                        }
                    }
                });

                //Llamada a evento tope
                $("#eventoTope").click(function (evt) {

                    var eventoIniciador = new joint.shapes.arbol.Evento({
                        position: {x: 920, y: 30},
                        size: {width: 170, height: 100},
                        label: 'I am HTML',
                        inPorts: ['in'],
                    });


                    graph.addCells([eventoIniciador]);

                }); //FIN compuertaTope

                  //Llamada a evento
                  $("#evento").click(function (evt) {
                  var evento = new joint.shapes.arbol.Evento({
                        position: {x: 920, y: 30},
                        size: {width: 170, height: 100},
                        label: 'I am HTML',
                        inPorts: ['in'],
                        outPorts: ['out']
                    });
                  graph.addCells([evento]);
                    }); //Fin compuerta evento


                 //Llamada a compuerta And
                $("#compuertaAnd").click(function (evt) {

                    var cAND = new joint.shapes.arbol.CompuertaAND({
                    position: {x: 1000, y: 40},
                    size: {width: 48, height: 48},
                    inPorts: [""],
                    outPorts: [""]
                });
                cAND.Compuerta=new ARBOL.Compuerta(cAND.id,'AND')
                graph.addCells([cAND]);
                console.log(cAND);
                }); //FIN compuertaAnd


                //Llamada a compuerta Or
                $("#compuertaOr").click(function (evt)
                {
                     var cOr = new joint.shapes.arbol.CompuertaOR({
                    position: {x: 1000, y: 40},
                    size: {width: 48, height: 48},
                    inPorts: [""],
                    outPorts: [""]
                });
                    graph.addCells([cOr]);

                }); //FIN compuertaOr

               //Llamada a compuerta Or Exclusiva
                $("#compuertaOrEx").click(function (evt)
                {
                    var cOrExclusiva = new joint.shapes.arbol.CompuertaOREX({
                    position: {x: 1000, y: 40},
                    size: {width: 48, height: 48},
                    inPorts: [""],
                    outPorts: [""]
                });
                    graph.addCells([cOrExclusiva]);

                }); //FIN compuertaOr

                //Llamada a compuerta AND Prioritaria
                $("#compuertaAndPri").click(function (evt)
                {
                    var cAndPrioritaria = new joint.shapes.arbol.CompuertaANDPRI({
                    position: {x: 1000, y: 40},
                    size: {width: 48, height: 48},
                    inPorts: [""],
                    outPorts: [""]
                });
                
                
                
                    graph.addCells([cAndPrioritaria]);

                }); //FIN compuertaAND Prioritaria
                
                 //Llamada a redimencionar Pantalla
                $("#redimenciona").click(function (evt)
                {
                  
                  var heightActual = 0;  
                    $('#paper').css("height", function(index, value){
                      var dato = value.length-2;
                      heightActual = value.substr(0,dato);
                      heightActual = parseInt(heightActual) + 450;
                   });
                  
                  document.getElementById('paper').style.height = heightActual + "px";
                  document.getElementById('v-2').style.height = heightActual + "px";
                });
                //Funciones del menu general del arbol
                 $("#clearArbol").click(function (evt) {
                     evt.preventDefault();
                     graph.clear();
                     paper.model=graph;
                     console.log("borrando","aqui");
                    });
                
                 $("#saveArbol").click(function (evt) {
                  evt.preventDefault();
                  arbolGrafico=JSON.stringify(graph);                  
                  //alert(arbolGrafico);   
                  
                  $.ajax({
                                   url: "http://192.168.0.4:8084/guardararbol/guardaarbolgrafico",
                                   type: "POST",
                                   data: {id:"tree3",nombre:"test",arbol : JSON.stringify(graph)},
                                   dataType: "json", 
                                  success: function(respuesta)                          
                                  {                                  
                                        
                                      alert(respuesta.status);
                                      },
                                     error: function(XMLHttpRequest, textStatus, errorThrown) {
                                        alert("No se encontro el servicio solicitado"+errorThrown);
                                        //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
                                        console.log(XMLHttpRequest.status);
                                        }
                                     ,
                                     
                                 });   
                  
                    });
                
                
                $("#loadArbol").click(function (evt) {
                   evt.preventDefault();
                   
                   $.ajax({
                                   url: "http://localhost:8084/guardararbol/getArbol",
                                   type: "POST",
                                   data: {solicitud : "arbolfallas", id:"tree11"},
                                   dataType: "json", 
                                  success: function(respuesta)                          
                                  {                                  
                                        
                                      graph.fromJSON(respuesta);
                                      
                                      },
                                     error: function(XMLHttpRequest, textStatus, errorThrown) {
                                        alert("No se encontro el servicio solicitado"+errorThrown);
                                        //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
                                        console.log(XMLHttpRequest.status);
                                        }
                                     ,
                                     
                                 });  
                  // JSON.parse(obtieneArbol("")));
                   
                     //graph.fromJSON(JSON.parse(arbolGrafico));
                   console.log("cargando arbol","aqui");
                   
                   
                 graph.fromJSON(JSON.parse(arbolGrafico));
                    });
                
                
                /*Funcion para mostrar el resultado de conectar los puertos entrada/salida*/
                function out(m) 
                {
                    $('#paper-link-out').html(m);
                }
                
              /*Funcion para visualizar el paper a escala*/
              var paperSmall = new joint.dia.Paper({
              el: $('#myholder-small'),
              width: 600,
              height: 200,
              model: graph,
              gridSize: 1
          });
          paperSmall.scale(.4);
          paperSmall.$el.css('pointer-events', 'none');
          }); //FIN DE READY