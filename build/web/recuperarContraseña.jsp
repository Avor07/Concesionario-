<%-- 
    Document   : recuperarContraseña
    Created on : 11-jun-2020, 15:33:04
    Author     : ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="Bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Recuperacion de contraseña</title>
    </head>
    <body>
         <form action="Usuario" method="post"   >
            <center>
                
                        <h1 style="color:black;">Rcupera tu contraseña!</h1>
                        <hr style="background-color: white; ">
                        <div  style="height:50px; "></div>
            </center>
                <div class="container col-6 bg-info " style="height: 250px;" >
                    <center>


                        
                        
                            <label style="color: white;" class="float-left">
                            Usuario:
                            </label>
                            <div  class="Row">
                                <input class="Col form-control" name="textUsuario" placeholder="Usuario" type="text"autocomplete="off"/>
                            </div>
                             <label style="color: white;" class="float-left">
                            Al presionar Cambiar, enviaremos una nueva contraseña a tu correo y te redireccionaremos al inicio
                            </label>
                    </center>
                    <div style="height: 30px;">
                        
                    </div>
                        <Button type="submit" value="4"  name="opcion" class="btn btn-light col-12">Cambiar</button>
                </div>
             <%if (request.getAttribute("contra")!=null) {%>
                ${contra}
            <%}%>

            <!-- tab-content -->

            <!-- /form -->

        </form>
        <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
