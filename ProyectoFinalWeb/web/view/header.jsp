<%-- 
    Document   : header
    Created on : 12/09/2015, 04:34:58 PM
    Author     : gerardo.valenciano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%//Includes generales%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="shortcut icon" href="favicon.png">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/animate.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/slick.css">
    <link rel="stylesheet" href="../js/rs-plugin/css/settings.css">
    <link rel="stylesheet" href="../css/freeze.css">
    <script type="text/javascript" src="../js/modernizr.custom.32033.js"></script> 
    <title>APS</title>
    <script src="../js/jquery-1.11.1.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/slick.min.js"></script>
    <script src="../js/placeholdem.min.js"></script>
    <script src="../js/rs-plugin/js/jquery.themepunch.plugins.min.js"></script>
    <script src="../js/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <script src="../js/waypoints.min.js"></script>
    <script src="../js/scripts.js"></script>


    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>
    <nav class="navbar navbar-default navbar-fixed-top scrolled" role="navigation" data-capa="arbol">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="fa fa-bars fa-lg"></span>
          </button>
          <a class="navbar-brand" href="../index.jsp">
            <img src="../img/freeze/logo.png" alt="" class="logo" style="width: 222px !important; height:81px !important;">
          </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

          <ul class="nav navbar-nav navbar-right">
            <li><a href="../index.jsp#">APS</a>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Información
                <span class="caret"></span></a>
              <ul class="dropdown-menu" >
                <li><a href="arbol_Falla.jsp">Árbol de Fallas</a></li>
                <li><a href="arbol_Evento.jsp">Árbol de Eventos</a></li>
                <li><a href="cmc.jsp" >Conjuntos mínimos de corte</a></li>
                <li><a href="EventoIniciador.jsp" >Evento iniciador</a></li>
              </ul>

            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Crea tu árbol
                <span class="caret"></span></a>
              <ul class="dropdown-menu" >
                <li><a href="creaArbolFalla.jsp">Árbol de Fallas</a></li>
                <li><a href="creaArbolEventos.jsp">Árbol de Eventos</a></li>
              </ul>

            </li>
            <li><a href="acercaDe.jsp">Acerca de</a>
            </li>
            <li><a href="contacto.jsp">Contacto</a>
            </li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                Documentación
                <span class="caret"></span></a>
              <ul class="dropdown-menu" >
                <li><a href="Definición arbol de fallas.pdf" class='submenu'>Árbol de Fallas</a></li>
                <li><a href="Definición arbol de eventos.pdf" class='submenu'>Árbol de Eventos</a></li>
              </ul>
            </li>
          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-->
    </nav>  
  </body>
</html>