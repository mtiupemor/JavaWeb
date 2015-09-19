<%-- 
    Document   : cmc
    Created on : 12/09/2015, 06:06:13 PM
    Author     : 7MTI 
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en" class="no-js">

  <head>
    <title>CMC</title>
    <meta charset="UTF-8">
  </head>

  <body>
    <header>
      <%@include file="header.jsp" %>
      <link rel="stylesheet" href="../css/estilos.css">
    </header>
    <section id="reviews">
      <div class="container">
        <div class="section-heading inverse scrollpoint sp-effect3">
          <br/><br/><br/><br/><br/>
          <h1>CMC</h1>
          <div class="divider"></div>
          <p>"Conjuntos Mínimos de Corte"</p>
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
                          La solución de los árboles de falla implica la solución de los conjuntos mínimos de corte (CMC), 
                          estos son conjuntos de combinaciones mínimas necesarias de eventos básicos que pueden 
                          ocasionar el evento tope del sistema, los CMC se usan para saber que combinación de 
                          eventos básicos es al que contribuye más a la falla del sistema.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </div> 
            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="screens">
      <div class="container">
        <div class="section-heading inverse scrollpoint sp-effect3">
          <br/><br/><br/>
          <h2>Reglas del Álgebra Booleana</h2>
          <div class="divider"></div>
          <p>"Conjuntos Mínimos de Corte"</p>
        </div>
        <div class="row">
          <div class="col-sm-3  scrollpoint sp-effect3">
            <ul class="m_simbolos">
              <li class="add" data-capa="conmutativa">Ley Conmutativa</li>
              <li  data-capa="asociativa">Ley Asociativa</li>
              <li  data-capa="distributiva">Ley Distributiva</li>
              <li  data-capa="absorcion">Ley de Absorción</li>
              <li  data-capa="complementacion">Complementación</li>
              <li  data-capa="morgan">Teorema de Morgan</li>
              <li><a href="#features">Ejemplo</a></li>
            </ul>
          </div>

          <div class="col-sm-9 scrollpoint sp-effect3" id="conte">
            <div class="base" id="conmutativa">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/conmutativaMat__3.png"  alt="">
              </div>
              <div class="itemLey" >
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/conmutativaIng_3.png" alt="">
              </div>
            </div>
            <div class="base" id="asociativa">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/asociativaIng_3.png"  alt="">
              </div>
              <div class="itemLey">
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/asociativaMat_3.png" alt="">   
              </div>
            </div>
            <div class="base" id="distributiva">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/distributivaMat_3.png" alt="">
              </div>
              <div class="itemLey" >
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/distributivaIng_3.png"  alt="">  
              </div>
            </div>
            <div class="base" id="absorcion">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/absorcionMat_3.png"  alt="">
              </div>
              <div class="itemLey" >
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/absorcionIng_3.png"  alt="">  
              </div>
            </div>
            <div class="base" id="complementacion">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/complementarioMat_3.png"  alt="">
              </div>
              <div class="itemLey" >
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/complementarioIng_3.png"  alt=""> 
              </div>
            </div>
            <div class="base" id="morgan">
              <div class="itemLey" >
                <h4>Símbolo Matemático</h4>
                <img src="../img/cmc/TMorganMat_3.png"  alt="">
              </div>
              <div class="itemLey">
                <h4>Símbolo Ingeniería</h4>
                <img src="../img/cmc/TMorganIng_3.png"  alt=""> 
              </div>
            </div>
          </div>
        </div><!-- row-->
      </div>
    </section>
    <section id="features" >
      <div class="container">
        <div class="section-heading scrollpoint sp-effect3">
          <br/><br/>
          <h2>Ejemplo: CMC</h2>
          <div class="divider"></div>
        </div>
        <div class="row">
          <div class="col-md-4 col-sm-4 scrollpoint sp-effect1">
            <h4>Supóngase que se tiene el siguiente árbol de fallas: </h4>
            <div class="form-group " >

              <img src="../img/cmc/ejemploDiagramaCMC.png" 
                   class="img-responsive" 
                   alt=""
                   data-bgfit="cover" 
                   data-bgposition="left top" 
                   data-bgrepeat="no-repeat" 
                   style="width: 80%; height:auto;">

            </div>
          </div>

          <div class="col-md-8 col-sm-8 scrollpoint sp-effect3">
            <div class="info-diagrama">
              <p>Haciendo las siguientes sustituciones: </p>
              <img src="../img/cmc/01.png" width="80" alt="">
              <p>La función del árbol de fallas es la siguiente: </p>
              <img src="../img/cmc/02.png" width="80" alt="">
              <p>Sustituyendo los valores de E1 y E2 queda de la siguiente manera: </p> 
              <img src="../img/cmc/03.png" width="190" alt="">
              <p>Resolviendo la multiplicación da: </p>
              <img src="../img/cmc/04.png" width="290" alt="">
              <p>Sustituyendo para E3: </p>
              <img src="../img/cmc/05.png" width="300" alt="">
              <p>Por el álgebra de Boole se sabe que C*C=C, entonces la ecuación queda de la manera siguiente:</p>
              <img src="../img/cmc/06.png" width="300" alt="">
              <p>Por la ley de la absorción tenemos que A*C+B*C+C+E4*C=C</p>
              <img src="../img/cmc/07.png" width="150" alt="">
              <p>Finalmente, se sustituye para E4 y aplicando la ley de absorción: </p>
              <img src="../img/cmc/08.png" width="250" alt="">
            </div>

          </div>
        </div>
      </div>
    </section>
      <style>
          .slick-slide {  height: 30%!important;  }
      </style>
    <%@include file="footer.jsp" %>
    <script>
      $(document).ready(function () {

        var inicio = $(".m_simbolos li[class='add']").attr('data-capa');
        $("#" + inicio).show();

        $(".m_simbolos li").on('click', function () {
          var capa = $(this).attr('data-capa');

          $('.m_simbolos li').removeClass('add');
          $(this).addClass('add');

          $("div #" + capa).toggle();
          $("#conte .base[id != " + capa + "]").hide();

        });

      });
    </script>
  </body>
</html>
