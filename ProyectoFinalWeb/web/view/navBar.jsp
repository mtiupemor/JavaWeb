<%-- 
    Document   : navBar
    Created on : 12/09/2015, 03:02:13 PM
    Author     : gerardo.valenciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%//Includes generales%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <link rel="shortcut icon" href="view/favicon.png">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/slick.css">
        <link rel="stylesheet" href="js/rs-plugin/css/settings.css">
        <link rel="stylesheet" href="css/freeze.css">
        <script type="text/javascript" src="js/modernizr.custom.32033.js"></script>
    
        <title>Includes del NavBar </title>
        
    </head>
    <body>
        
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="fa fa-bars fa-lg"></span>
                        </button>
                        <a class="navbar-brand" href="index.jsp">
                            <img src="img/freeze/logo.png" alt="" class="logo" style="width: 222px !important; height:81px !important;">
                        </a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">APS</a>
                            </li>
                            <li><a href="#informacion">Información</a>
                            </li>
                            <li><a href="#">Crea tu árbol</a>
                            </li>
                            <li><a href="view/acercaDe.html">Acerca de</a>
                            </li>
                            <li><a href="view/contacto.html">Contacto</a>
                            </li>
                           
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-->
        </nav>
        
    </body>
</html>