<%-- 
    Document   : footer
    Created on : 12/09/2015, 04:01:48 PM
    Author     : gerardo.valenciano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <footer>
            <div class="container">
                <a href="#" class="scrollpoint sp-effect3" >
                    <img src="../img/freeze/logomin.png" alt="" class="logo" />
                </a>
                <div class="rights">
                    <p>Copyright &copy; 2015</p>
                </div>
            </div>
        </footer>
    <script>
      $(document).ready(function () {
        appMaster.preLoader();
        
        var url = window.location.pathname;  
        if(url==="/ProyectoFinalWeb/index.jsp")
          $(".logo").attr('src','img/freeze/logomin.png');
        
      });
    </script> 