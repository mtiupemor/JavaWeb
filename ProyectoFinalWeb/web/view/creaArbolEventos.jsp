<%-- 
    Document   : creaArbolEventos
    Created on : 18/09/2015, 12:53:38 AM
    Author     : Aydeeth
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

    <link rel="stylesheet" href="css/joint.css" />
    <link rel="stylesheet" href="css/arbolEventos.css" />
    <link rel="stylesheet" href="css/compuerta.css" />
    <link rel="stylesheet" href="css/logic.css" />
    <script src="js/joint.js"></script>                
    <script src="js/joint.shapes.arbolEventos.js"></script>
    <script src="js/joint.shapes.logic.js"></script>
    <script src="js/joint.shapes.logic.min.js"></script>

    <script>
      var lon = 200;
      var lat = 400;
      var eventoIniciador;
      var idSistema = "";
      var idExito = "";
      var id1 = "";
      var sistema;
      var exito;
      var frecuencia;
      var exitoFin;
      var xySistema;
      var xyExito;
      var exitosNull = []; //Almacena los exitos que han quedado nulos
      var sistemasNull = [];//Almacena los sistemas que han quedado nulos
      $(document).ready(function () {

        var graph = new joint.dia.Graph;

        var paper = new joint.dia.Paper({
          el: $('#paper'),
          width: 1200,
          height: 600,
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

        //Llamada a evento iniciador
        $("#eventoIniciador").click(function (evt) {

          eventoIniciador = new joint.shapes.arbolEventos.EventoIniciador({
            position: {x: 20, y: 300},
            size: {width: 100, height: 40},
            label: 'I am HTML',
            inPorts: ['in']
          });
          graph.addCells([eventoIniciador]);

          //Agregar titulo del evento iniciador
          var nombreEventoIniciador = new joint.shapes.basic.Rect({
            position: {x: 20, y: 50},
            size: {width: 100, height: 30},
            attrs: {rect: {fill: '#E74C3C'}, text: {text: document.getElementById("txtNombreEventoIniciador").value}}
          });
          graph.addCells([nombreEventoIniciador]);

        }); //FIN evento iniciador

        //Funcion que agrega los elementos con el nombre de los sistemas
        function agregarNombreSistema(lon1, nombre) {
          var nombreSistema = new joint.shapes.basic.Rect({
            position: {x: lon1, y: 30},
            size: {width: 100, height: 30},
            attrs: {rect: {fill: '#E74C3C'}, text: {text: nombre}}
          });
          graph.addCells([nombreSistema]);
        }

        //Llamada a sistema
        $("#sistema").click(function (evt) {

          if (document.getElementById("rbtFalla").checked)
          {
            if (graph.getCell(idSistema) != null) {
              lon = xySistema.x + 150;  //Desplazamiento de x
              lat = xySistema.y + 100;
              crearSistema();
              //graph.getCell(idSistema).embed(sistema);//Agrega el nuevo sistema como hijo del sistema anterior
              conectar(graph.getCell(idSistema), 'in', sistema, 'in');
              exitosNull.push(idExito); //Se agrega el sistema anterior porque queda nulo
            } else {
              crearSistema();
              id1 = sistema.get('id'); //Obtiene el id del primer sistema
              conectar(eventoIniciador, 'in', sistema, 'in')//se conecta el evento iniciador con el primer sistema
              //idExito = exito.get('id'); //Obtiene el id del nuevo exito
              //exitosNull.push(idExito); //Se agrega el sistema anterior porque queda nulo
            }
          } else {
            if (graph.getCell(idSistema) != null) {
              lon = xyExito.x + 150;
              lat = xyExito.y;
              crearSistema();
              //graph.getCell(idExito).embed(sistema);//Agrega el nuevo sistema como hijo del sistema anterior
              conectar(graph.getCell(idExito), 'in', sistema, 'in');
              sistemasNull.push(idSistema); //Se agrega el exito anterior porque ha quedado nulo
            } else {
              alert("Agrega primero un sistema");
              //idSistema = sistema.get('id'); //Obtiene el id del primer sistema
              //conectar(eventoIniciador,'in',sistema,'in')//se conecta el evento iniciador con el primer sistema
            }
          }
          idSistema = sistema.get('id'); //Obtiene el id del nuevo sistema
          idExito = exito.get('id'); //Obtiene el id del nuevo exito
        }); //Fin sistema
        //Llamada a exito  

        //Funcion para crear los sistemas
        function crearSistema() {
          sistema = new joint.shapes.arbolEventos.Sistema({
            position: {x: lon, y: lat},
            size: {width: 100, height: 40},
            inPorts: ['in']
          });
          sistema.type = "sistema";
          xySistema = sistema.get('position');//Obtiene la posición del sistema creado
          graph.addCells([sistema]);
          crearExito(xySistema.x, xySistema.y - 100); //Crea un elemento exito 100 pixeles arriba del sistema
          xyExito = exito.get('position');
          //sistema.embed(exito); //Lo agrega como hijo del sistema creado
          conectar(sistema, 'in', exito, 'in');
          //Agrego la caja con el nombre del sistema
          agregarNombreSistema(lon, document.getElementById("txtNombreSistema").value);
          //Vacio el textbox
          document.getElementById("txtNombreSistema").value = "";
        }

        //Función para crear los elementos exitos (cada que se agrega un sistema se dibuja un cuadro exito
        function crearExito(lon1, lat1) {
          exito = new joint.shapes.arbolEventos.Exito({
            position: {x: lon1, y: (lat1)},
            size: {width: 100, height: 40},
            inPorts: ['in']
          });
          exito.type = "exito";
          graph.addCells([exito]);
        }

        //Función conectar, crea los links entre los elementos
        var conectar = function (source, sourcePort, target, targetPort) {
          var link = new joint.shapes.logic.Wire({
            source: {id: source.id, selector: source.getPortSelector(sourcePort)},
            target: {id: target.id, selector: target.getPortSelector(targetPort)}
          });
          link.addTo(graph).reparent();
        };
        //Termna funcion conectar

        //Función frecuencia, crea los cuadros de frecuencias que contendran los valores calculados
        function crearFrecuencia(lon1, lat1) {
          frecuencia = new joint.shapes.arbolEventos.Frecuencia({
            position: {x: lon1, y: lat1},
            size: {width: 100, height: 40},
            inPorts: ['in']
          });
          graph.addCells([frecuencia]);
        }

        //Funcion crearExitoFin, crea los cuadros de exito para formar bien el arbol
        function crearExitoFin(lon1, lat1) {
          exitoFin = new joint.shapes.arbolEventos.Exito({
            position: {x: lon1, y: (lat1)},
            size: {width: 100, height: 40},
            inPorts: ['in']
          });
          exitoFin.type = "exitoFin";
          graph.addCells([exitoFin]);
        }

        //Función calcular, crea los elementos exitos y frecuencias finales para formar el arbol
        $("#calcular").click(function (evt) {
          //x de el ultimo sistema creado
          var xMax = graph.getCell(sistema.id).get('position').x;
          xMax += 150;
          //crear el elemento frecuencia para el ultimo sistema
          crearFrecuencia(xMax, graph.getCell(sistema.id).get('position').y + 28);
          //Conecta ultimo sistema con su frecuencia
          conectar(sistema, 'in', frecuencia, 'in');
          //crear el elemento exito para el ultimo exito (Solo para dibujar bien el arbol.
          crearExitoFin(xMax, graph.getCell(exito.id).get('position').y);
          //Conectar el ultimo exito
          conectar(exito, 'in', exitoFin, 'in');
          //recorrer exitosNull y conectarlos par dibujar el arbol
          exitosNull.forEach(function (idExitoNull) {
            crearExitoFin(xMax, graph.getCell(idExitoNull).get('position').y);
            conectar(graph.getCell(idExitoNull), 'in', exitoFin, 'in');
          });
          //recorrer sistemasNull, crear sus frecuencias y conectarlos
          sistemasNull.forEach(function (idSistemaNull) {
            crearFrecuencia(xMax, graph.getCell(idSistemaNull).get('position').y + 28);
            conectar(graph.getCell(idSistemaNull), 'in', frecuencia, 'in');
          });
          //Agrego la caja con titulo Frecuencia
          agregarNombreSistema(xMax, "Frecuencia");
        });

        //Esta función se manda a llamar cada que se agrega un elemento, se usa para reubicar los elementos
        graph.on('add', function (sistema) {
          if (sistema.type === "exito") {
            var cont = 0;
            var yExito = graph.getCell(sistema.id).get('position').y; //Se obtiene valor y del nuevo elemento exito
            for (var cont = exitosNull.length - 1; cont >= 0; cont--) {
              if (yExito <= graph.getCell(exitosNull[cont]).get('position').y) {
                yExito = graph.getCell(exitosNull[cont]).get('position').y - yExito + 100;
                graph.getCell(exitosNull[cont]).translate(0, -yExito);
                yExito = graph.getCell(exitosNull[cont]).get('position').y;
              }
            }
          }
          if (sistema.type === "sistema") {
            var cont = 0;
            var ySistema = graph.getCell(sistema.id).get('position').y;
            for (var cont = sistemasNull.length - 1; cont >= 0; cont--) {
              if (ySistema >= graph.getCell(sistemasNull[cont]).get('position').y) {
                ySistema = ySistema - graph.getCell(sistemasNull[cont]).get('position').y + 100;
                graph.getCell(sistemasNull[cont]).translate(0, ySistema);
                ySistema = graph.getCell(sistemasNull[cont]).get('position').y;
              }
            }
          }
        });

        //Función para redimencionar el paper conforme se van creando los elementos
        function redimencionar(yExito) {
          /*if(yExito<=50){
           paper.fitToContent();
           }*/
        }
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
          </div>
          <div class="row">
            <div class="col-md-12">
              <div>  
                
                <table border="1" width="98%" class="cont_Paper">

                  <tr>
                    <td rowspan="4">
                      <div id="paper" ></div>
                    </td>
                  </tr>

                  <tr>
                    <td width="250" height="30%" align="CENTER" >
                      </br> 
                      Nombre: 
                      <input type="text" id="txtNombreEventoIniciador" value="" />
                      </br> </br>
                      <input type="button" id="eventoIniciador" value="Evento iniciador" />
                      </br> </br>
                    </td>
                  </tr>

                  <tr>
                    <td width="250" height="40%" align="CENTER">
                      </br> 
                      Nombre: 
                      <select name="txtNombreSistema" >
                        <optgroup label="Sistemas">

                          <!-- while (unIteradorEmpleado.hasNext()) {
                            EmpleadoDTO unEmpleado = (EmpleadoDTO) unIteradorEmpleado.next(); -->

                          <option value="0.27"> HPCF</option>
                          <option value="0.33"> RCIC</option>
                          <option value="0.12"> RHR</option>
                          <option value="0.25"> ADS</option>
                          <option value="0.7"> ICS</option>
                          <option value="0.48"> GDCS</option>
                          <option value="0.88"> PCCS</option>
                          <option value="0.17"> HPVCSCF</option>

                          <!--  } -->

                        </optgroup>
                      </select>

                      <!-- <input type="text" id="txtNombreSistema" value="" />-->
                      </br> </br>
                      Tipo:  

                      <input id="rbtFalla" type="radio" name="sistema" value="falla" checked> Falla
                      <input id="rbtExito" type="radio" name="sistema" value="exito"> Éxito
                      </br> </br>
                      <input type="button" id="sistema" value="Sistema" />
                      </br> </br>
                    </td>
                  </tr>

                  <tr>
                    <td width="250" height="10%" align="CENTER">
                      </br>
                      <input type="button" id="calcular" value="Calcular"  />

                      </br> </br>
                    </td>
                  </tr>

                </table>

                <div id="paper-link-out"><b></b></div>
                <p></p> 


              </div>
            </div>  
          </div>
        </div>
      </section>
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