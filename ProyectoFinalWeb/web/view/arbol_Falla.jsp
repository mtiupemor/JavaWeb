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
                    <h1>Árboles de Fallas</h1>
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
                                                   Los árboles de falla son diagramas lógicos que exhiben el estado de un sistema (evento tope) en los términos de los estados de sus componentes (eventos básicos).
                                                </p>
                                            
                                            </div>
                                            <h3>Funcionamiento</h3>
                                            <div>
                                                <p>
                                                    El Análisis por Árboles de Fallas, es una técnica para calcular la probabilidad de falla de un sistema y proporciona un método para determinar la causa de su falla.
                                                </p>
                                                <p>
                                                    Estos se construyen usando compuertas y eventos básicos (componentes del sistema). Las dos compuertas más comunes en un árbol de fallas son AND y OR. 
                                                </p>
                                                <ul class="lista">
                                                    <li>
                                                        <b>AND.-</b>  Representa un sistema en paralelo de dos elementos, en el cual se necesita que los dos elementos fallen.
                                                    </li>
                                                    <li>
                                                        <b>OR.-</b>  Representa un sistema en serie de dos elementos, donde la falla de un elemento causa la falla del sistema.
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
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
                                                        <b>Definir el evento tope.-</b> Los eventos topes se toman de los árboles de eventos.
                                                    </li>
                                                    <li>
                                                        <b>Analizar los criterios de éxito.-</b> Esta interpretación depende de las características del sistema, pudiéndose distinguir entre sistemas principales y sistemas de apoyo, así como si están normalmente en reserva o en operación continúa.
                                                    </li>
                                                    <li>
                                                        <b>Utilizar los DTI.</b>
                                                    </li>
                                                    <li>
                                                        <b>Realizar el árbol de eventos.</b>
                                                    </li>
                                                    <li>
                                                        <b>Obtener los conjuntos mínimos de corte (<a href="CMC.jsp">CMC)</a>.</b>
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
            </div>
        </section>
        <section id="screens">
            <div class="container">

                <div class="section-heading scrollpoint sp-effect3">
                    <h1>Simbología</h1>
                    <div class="divider"></div>
                    <p>"Elementos empleados en los árboles de fallas"</p>
                </div>
                <div class="row">
                    <div class="col-sm-4 scrollpoint sp-effect3">
                        <ul class="m_simbolos">
                            <li class="add" data-capa="basicos">Eventos Primarios</li>
                            <li  data-capa="intermedios">Eventos Intermedios</li>
                            <li  data-capa="compuertas">Simbolos de Compuertas</li>
                            <li  data-capa="transferencias">Simbolos de Transferencias</li>
                            <li><a href="arbol_evento.html">Ejemplo</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-8 scrollpoint sp-effect3" id="conte">
                        <div class="base" id="basicos">
                            <div class="item" title="Evento básico" data-content="Falla básica inicial, no requiere desarrollo.">
                                <img src="../img/simbolos/Eventos Primarios/Evento Basico__.png" >
                                <h4>Evento básico</h4>
                            </div> 
                            <div class="item" title="Evento condicionante" data-content="Condiciones o restricciones aplicables a una compuerta lógica.">
                            <img src="../img/simbolos/Eventos Primarios/Evento Condicionante__.png">
                            <h4>Evento condicionante</h4>
                         </div>
                         <div class="item" title="Evento no desarrollado" data-content="No se ha desarrollado más ya sea por información insuficiente o consecuencia insignificante.">
                            <img src="../img/simbolos/Eventos Primarios/Evento no desarrollado_.png">
                            <h4>Evento no desarrollado</h4>
                         </div>
                         <div class="item" title="Evento externo" data-content="Indica la continuación del árbol.">
                            <img src="../img/simbolos/Eventos Primarios/Evento Externo_.png">
                            <h4>Evento externo</h4>
                         </div>
                          <div class="item" title="Envía a" data-content="Indica que el árbol sigue desarrollandose en otro lugar.">
                            <img src="../img/simbolos/Eventos Primarios/Envia a_.png">
                            <h4>Envía a</h4>
                         </div>
                         <div class="item" title="Llega de" data-content="Indica la continuación del árbol.">
                            <img src="../img/simbolos/Eventos Primarios/Llega de__.png">
                            <h4>Llega de</h4>
                         </div>  
 
                        </div> 
                        <div class="base"  id="intermedios">
                           <div class="item" title="Evento intermedio" data-content="Indica la continuacion del árbol.">
                            <img src="../img/simbolos/Eventos Intermedios/Evento Intermedio_.png" width="55%">
                            <h4>Evento intermedio</h4>
                         </div>   
                        </div>
                        <div class="base"  id="compuertas">
                            <div class="item" title="Compuerta lógica AND" data-content="El evento de salida ocurre, si y solo si ocurren todos los eventos de la entrada.">
                                <img src="../img/simbolos/Compuertas/AND_.png">
                                <h4>Compuerta lógica AND</h4>
                            </div>   
                            <div class="item" title="Compuerta lógic OR" data-content="El evento de salida ocurre, si y solo si ocurre uno o más eventos de la entrega.">
                                <img src="../img/simbolos/Compuertas/OR_.png">
                                <h4>Compuerta lógica OR</h4>
                         </div> 
                            <div class="item" title="Compuerta lógic OR-exclusiva" data-content="El evento de salida ocurre si ocurre exactamente una de las entradas.">
                                <img src="../img/simbolos/Compuertas/OR EXCLUSIVA_.png">
                                <h4>Compuerta lógic OR-exclusiva</h4>
                            </div>  
                            <div class="item" title="Compuerta lógica AND-prioritaria" data-content="El evento de salida ocurre si todas las entradas ocurren en una secuencia específica.">
                                <img src="../img/simbolos/Compuertas/AND PRIORITARIA_.png">
                                <h4>Compuerta lógica AND-prioritaria</h4>
                             </div>   
                            <div class="item" title="Inhibición" data-content="El evento de salida ocurre partiendo de una única entrada siempre que se satisfaga una condición dada.">
                                <img src="../img/simbolos/Compuertas/INHIBICION_.png">
                                <h4>Inhibición</h4>
                            </div>     
                        </div>
                        <div class="base" id="transferencias">
                            <div class="item" title="Envía a" data-content="Indica que el árbol sigue desarrollandose en otro lugar.">
                                <img src="../img/simbolos/Eventos Primarios/Envia a_.png">
                                <h4>Envía a</h4>
                            </div>  
                            <div class="item" title="Llega de" data-content="Indica la continuación del árbol.">
                                <img src="../img/simbolos/Eventos Primarios/Llega de__.png">
                                <h4>Llega de</h4>
                         </div>
                        </div>

                    </div><!-- #conte -->
                    
                </div>            
            </div>
        </section>
        <section id="features" >
            <div class="container">
                <div class="section-heading scrollpoint sp-effect3">
                    <h1>Ejemplos</h1>
                    <div class="divider"></div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-4 scrollpoint sp-effect1">
                        <div class="media media-left feature">
                            <a class="pull-left" href="#">
                                <i class="fa fa-exclamation-triangle fa-2x"></i>
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading">1. Definir el evento tope.</h3>
                            </div>
                        </div>
                        <div class="media media-left feature">
                            <a class="pull-left" href="#">
                                <i class="fa fa-check fa-2x"></i>
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading">2. Analizar los criterios de éxito.</h3>
                            </div>
                        </div>
                        <div class="media media-left feature">
                            <a class="pull-left" href="#">
                                <i class="fa  fa-sitemap fa-2x"></i>
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading">3. Utilizar los DTI.</h3>
                            </div>
                        </div>
                        <div class="media media-left feature">
                            <a class="pull-left" href="#">
                                <i class="fa fa-pagelines fa-2x"></i>
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading">4. Realizar el árbol de eventos.</h3>
                            </div>
                        </div>
                        <div class="media media-left feature">
                            <a class="pull-left" href="#">
                                <i class="fa fa-chain-broken fa-2x"></i>
                            </a>
                            <div class="media-body">
                                <h3 class="media-heading">5. Obtener los conjuntos mínimos de corte (CMC).</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8 col-sm-8" >
                        <img src="../img/freeze/a_fallas.png" class="ejemplosFallas" alt="">
                        <div class="info-diagrama">
                            <h5>Diagrama de Árbol de Fallas</h5>
                            <p>
                                Como se observa en el ejemplo de diagrama de árbol de Fallas, el objetivo del sistema  es llevar agua desde el tanque hasta el sistema que rocía el agua, para ello pasa por un sistema en paralelo, esto quiere decir que, con que se inicie de cualquiera de las dos formas que existe, el sistema funciona, después de iniciado, el agua tiene que pasar por una válvula, la cual tiene que abrirse para dejar pasar el agua si esta válvula no se abre, el agua no llegará a su destino, el siguiente paso es una bomba, la cual tiene que funcionar para llevar el agua, hasta el sistema de rocío. 
                            </p>
                            <p>
                                Por lo tanto, el evento tope para este árbol, es la “falla de sistema con rocío”, y esto puedo ocurrir de tres maneras, la primea es que falle la válvula, la segunda que falle la bomba y la última es que los dos sistemas de inicio fallen, esto se ve representado en el árbol de fallas, el cual, está representado en la figura del lado izquierdo.

                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    <%@include file="footer.jsp" %>
    <script>
        $(document).ready(function() {

            var inicio=$(".m_simbolos li[class='add']").attr('data-capa');
            $("#"+inicio).show();

            $(".m_simbolos li").on('click', function(){
                var capa=$(this).attr('data-capa');
                
                $('.m_simbolos li').removeClass('add');
                $(this).addClass('add');

                $("div #"+capa).toggle();
                $("#conte .base[id != "+capa+"]").hide();

            });

            $('.item').popover({
                placement: "bottom",
                trigger: "hover"
            }); //popover
            
        });
    </script>

</body>

</html>


