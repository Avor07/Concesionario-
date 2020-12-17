<%-- 
    Document   : registrarVehiculo
    Created on : 19-may-2020, 10:35:22
    Author     : ortiz
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%
    String rolS =null;
    ArrayList rol =null;
    HttpSession miSession = (HttpSession)request.getSession();
    UsuarioVO usuVO = (UsuarioVO)miSession.getAttribute("nombre");
    if (usuVO == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }else{
      rol  = (ArrayList)miSession.getAttribute("rol");
     rolS  = (String)miSession.getAttribute("rolSelec");
    if (rolS!="" || rolS!= null) {
            if (rolS.equals("1")) {
                   request.getRequestDispatcher("index.jsp").forward(request, response);  
                }
        }
    }
    %>

<%@page import="ModeloDAO.CategoriaDAO"%>
<%@page import="ModeloVO.CategoriaVO"%>
<%@page import="ModeloVO.VehiculoVO"%>
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
                            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
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
                                <form method="post" action="salir">
                                    
                                <Button class="dropdown-item" name="opcion" value="salir" >Cerrar Sesion</Button>
                                </form>
                            </div>
                        </li>
                        
                    </ul>
                </div>
            </nav>
        <%
            VehiculoVO vehVO = (VehiculoVO) request.getAttribute("vehiculoConsultado");
        %>
        <h1>Actualizar Vehiculo!</h1>
        <form method="post" action="Vehiculo">
            <table>
                <tr>
                    <% if (vehVO != null) {
                    %>
                    PLACA<br/>
                <input type="text" name="txtPlaca" required value=<%=vehVO.getVehPlaca()%>><br>
                DATOS<br/>
                <input type="text" name="txtDatos" required value=<%=vehVO.getDatId()%>><br>
                CATEGORIA<br/>
                <select name="txtCategoria">
                    <% for (CategoriaVO caVO : CategoriaDAO.lista()) {%>
                    <option value="<%= caVO.getCatId()%>"><%= caVO.getCatTipo()%></option>
                    <%}
                    %>

                </select>
                MODELO<br/>
                <input type="text" name="txtModelo" required value=<%=vehVO.getVehModelo()%> ><br>
                MARCA<br/>
                <input type="text" name="txtmarca" required value=<%=vehVO.getVehMarca()%> ><br>
                ESTADO<br/>
                <input type="text" name="txtEstado" required value=<%=vehVO.getVeEstado()%> ><br>
                PRECIO<br/>
                <input type="number" min="1" name="txtPrecio" required  value=<%=vehVO.getVehPrecio()%>><br>
                <%}%>
                </tr>
            </table>
            <input type="hidden" value="2" name="opcion" >
            <button>Actualizar</button>
            <a href="consultarVehiculo.jsp">Volver</a>

            <%if (request.getAttribute("mensajeError") != null) {%>
            ${mensajeError}
            <%} else {%>
            ${mensajeExito}
            <%}%>
        </form>
    </div>
         <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
            <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
