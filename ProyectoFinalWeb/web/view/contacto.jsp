<%-- 
    Document   : contacto
    Created on : 12/09/2015, 05:37:42 PM
    Author     : Aydeeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" class="no-js">

  <head>
    <title>Contacto</title>
    <meta charset="UTF-8">
  </head>

  <body>

    <div class="pre-loader">
      <div class="load-con">
        <img src="../img/freeze/logo.png" class="animated fadeInDown" alt="">
        <div class="spinner">
          <div class="bounce1"></div>
          <div class="bounce2"></div>
          <div class="bounce3"></div>
        </div>
      </div>
    </div>

    <header>

      <%@include file="header.jsp" %>

    </header>

    <div class="wrapper">

      <section id="contacto" class="doublediagonal">
        <div class="container">
          <br/><br/><br/><br/><br/>
          <div class="section-heading scrollpoint sp-effect3">
            <h1>Contacto</h1>
            <div class="divider"></div>
            <p>Para más información, contáctanos!</p>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="row">

                <div class="col-md-8 col-sm-8 scrollpoint sp-effect1">
                  <form role="form">
                    <div class="form-group">
                      <input  type="text" class="form-control"  placeholder="Tu nombre"/>
                    </div>
                    <div class="form-group">
                      <input type="email" class="form-control" placeholder="Tu email"/>
                    </div>
                    <div class="form-group">
                      <textarea cols="30" rows="10" class="form-control" placeholder="Tu mensaje"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
                  </form>
                </div>

                <div class="col-md-4 col-sm-4 contact-details scrollpoint sp-effect2">

                  <div class="media">
                    <a class="pull-left" href="#" >
                      <i class="fa fa-user  fa-2x"></i>
                    </a>
                    <div class="media-body">
                      <h4 class="media-heading">Soporte técnico.</h4>
                    </div>
                  </div>


                  <div class="media">
                    <a class="pull-left" href="#" >
                      <i class="fa fa-envelope fa-2x"></i>
                    </a>
                    <div class="media-body">
                      <h4 class="media-heading">
                        <a href="mailto:isycnan@gmail.com">isycnan@gmail.com</a>
                      </h4>
                    </div>
                  </div>

                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      <%@include file="footer.jsp" %>

    </div>

  </body>
</html>
