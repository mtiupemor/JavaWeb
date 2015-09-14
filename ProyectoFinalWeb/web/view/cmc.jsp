<%-- 
    Document   : cmc
    Created on : 12/09/2015, 06:06:13 PM
    Author     : Norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="footer.jsp" %>
<!DOCTYPE html>
<html>
    <!--<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>-->
     <head>
        <%@include file="header.jsp" %>
        <meta charset="UTF-8">
        <title>APS</title>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <link rel="shortcut icon" href="favicon.png">
        <script src="../js/jquery-1.11.1.min.js"></script>

        <link rel="stylesheet" href="../css/bootstrap.css">
        <script src="../js/slick.min.js"></script>
        <link rel="stylesheet" href="../css/animate.css">
        <link rel="stylesheet" href="../css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/slick.css">
        <link rel="stylesheet" href="../js/rs-plugin/css/settings.css">

        <link rel="stylesheet" href="../css/freeze.css">
        <!--*  <link rel="stylesheet" href="../css/stilo.css">  -->


        <script type="text/javascript" src="../js/modernizr.custom.32033.js"></script>

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <section id="screens">
            <div class="container">

                <div class="section-heading scrollpoint sp-effect3">
                    <h1>CMC</h1>
                    <div class="divider"></div>
                    <p>Conjuntos Mínimos de Corte </p>
                    <br>

                    <p class = "text-justify">
                        La solución de los árboles de falla implica la solución de los conjuntos mínimos de corte (CMC), 
                        estos de los conjuntos de combinaciones mínimas necesarias de eventos básicos que pueden 
                        ocasionar el evento tope del sistema, los CMC se usan para saber que combinación de 
                        eventos básicos es al que contribuye más a la falla del sistema.
                    </p>                    

                </div>

                <div class="filter scrollpoint sp-effect3">
                    <!--     <a href="javascript:void(0)" class="button js-filter-all active">Todos</a> -->
                    <a href="javascript:void(0)" class="button js-filter-one">Ley Conmutativa</a>
                    <a href="javascript:void(0)" class="button js-filter-two">Ley Asociativa</a>
                    <a href="javascript:void(0)" class="button js-filter-three">Ley Distributiva</a>
                    <a href="javascript:void(0)" class="button js-filter-four">Ley de Absorción</a>
                    <a href="javascript:void(0)" class="button js-filter-five">Complementación</a>
                    <a href="javascript:void(0)" class="button js-filter-six">Teorema de Morgan</a>
                    <a href="javascript:void(0)" class="button js-filter-seven">Ejemplo</a>
                </div>

                <div class="filtering scrollpoint sp-effect5" >
                    <div class="one">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/conmutativa Mat__3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="one"> 
                        <h4>Símbolo Ingeniería</h4>

                        <img src="../img/cmc/conmutativa Ing__3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="two">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/asociativa Mat_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="two">
                        <h4>Símbolo Ingeniería</h4>
                        <img src="../img/cmc/asociativa Ing_3.png" width="250" heigth="250" alt="">   
                    </div>

                    <div class="three">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/distributiva Mat_3.png" width="250" heigth="250" alt="">

                    </div>

                    <div class="three">
                        <h4>Símbolo Ingeniería</h4>
                        <img src="../img/cmc/distributiva Ing_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="four">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/absorcion Mat_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="four">
                        <h4>Símbolo Ingeniería</h4>
                        <img src="../img/cmc/absorcion Ing_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="five">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/complementario Mat_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="five">  
                        <h4>Símbolo Ingeniería</h4>
                        <img src="../img/cmc/complementario Ing_3.png" width="250" heigth="250" alt="">
                    </div>
                    <div class="six">
                        <h4>Símbolo Matemático</h4>
                        <img src="../img/cmc/TMorgan Mat_3.png" width="250" heigth="250" alt="">
                    </div>

                    <div class="six">
                        <h4>Símbolo Ingeniería</h4>
                        <img src="../img/cmc/TMorgan Ing_3.png" width="250" heigth="250" alt="">
                    </div>
                    <div class="seven">
                        <h4>Ejemplo de un CMC </h4>
                        <h4>Supóngase que se tiene el siguiente árbol de fallas: </h4>
                        <img src="../img/cmc/Diagrama CMC_ 2.png" width="350" heigth="350" alt="">
                    </div>  
                    <div class="seven">

                    </div>  
                    <div class="seven">
                        <h4>Haciendo las siguientes sustituciones: </h4>
                        <img src="../img/cmc/01.png" width="100" heigth="100" alt="">
                        <h4>La función del árbol de fallas es la siguiente: </h4>
                        <img src="../img/cmc/02.png" width="100" heigth="100" alt="">
                        <h4>Sustituyendo los valores de E1 y E2 queda de la siguiente manera: </h4> 
                        <img src="../img/cmc/03.png" width="150" heigth="150" alt="">
                        <h4>Resolviendo la multiplicación da: </h4>
                        <img src="../img/cmc/04.png" width="270" heigth="270" alt="">
                        <h4>Sustituyendo para E3: </h4>
                        <img src="../img/cmc/05.png" width="280" heigth="280" alt="">
                        <h4>Por el álgebra de Boole se sabe que C*C=C, entonces la ecuación queda de la manera siguiente:</h4>
                        <img src="../img/cmc/06.png" width="270" heigth="270" alt="">
                        <h4>Por la ley de la absorción tenemos que A*C+B*C+C+E4*C=C</h4>
                        <img src="../img/cmc/07.png" width="150" heigth="150" alt="">
                        <h4>Finalmente, se sustituye para E4 y aplicando la ley de absorción: </h4>
                        <img src="../img/cmc/07.png" width="150" heigth="150" alt="">
                    </div> 
                </div>
        </section>

        <style>
            section#screens .slick-prev:before {
                display:none !important;
            }
            section#screens .slick-next:before {
                display:none !important;
            }
        </style>

        <script src="../js/bootstrap.min.js"></script>

        <script src="../js/placeholdem.min.js"></script>
        <script src="../js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
        <script src="../js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
        <script src="../js/waypoints.min.js"></script>
        <script src="../js/scripts.js"></script>
    </body>
</html>
