<%-- 
    Document   : EventoIni
    Created on : 13/09/2015, 09:36:53 PM
    Author     : Norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en" class="no-js">
  <!--<![endif]-->
  <head>
    <title>Evento Iniciador</title>
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
            <h1>Eventos</h1>
            <div class="divider"></div>
            <p>"Conceptos"</p>
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
                        <h3>¿Qué es un evento Iniciador?</h3>
                        <div>
                          <p>
                            El primer paso en el desarrollo de secuencias de accidente, es la definición de  los eventos que pueden 
                       perturbar la operación normal de la planta, requiriendo así la intervención de sistemas para mitigar 
                       esta perturbación y llevar el reactor en caso necesario, a un apagado seguro.
                          </p>
                        </div>
                        <h3>¿Qué es un evento Tope?</h3>
                        <div>
                            <p>
                                El primer paso en el desarrollo de secuencias de accidente, es la definición de  los eventos que pueden 
                       perturbar la operación normal de la planta, requiriendo así la intervención de sistemas para mitigar 
                       esta perturbación y llevar el reactor en caso necesario, a un apagado seguro. El evento  tope es el análisis de falla de un sistema dentro del árbol de eventos.
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
      <style>
          .slick-slide {  height: 50%!important;  }
      </style>
        <%@include file="footer.jsp" %>
    </body>
</html>
