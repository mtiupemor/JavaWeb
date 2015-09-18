<%-- 
    Document   : savearbol
    Created on : 16/09/2015, 05:48:15 PM
    Author     : Aydeeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
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
    
    <%//@include file="header_arbol.jsp" %>
    
    <script>

      $(document).ready(function () {

        // CLIO
        //16092015 1812
        //alert($(".inputEvento").val());

      });

      var eT = new ARBOL.EventoTope();
      var arbolGrafico;
      $(document).ready(function () {

        var graph = new joint.dia.Graph;

        var paper = new joint.dia.Paper(
                {
                  el: $('#paper'),
                  width: 1100,
                  height: 600,
                  gridSize: 1,
                  model: graph,
                  snapLinks: true,
                  embeddingMode: true,
                  defaultLink: new joint.shapes.logic.Wire, // Implemento Ramon, CLIO lo agrego
                  validateEmbedding: function (childView, parentView) {
                    return false;//parentView.model instanceof joint.shapes.arbol.Coupled;
                  },
                  validateConnection: function (sourceView, sourceMagnet, targetView, targetMagnet)
                  {
                    /*CLIO,  16092015 1812*/
                    var msj = "";
                    graph.on('change:source change:target', function (link)
                    {
                      var puertoOrigen = link.get('source').port;
                      var origenId = link.get('source').id;
                      var puertoDestino = link.get('target').port;
                      var destinoId = link.get('target').id;
                      console.log("val1 " + origenId);
                      console.log("val2" + destinoId);
                      if (origenId == destinoId)
                      {
                        msj = "Mismo";
                        link.remove();
                      } else
                      {
                        msj = "Diferente";
                        if (typeof origenId != 'undefined' && typeof destinoId != 'undefined')
                        {
                          var partida = puertoOrigen.slice(0, 2);
                          var destino = puertoDestino.slice(0, 2);
                          console.log("puertos: primero>" + partida + " segundo>" + destino);
                          /*ou->ou*/
                          if (partida == "ou" && destino == "ou")
                          {
                            console.log("Primer validacion");
                            link.remove();
                          } else if (partida == "in" && destino == "in")
                          {
                            console.log("Segunda validacion");
                            link.remove();
                          } else if (partida == "in" && destino == "ou")
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
                        '</b> of elemnt with ID <b>' + destinoId + '</b> : ' + '<b>' + msj + '</b>'
                      ].join('');
                      //enviamos cordenadas
                      out(m);
                    });
                    return sourceMagnet != targetMagnet;
                  }//Fin validateConnection, CLIO
                });


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
          cAND.Compuerta = new ARBOL.Compuerta(cAND.id, 'AND')
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
           console.log("borrando","aqui");*/
          location.reload();
        });

        $("#saveArbol").click(function (evt) {
          evt.preventDefault();
          arbolGrafico = JSON.stringify(graph);
          //alert(arbolGrafico);   
          /*
           $.ajax({
           url: "guardaArbol",
           type: "POST",
           data: {arbol : JSON.stringify(graph)},
           dataType: "html", 
           success: function(respuesta)                          
           {                                  
           
           alert(respuesta);
           },
           error: function(XMLHttpRequest, textStatus, errorThrown) {
           alert("No se encontro el servicio solicitado"+errorThrown);
           //Se puede obtener informacion útil inspecionando el Objeto XMLHttpRequest
           console.log(XMLHttpRequest.status);
           }
           ,
           
           });   
           */
        });


        $("#loadArbol").click(function (evt) {
          evt.preventDefault();
          /*
           $.ajax({
           url: "getArbol",
           type: "POST",
           data: {solicitud : "arbolfallas"},
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
           
           });   */
          // JSON.parse(obtieneArbol("")));

          graph.fromJSON(JSON.parse(arbolGrafico));
          console.log("cargando arbol", "aqui");


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


      }); //FIN DE READY


    </script>
  </head>
  <body>
   <!-- <br><br> -->

    <table border="1">
      <tr>
        <td rowspan="8">
          <div id="paper" >
          </div>

        </td>
      </tr>

      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="eventoTope" title="Agregar Evento Tope" src="../images/eventoTope.png"  width="100" height="100"/>
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="evento"  title="Agregar Evento" src="../images/evento.png" width="100" height="100" />
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="compuertaAnd" title="Agregar Compuerta AND" src="../images/and.png" width="25" height="30" />
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="compuertaOr" title="Agregar Compuerta OR" src="../images/or.png" width="25" height="30" />
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="compuertaOrEx"  title="Agregar Compuerta OR Exclusiva" src="../images/orEx.png" width="25" height="30"/>
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="compuertaAndPri" title="Agregar Compuerta AND Prioritaria" src="../images/andPri.png" width="25" height="30" />
        </td>
      </tr>
      <tr>
        <td width="250" align="CENTER">
          <input type="image" id="redimensiona" title="Redimensiona el área de dibujo" src="../images/redimensionar.png"  width="35" height="35" />
        </td>
      </tr>
    </table>
  <center>
    </br>
    <!--
    <input type="button" id="clearArbol" value="Limpiar área"/>
    <input type="button" id="saveArbol" value="Guardar árbol"/>
    <input type="button" id="loadArbol" value="Cargar un árbol"/>
    -->
    <table>
      <tr>
        <td width="90" height="70">
     <input type="image" id="clearArbol" title="Limpiar área" src="../img/freeze/limpia.png"  width="50" height="50" />
        </td>
          <td width="90" height="70">
     <input type="image" id="saveArbol" title="Guardar árbol" src="../img/freeze/guarda.png"  width="50" height="50" />
      </td>
        <td width="90" height="70">
       <input type="image" id="loadArbol" title="Cargar un árbol" src="../img/freeze/recarga.png"  width="50" height="50" />
      </td>
      </tr>
    </table>
  </center>
  <!--Mostrar conexiones validas,CLIO, 16092015 1830-->
  <div id="paper-link-out"><b></b></div>
    </br>

  <%//@include file="../view/footer.jsp" %>
</body>
</html>
