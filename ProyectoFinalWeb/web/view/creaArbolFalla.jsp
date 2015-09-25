<%-- 
    Document   : savearbol
    Created on : 16/09/2015, 05:48:15 PM
    Author     : Oscar Escalona
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="shortcut icon" href="favicon.png">
    <%@include file="head_arbol.jsp" %>  
    <title>Crea tu árbol de fallas</title>
    <link rel="stylesheet" href="../css/joint.css" />
    <link rel="stylesheet" href="../css/arbol.css" />
    <link rel="stylesheet" href="../css/compuerta.css" />
    <link rel="stylesheet" href="../css/logic.css" /> <!-- Agrego CLIO-->
    <script src="../js/joint.js"></script>
    <script src="../js/joint.shapes.arbol.js"></script>
    <script src="../js/arbollogica.js"></script>
    <script src="../js/controlArbol.js"></script>
    <script src="../js/joint.shapes.logic.js"></script>  <!-- Agrego CLIO-->
    <script src="../js/joint.shapes.logic.min.js"></script> <!-- Agrego CLIO-->
    <script>

      $(document).ready(function () {
        // CLIO
        //16092015 1812
        //alert($(".inputEvento").val());

      });
      var arbolesFalla = Array();
      var arbolFalla = new ARBOL.ArbolFalla();
      $(document).ready(function () {
        graph = new joint.dia.Graph;
        /*graph.on('change', function(link){
         //console.log("En evento graph on",link);                    
         }
         );*/
        var paper = new joint.dia.Paper(
                {
                  el: $('#paper'),
                  width: 1000,
                  height: 600,
                  gridSize: 1,
                  model: graph,
                  defaultLink: new joint.shapes.arbol.Link,
                  snapLinks: true,
                  linkPinning: false,
                  restrictTranslate: {x: 0, y: 0, width: 1100, height: 600},
                  validateConnection: function (vs, ms, vt, mt, e, vl) {
                    if (vs != vt)
                    {
                      if (e === 'target') {
                        ////console.log("port source",vs);
                        ////console.log("port source");
                        ////console.log("vt",vt);
                        ////console.log("vs",vs);
                        //console.log("tipo de puerto origen", vs instanceof joint.dia.ElementView);
                        var puertoOrigen = V(ms || !ms.getAttribute('class') || mt.getAttribute('class').indexOf('output')).attr('port').slice(0, 2);
                        //console.log("tipo de puerto origen", puertoOrigen);

                        //vs.model.set('input .name',"Gorge");
                        ////console.log(vs.model);
                        if (ms != mt) {
                          //var source = graph.getCell();
                          //source.attr('.outPorts circle/magnet', 'passive')
                          if (puertoOrigen == 'ou')
                          {
                            //console.log("out a in", vt, vs);
                            if (((typeof vt.model.Evento) != 'undefined') && ((typeof vs.model.Compuerta) != 'undefined')) { //cuando se une de out compuerta -> in Evento
                              if (!(vt.model.Evento.hasHijoCompuerta(vs.model.Compuerta))) {
                                vt.model.Evento.setHijo(vs.model.Compuerta);
                                //console.log("Agregado Compuerta", vt.model.Evento.getHijo());
                                // alert("Se agrego la compuerta como hijo de Evento");
                                return true;
                              }
                            } else if (((typeof vs.model.Evento) != 'undefined') && ((typeof vt.model.Compuerta) != 'undefined')) { //se une out Evento-> int Compuerta
                              if (!(vt.model.Compuerta.hasHijoEvento(vs.model.Evento))) {
                                vt.model.Compuerta.setHijoEvento(vs.model.Evento);
                                //console.log("Agregado Evento", vt.model.Compuerta.getTipo(), vt.model.Compuerta.getValor());
                                return true; //console.log("Lo tengo como hijo");//console.log("Compuerta", vt.model.Compuerta, "Compuerta \n", vt.model.Compuerta.hasHijoEvento(vs.model.Evento));
                              
                            }
                        }else if (((typeof vs.model.Compuerta) != 'undefined') && ((typeof vt.model.EventoTope) != 'undefined')) {
                              if (!(vt.model.EventoTope.hasHijo(vs.model.Compuerta))) {
                                vt.model.EventoTope.setHijo(vs.model.Compuerta);
                                //console.log("Agregado Compuerta a evento Tope", vs.model.Compuerta.getTipo(), vs.model.Compuerta.getValor());
                                vs.model.set('input', vs.model.Compuerta.getValor());
                                return true;
                              }

                            }



                            /*if(typeof vs.model.Evento!='undefined'&&typeof vt.model.Compuerta!='undefined'){
                             if(!(vs.model.Evento.hasHijoCompuerta(vt.model.Compuerta))){
                             //console.log("Agregando Hijo compuerta!!");
                             vs.model.Evento.setHijo(vt.model.Compuerta);
                             }
                             //console.log("Evento",vs.model.Evento,"Evento \n",vs.model.Evento.hasHijoCompuerta(vt.model.Compuerta));
                             }*/
                          } else if (puertoOrigen == 'in')
                          {
                            //console.log("en in....");
                            //console.log("in a out VS", vs.model);
                            //console.log("in a out VT", vt.model);
                            if (((typeof vt.model.Compuerta) != 'undefined') && ((typeof vs.model.EventoTope) != 'undefined'))
                            {
                              //console.log("ëntrando");
                              if (!(vs.model.EventoTope.hasHijo(vt.model.Compuerta)))
                              {
                                vs.model.EventoTope.setHijo(vt.model.Compuerta);
                                //console.log("EventoTope", vs.model.EventoTope);
                                //vs.model.set('input',vs.model.Compuerta.getValor());
                                return true;
                              }

                            } else if (((typeof vs.model.Compuerta) != 'undefined') && ((typeof vt.model.EventoTope) != 'undefined'))
                            {
                              if (!(vt.model.EventoTope.hasHijo(vs.model.Compuerta)))
                              {
                                vt.model.EventoTope.setHijo(vs.model.Compuerta);
                                //console.log("EventoTope", vt.model.EventoTope);
                                //vs.model.set('input',vs.model.Compuerta.getValor());
                                return true;
                              }

                            } else
                            if (((typeof vt.model.Evento) != 'undefined') && ((typeof vs.model.Compuerta) != 'undefined'))
                            {
                              ////console.log("hazuer");
                              //cuando se une de in evento -> out compuerta
                              if (!(vs.model.Compuerta.hasHijoEvento(vt.model.Evento)))
                              {
                                vs.model.Compuerta.setHijoEvento(vt.model.Evento);
                                //console.log("See Agregado Evento", vt.model.Evento);
                                return true;
                              }
                            }

                            /*if(((typeof vs.model.Compuerta)!='undefined')&&((typeof vt.model.EventoTope)!='undefined')){
                             if(!(vt.model.EventoTope.hasHijo(vs.model.Compuerta))){
                             vt.model.EventoTope.setHijo(vs.model.Compuerta);
                             //console.log("Agregado Compuerta a evento Tope",vs.model.Compuerta.getTipo(),vs.model.Compuerta.getValor());
                             vs.model.set('input',vs.model.Compuerta.getValor());
                             return true;
                             }*/
                          }

                        }
                        ////console.log("test",typeof vs.model.Evento!='undefined',typeof vt.model.Compuerta!='undefined',vs.model.Evento.hasHijoCompuerta(vt.model.Compuerta));
                        // target requires an input port to connect

                        /*
                         
                         
                         
                         }
                         */
                        /*if (!mt || !mt.getAttribute('class') || mt.getAttribute('class').indexOf('input') < 0) 
                         return false;*/



                      } else { // e === 'source'
                        //console.log("es source");
                        // source requires an output port to connect
                        /*return ms && ms.getAttribute('class') && ms.getAttribute('class').indexOf('output') >= 0; */
                      }
                    }
                    return true;
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
         //console.log("Evento no se puede unir con evento");
         }else{
         //console.log("Entra");
         var link = new joint.shapes.arbol.Link({
         source: {id: source.id, selector: source.getPortSelector(sourcePort)},
         target: {id: target.id, selector: target.getPortSelector(targetPort)}
         });
         link.addTo(graph).reparent();
         }
         };*/



        /*
         eventoIniciador.el=new ARBOL.EventoIniciador;
         //console.log(eventoIniciador);
         */


        /* Metodo para asignar ID del evento*/
        //No eliminar
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
        paper.on("cell:pointerdown", function (cellview, evt, x, y) {
          //console.log("pointer down on cell ", cellview.model.id, " pos: ", x, ",", y);
        });

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
          if (typeof arbolFalla.getEventoTope() != 'undefined') {
            var eventoTope = new joint.shapes.arbol.Evento({
              position: {x: 750, y: 30},
              size: {width: 100, height: 80},
              label: 'I am HTML',
              inPorts: ['in'],
            });

            eventoTope.EventoTope = new ARBOL.EventoTope(eventoTope.id, "Evento Tope");
            arbolFalla.setEventoTope(eventoTope.EventoTope);
            graph.addCells([eventoTope]);
          } else {
            var respuesta = confirm("Desea remplazar el Evento Tope Original?");
            if (respuesta) {
              var eventoTope = new joint.shapes.arbol.Evento({
                position: {x: 750, y: 30},
                size: {width: 100, height: 80},
                label: 'I am HTML',
                inPorts: ['in'],
              });

              eventoTope.EventoTope = new ARBOL.EventoTope(eventoTope.id, "Evento Tope");
              arbolFalla.setEventoTope(eventoTope.EventoTope);

            }

          }
        }); //FIN compuertaTope

        //Llamada a evento
        $("#evento").click(function (evt) {
          var evento = new joint.shapes.arbol.Evento({
            position: {x: 750, y: 30},
            size: {width: 100, height: 80},
            label: 'I am HTML',
            inPorts: ['in'],
            outPorts: ['out']
          });
          evento.Evento = new ARBOL.Evento(evento.id, 'Evento 1');
          evento.Evento.setValor(0.2);
          evento.Update = function (object) {
            //console.log("Prueba dentro de Update");
            //console.log(graph.getCell(object.id));
            ////console.log(paper.findView('.evento>.name'));
          }
          //console.log(evento);
          graph.addCells([evento]);
          evento.Update(evento);
        }); //Fin compuerta evento


        //Llamada a compuerta And
        $("#compuertaAnd").click(function (evt) {

          var cAND = new joint.shapes.arbol.CompuertaAND({
            position: {x: 800, y: 40},
            size: {width: 48, height: 48},
            inPorts: [""],
            outPorts: [""]
          });
          cAND.Compuerta = new ARBOL.Compuerta(cAND.id, 'AND');
          graph.addCells([cAND]);
          //console.log(cAND);
        }); //FIN compuertaAnd


        //Llamada a compuerta Or
        $("#compuertaOr").click(function (evt)
        {
          var cOr = new joint.shapes.arbol.CompuertaOR({
            position: {x: 800, y: 40},
            size: {width: 48, height: 48},
            inPorts: [""],
            outPorts: [""]
          });
          cOr.Compuerta = new ARBOL.Compuerta(cOr.id, 'OR');
          graph.addCells([cOr]);

        }); //FIN compuertaOr

        //Llamada a compuerta Or Exclusiva
        $("#compuertaOrEx").click(function (evt)
        {
          var cOrExclusiva = new joint.shapes.arbol.CompuertaOREX({
            position: {x: 800, y: 40},
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
            position: {x: 800, y: 40},
            size: {width: 48, height: 48},
            inPorts: [""],
            outPorts: [""]
          });
          graph.addCells([cAndPrioritaria]);

        }); //FIN compuertaAND Prioritaria


        /*Funcion para mostrar el resultado de conectar los puertos entrada/salida
         CLIO
         16092015 1828
         */
        function out(m)
        {
          $('#paper-link-out').html(m);
        }//Fin out, CLIO
        var eventoTope = new joint.shapes.arbol.Evento({
          position: {x: 450, y: 30},
          size: {width: 100, height: 80},
          label: 'I am HTML',
          inPorts: ['in'],
        });

        eventoTope.EventoTope = new ARBOL.EventoTope(eventoTope.id, "Evento Tope");
        arbolFalla.setEventoTope(eventoTope.EventoTope);

        var evento = new joint.shapes.arbol.Evento({
          position: {x: 300, y: 350},
          size: {width: 100, height: 80},
          label: 'I am HTML',
          inPorts: ['in'],
          outPorts: ['out']
        });
        evento.Evento = new ARBOL.Evento(evento.id, 'Evento 1');        
        
        var evento1 = new joint.shapes.arbol.Evento({
          position: {x: 600, y: 350},
          size: {width: 100, height: 80},
          label: 'I am HTML',
          inPorts: ['in'],
          outPorts: ['out'],
          '.value': 0.2
        });
        
        evento1.Evento = new ARBOL.Evento(evento1.id, 'Evento 1');        


        var cAND = new joint.shapes.arbol.CompuertaAND({
          position: {x: 500, y: 200},
          size: {width: 48, height: 48},
          inPorts: [""],
          outPorts: [""]
        });
        cAND.Compuerta = new ARBOL.Compuerta(cAND.id, 'AND');


        graph.addCells([eventoTope, evento, evento1, cAND]);
        //console.log("evento 1", evento1);
        //console.log('calss', paper.findView(graph.getCell(evento1.id)))


        paper.on("cell:mouseover", function (cellView, el) {
          ////console.log("aqui en paper",cellView,cellView.$box.find('.name').val("Oscar"),el);   
          var x = 0;
          for (var x = 0, l = graph.getElements(); x < l.length; x++) {
            //console.log("elemento:", x, l[x]);
            ////console.log("Evento", eventoTope);
            //console.log("Vista", l[x].findView(paper));
            console.log("Actualizando a box");
            l[x].findView(paper).updateBox();
          }
        });

         $("#redimensiona").click(function (evt)
          {

            var heightActual = 0;
            $('#paper').css("height", function (index, value) {
              var dato = value.length - 2;
              heightActual = value.substr(0, dato);
              heightActual = parseInt(heightActual) + 450;
            });

            document.getElementById('paper').style.height = heightActual + "px";
            document.getElementById('v-2').style.height = heightActual + "px";
          });


        //Funciones del menu general del arbol
        $("#clearArbol").click(function (evt) {
          /*evt.preventDefault();
           graph.clear();
           paper.model=graph;
           //console.log("borrando","aqui");*/

        
          location.reload();
        });

        $("#saveArbol").click(function (evt) {
          evt.preventDefault();
          arbolFalla.setArbolGrafico(JSON.stringify(graph));
          //var arbol=new ARBOL.Falla();
          //arbol.nombre=arbolFalla.getNombre();
          //arbol.valor=arbolFalla.getValor();
          //arbolesFalla.push(arbol);           
          //console.log(arbolFalla.getNombre());
          ////console.log(arbolFalla.toObjctGraphicJSON());
          //console.log(arbolFalla.toObjctLogicJSON());

          $.ajax({
            url: "../guardaarbollogico",
            type: "POST",
            data: {nombre: arbolFalla.getNombre(), arbol: arbolFalla.toObjctLogicJSON()},
            dataType: "json",
            success: function (respuesta)
            {
              if (respuesta.status == '1') {
                alert("Arbol Logico Guardado");
                $.ajax({
                  url: "../guardaarbolgrafico",
                  type: "POST",
                  data: {id: arbolFalla.getNombre(), nombre: arbolFalla.getNombre(), arbol: arbolFalla.getArbolGrafico()},
                  dataType: "json",
                  success: function (respuesta)
                  {

                    if (respuesta.status == '1') {
                      alert("Arbol Grafico Guardado");
                    }
                  },
                  error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert("No se encontro el servicio solicitado" + errorThrown);
                    //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
                    //console.log(XMLHttpRequest.status);
                  }
                });

              }
              else {
                alert("Arbol logico no guardado");
              }

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
              alert("No se encontro el servicio solicitado" + errorThrown);
              //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
              //console.log(XMLHttpRequest.status);
            }
          });
          //Funcion que redimensiona el area de trabajo       
          $("#redimensiona").click(function (evt) {
            var heightActual = 0;
            $('#paper').css("height", function (index, value) {
              var dato = value.length - 2;
              heightActual = value.substr(0, dato);
              heightActual = parseInt(heightActual) + 450;
            });

            document.getElementById('paper').style.height = heightActual + "px";
            document.getElementById('v-2').style.height = heightActual + "px";
          });



        });


        $("#loadArbol").click(function (evt) {
          evt.preventDefault();
          $.ajax({
            url: "getArbol",
            type: "POST",
            data: {consulta: "all"},
            dataType: "json",
            success: function (respuesta)
            {
              $.each(contenidoDelArchivo.estudiantes, function (posicion, arbol) {
                //console.log(' >', 'Posición: ' + posicion, +" " + arbol[0] + " " + " valor" + arbol[1]                      );
              });

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
              alert("No se encontro el servicio solicitado" + errorThrown);
              //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
              //console.log(XMLHttpRequest.status);
            }
            ,
          });
          // JSON.parse(obtieneArbol("")));

          graph.fromJSON(JSON.parse(arbolGrafico));
          //console.log("cargando arbol", "aqui");


          graph.fromJSON(JSON.parse(arbolGrafico));
        });



        /*Funcion para mostrar el resultado de conectar los puertos entrada/salida
         CLIO
         16092015 1828
         */
        function out(m)
        {
          $('#paper-link-out').html(m);
        }//Fin out, CLIO

        /*****funcion dato modal********/
        $("#SaveTitle").on("click", function () {
          var titulo_arbol = $("#nameArbol").val();
          $("#titulo").html(titulo_arbol);
          arbolFalla.setNombre(titulo_arbol);
          //console.log("Poniendo Nombre", titulo_arbol, arbolFalla.getNombre());
        });
        /************************/
      }); //FIN DE READY


    </script>

  </head>
  <body>
    <header>
      <%@include file="header_arbol.jsp" %> 
    </header>
    <div class="wrapper">
      <section id="informacion">
        <div class="container">
          <br/><br/><br/>
          <div class="section-heading">
            <h2>Crea tu árbol de fallas</h2>
            <div class="divider"></div>
            <br>
            <br>
            <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
              Nombra tu árbol
            </button>
            <a href="
               http://www.pdfspot.com/export_to_pdf/?pdf_page_size=A4&pdf_orientation=Landscape" class="btn btn-primary btn-lg">Export to PDF</a>
          </div>
          <div id="titulo"></div>      
          <div class="row">
            <div class="col-md-12">               
              <div class="izquierdo" border="1">
                <div id="paper" ></div>
              </div>

              <div class="derecho">   
                <input type="image" id="eventoTope"   title="Agregar Evento Tope" src="../images/eventoTope.png"  width="100" height="100"/><br><hr>
                <input type="image" id="evento"  title="Agregar Evento" src="../images/evento.png" width="100" height="100" /><br> <hr>        
                <input type="image" id="compuertaAnd" title="Agregar Compuerta AND" src="../images/and.png" width="25" height="30" /><br><hr>
                <input type="image" id="compuertaOr" title="Agregar Compuerta OR" src="../images/or.png" width="25" height="30" /><br><hr>
                <!--<input type="image" id="compuertaOrEx"  title="Agregar Compuerta OR Exclusiva" src="../images/orEx.png" width="25" height="30"/><br><hr>
                <input type="image" id="compuertaAndPri" title="Agregar Compuerta AND Prioritaria" src="../images/andPri.png" width="25" height="30" /><br><hr>-->    
                <input type="image" id="redimensiona" title="Redimensiona el área de dibujo" src="../images/redimensionar.png"  width="35" height="35" /><br><hr>
              </div>
              <div class="footer">
                <center>
                  <input type="image" id="clearArbol" title="Limpiar área" src="../img/freeze/limpia.png"  width="50" height="50" />
                  <input type="image" id="saveArbol" title="Guardar árbol" src="../img/freeze/guarda.png"  width="50" height="50" />
                  <input type="image" id="loadArbol" title="Cargar un árbol" src="../img/freeze/recarga.png"  width="50" height="50" />
                </center>
              </div>
              <!--Mostrar conexiones validas,CLIO, 16092015 1830-->
              <div id="paper-link-out"></b></div> 
            </div>  
          </div>
        </div>
      </section>
      <!-- Modal -->
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
