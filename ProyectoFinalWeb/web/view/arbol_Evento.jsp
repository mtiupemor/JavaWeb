<%-- 
    Document   : index
    Created on : 11/09/2015, 07:36:29 PM
    Author     : Maria Maldonado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
  <%@include file="header.jsp" %>
  <link rel="stylesheet" href="../css/estilos.css">
</header>
<div class="wrapper">
  <section id="reviews">
    <div class="container">
      <div class="section-heading inverse scrollpoint sp-effect3">
        <h1>Árbol de Eventos</h1>
        <div class="divider"></div>
        <p>"Conociendo las técnicas empleadas en el APS"</p>
      </div>
      <div class="row">
        <div class="col-md-10 col-md-push-1 scrollpoint sp-effect3">
          <div class="review-filtering">
            <div class="review">
              <div class="row">
                <div class="col-md-2">
                  <div class="review-person">
                    <img src="../img/bookmark.png" alt="" class="img-responsive">
                  </div>
                </div>
                <div class="col-md-10">
                  <div class="review-comment">
                    <h3>Concepto</h3>
                    <div>
                      <p>
                        Los árboles de eventos es un método cuya función es la de modelar, a partir de un diagrama, las posibles secuencias de accidentes derivadas de un <abbr><a href="#">evento iniciador</a></abbr>.
                      </p
                    </div>
                    <div>
                      <h3>Funcionamiento</h3>
                      <p>
                        La técnica de análisis por árboles de eventos consiste en evaluar las consecuencias de posibles accidentes resultantes de la falla de un sistema, equipo, error humano, las conclusiones de los árboles de eventos son consecuencias de accidentes, es decir, conjuntos de eventos cronológicos de fallas o errores que definen un determinado accidente, se evalúan las funciones de seguridad y se obtienen los estados finales del accidente.
                      </p>
                    </div>
                  </div>
                </div><!--review comment-->
              </div>
            </div>
          </div>

          <div class="review rollitin">
            <div class="row">
              <div class="col-md-2">
                <div class="review-person">
                  <img src="../img/bookmark.png" alt="" class="img-responsive">
                </div>
              </div>
              <div class="col-md-10">
                <div class="review-comment">
                  <div>
                    <p>Este método parte de:</p>
                    <ul class="lista">
                      <li>
                        Proponer  e identificar los eventos iniciadores. Partiendo del evento iniciador, se plantean dos bifurcaciones: la parte superior refleja el éxito del sistema y la parte superior representa la falla del mismo.
                      </li>
                      <li>
                        Identificar los sistemas que pueden actuar para mitigar los daños que pueden causar el evento iniciador propuesto.
                      </li>
                      <li>
                        Al tener identificados los sistemas que intervienen después del evento iniciador, hay que ordenarlos de manera secuencial. Durante este proceso se debe derivar cuáles sistemas actúan y cuáles no.
                      </li>
                      <li>
                        Se obtienen las secuencias que derivan en un accidente.
                      </li>
                      <li>
                        Para llevar a cabo la cuantificación de las secuencias de accidente, se desarrollan los  <a href="arbol_Falla.jsp">árboles de fallas</a> de cada sistema de mitigación que se encuentra en los encabezados de cada árbol de eventos.
                      </li>
                    </ul>

                  </div>
                </div>
              </div>
            </div>
          </div>  
        </div>
      </div>
    </div>
  </section>
  <section id="features" >
    <div class="container">
      <div class="section-heading scrollpoint sp-effect3">
        <h2>Ejemplo: Árbol de Eventos</h2>
        <div class="divider"></div>
      </div>
      <div class="row">
        <div class="col-md-4 col-sm-4 scrollpoint sp-effect1">
       
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa fa-exclamation-triangle fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">1. Búsqueda de eventos iniciadores.</h3>
            </div>
          </div>
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa fa-check fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">2. Enlistar los sistemas que intervienen para mitigar el evento iniciador.</h3>
            </div>
          </div>
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa  fa-sitemap fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">3. Agrupar los eventos iniciadores.</h3>
            </div>
          </div>
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa fa-pagelines fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">4. Realizar el árbol de eventos para cada grupo.</h3>
            </div>
          </div>
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa fa-chain-broken fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">5.  Obtener los estados finales.</h3>
            </div>
          </div>
          <div class="media media-left feature">
            <a class="pull-left" href="#">
              <i class="fa fa-chain-broken fa-2x"></i>
            </a>
            <div class="media-body">
              <h3 class="media-heading">6. Calcular las frecuencias de las secuencias de accidente.</h3>
            </div>
          </div>
        </div>
        <div class="col-md-8 col-sm-8 scrollpoint sp-effect3" >

          <div class="form-group " >

            <img src="../img/freeze/diagrama_aevento.png" 
                 class="img-responsive" 
                 alt=""
                 data-bgfit="cover" 
                 data-bgposition="left top" 
                 data-bgrepeat="no-repeat" 
                 style="width: 100%; height:auto;">

          </div>


          <div class="info-diagrama">
            <h5>Diagrama de Árbol de Eventos</h5>
            <p>
              En el diagrama de árboles de eventos se puede observar  en la parte superior  el evento iniciador, así como los sistemas que participan para mitigar dicho evento.
              Cada sistema está compuesto por dos bifurcaciones, las cuales representan el éxito (parte superior) y falla del sistema (parte inferior).
            </p>
            <p>
              Asimismo, se pueden observar las diferentes secuencias posibles de accidentes (SA1 y SA2). Para obtener la frecuencia simplificada de cada secuencia de accidente, se tiene que multiplicar la frecuencia del evento iniciador por la probabilidad de falla de cada uno de los sistemas involucrados en la secuencia de accidente. Sin embargo, la manera de cuantificar las secuencias es resolver todas las combinaciones de los conjuntos mínimos de corte.

            </p>
          </div>
        </div>
      </div>
    </div>
  </section>
  <%@include file="footer.jsp" %>
  <script>
    $(document).ready(function () {

      appMaster.preLoader();
      $('.item').popover({
        placement: "bottom"
      }); //popover
    });
  </script>

</body>

</html>


