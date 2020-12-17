<%-- 
    Document   : registrarVehiculo
    Created on : 19-may-2020, 10:35:22
    Author     : ortiz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String rolS = null;
    ArrayList rol = null;
    HttpSession miSession = (HttpSession) request.getSession();
    UsuarioVO usuVO = (UsuarioVO) miSession.getAttribute("nombre");
    if (usuVO == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } else {
        rol = (ArrayList) miSession.getAttribute("rol");
        rolS = (String) miSession.getAttribute("rolSelec");
        if (rolS != "" || rolS != null) {
            if (rolS.equals("1")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }
%>
<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="Bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap-grid.min.css" rel="stylesheet" type="text/css"/>
        <link href="Bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">VehiShop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" 
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="menu.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li>
                            
                            <a class="nav-link" href="EditarDatos.jsp">Tus Datos<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <%
                                if (rolS.equalsIgnoreCase("2")) {%>
                            <a class="nav-link" href="registrarVehiculo.jsp">Registrar vehiculos</a>
                        </li>
                         <li>
                            
                            <a class="nav-link" href="consultarVehiculo.jsp">Tus vehiculos</a>
                            
                        </li>
                            <%}%>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Dropdown
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <%
                                if (rol.size()!=1) {%>
                                <form  method="post" action="Usuario">
                                    <button class="dropdown-item" value="8" name="opcion">Comprador</button>
                                <button type="submit" class="dropdown-item" value="6" name="opcion"/>Vendedor</button>  
                                </form>
                               
                                    
                                    <%}else{%>
                                    <form method="post" action="Usuario">
                                        
                                    <button type="submit" value="7" name="opcion" class="dropdown-item" >Volverse vendedor</button> 
                                    </form>
                                       
                               <%}%>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Cerrar Sesion</a>
                            </div>
                        </li>
                        
                    </ul>
                </div>
            </nav>
        <form method="post" action="Vehiculo">
            <div class="container-fluid col-12 align-content-center " >


                <div class="container col-10 ">
                    <h1>Registrar Vehiculo!</h1>
                    <hr>
                    <%if (request.getAttribute("mensajeError") != null) {%>

                    ${mensajeError}   
                    <% request.setAttribute("mensajeError", null); %>

                    <%} else {%>


                    ${mensajeExito}

                    <%}%>
                    <div class="row">
                        <div class="col" > 
                            <label>Placa:</label>
                            <input type="text" class="form-control" name="txtPlaca" required><br>
                        </div> 
                        
                    </div>
                    <label>Categoría:</label>
                    <div class="row" >
                        <div class="col" >

                            <select name="txtCategoria" name="txtCategoria" class="form-control">
                                <option>Seleccione</option>
                                <% for (CategoriaVO caVO : CategoriaDAO.lista()) {%>
                                <option value="<%= caVO.getCatId()%>" ><%= caVO.getCatTipo()%></option>
                                <%}
                                %>

                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col" > 
                            <label>Modelo:</label>
                            <input type="text" class="form-control" name="txtModelo" required>
                        </div> 
                        <div class="col" > 
                            <label>Marca:</label>
                            <input type="text" class="form-control" name="txtmarca" required>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col" > 
                            <label>Estado:</label>
                            <input type="text" class="form-control" name="txtEstado" required>
                        </div> 
                        <div class="col-8" > 
                            <label>Precio:</label>
                            <input type="text" name="txtPrecio" class="form-control" required>
                        </div>  
                    </div>
                    <br>
                    <div>

                        <button type="submit" name="opcion" value="1" class="btn btn-primary col-12">Agregar Vehiculo</button>
                    </div>
                </div> 
            </div>




            <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
            <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
        </form>
            </div>
    </body>
</html>
