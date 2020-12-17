<%-- 
    Document   : index
    Created on : 28-abr-2020, 15:06:37
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
    <body class="bg-dark">
        <div class="container">
            <h1 style="color: white;">VehiShop</h1>
            <h3 style="color: white;" >El mejor lugar para vender tus autos <a href="CompraDeVehiculos.jsp">Inicia Sesion</a> o <a href="registrarUsuario.jsp">Registrate</a></h3>
       <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active" style="height:500px; width:100%">
                            <img src="Bootstrap/autos2.jpg" alt="" class="img-fluid" />
                        </div>
                        <div class="carousel-item " style="height:500px">
                            <img src="Bootstrap/autos1.jpg" alt="" class="img-fluid" />
                        </div>
                        
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>      
        </div>
      
    </body>
     <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
        <script>
        $('.carousel').carousel({
            interval: 5000
        })

    </script>
</html>
