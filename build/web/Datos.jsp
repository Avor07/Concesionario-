<%-- 
    Document   : Datos
    Created on : 14-jun-2020, 13:43:18
    Author     : ortiz
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%
    HttpSession miSession = (HttpSession)request.getSession();
    UsuarioVO usuVO = (UsuarioVO)miSession.getAttribute("nombre");
    ArrayList rol  = (ArrayList)miSession.getAttribute("rol");
    String rolS  = (String)miSession.getAttribute("rolSelec");
    if (usuVO == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="Bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Datos personales</title>
    </head>
    <body>
         <div class="container-fluid">
        
        <form method="post" action="Usuario">
            <div class="container-fluid col-12 align-content-center " >


                <div class="container col-8 ">
                    <h1>Tus datos personales!</h1>
                    <hr>
                    <div class="row">
                        <div class="col" > 
                            <label>Nombre:</label>
                            <input type="text" class="form-control" name="textnombre"><br>
                        </div> 
                        <div class="col" > 
                            <label>Apellido:</label>
                            <input type="text" name="textapellido" class="form-control"><br>
                        </div>  
                    </div>

                    <div class="row">
                        <div class="col" > 
                            <label>Correo:</label>
                            <input type="text" class="form-control" name="textCorreo">
                        </div> 
                        <div class="col" > 
                            <label>Telefono:</label>
                            <input type="text" class="form-control" name="textTelefono">
                        </div>  
                    </div>

                    <br>
                    <div>
                        <button type="submit" name="opcion" value="5" class="btn btn-primary col-12">Guardar</button>
                    </div>
                </div> 
            </div>




        </form>


            </div>


        <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
