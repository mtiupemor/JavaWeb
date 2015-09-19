<%-- 
    Document   : header
    Created on : 12/09/2015, 04:34:58 PM
    Author     : gerardo.valenciano
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <nav class="navbar navbar-default navbar-fixed-top scrolled" role="navigation" data-capa="arbol">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="fa fa-bars fa-lg"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">
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

          </ul>
        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-->
    </nav>  
