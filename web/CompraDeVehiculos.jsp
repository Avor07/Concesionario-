<%-- 
    Document   : CompraDeVehiculos
    Created on : 24-may-2020, 16:15:06
    Author     : ortiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="Bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>VehiShop</title>
    </head>
    <body class="bg-light">


        <form action="Usuario" method="post"   >
            <center>
                
                        <h1 style="color:black;">Bienvenido a Vehishop!</h1>
                        <hr style="background-color: white; ">
                        <div  style="height:50px; "></div>
            </center>
                <div class="container col-6 bg-info " style="height: 250px;" >
                    <center>


                        
                        

                            <label style="color: white;" class="float-left">
                                Usuario:
                            </label>
                            <div class="Row">
                                <input class="Col form-control" name="textUsuario" placeholder="Usuario" type="text"autocomplete="off"/>
                            </div>

                            <label style="color: white;" class="float-left">
                                Contraseña:
                            </label>
                            <div class="Row">
                                <input class="Col form-control" placeholder="Contraseña" name="textClave" type="password" autocomplete="off"/>
                            </div>
                            <br>

                            <button type="submit" class="btn btn-light col" name="opcion" value="3" />Entrar</button>

                    <a href="registrarUsuario.jsp" style="color:white;" >Registrarse</a>
                    <a href="recuperarContraseña.jsp" style="color:white;" >Recuperar Contraseña</a>
                    </center>

                </div>

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
