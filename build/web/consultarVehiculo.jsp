<%-- 
    Document   : consultarVehiculo
    Created on : 19-may-2020, 11:04:27
    Author     : ortiz
--%>

<%@page import="ModeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String rolS =null;
    String id= null;
    ArrayList rol =null;
    HttpSession miSession = (HttpSession)request.getSession();
    UsuarioVO usuVO = (UsuarioVO)miSession.getAttribute("nombre");
    if (usuVO == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }else{
      rol  = (ArrayList)miSession.getAttribute("rol");
     rolS  = (String)miSession.getAttribute("rolSelec");
     id  = (String)miSession.getAttribute("id");
    if (rolS!="" || rolS!= null) {
            if (rolS.equals("1")) {
                   request.getRequestDispatcher("index.jsp").forward(request, response);  
                }
        }
    }
    %>
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
        <link href="Bootstrap/media.css" rel="stylesheet" type="text/css"/>
        <title> Consultar carros</title>
    </head>
    <body>
            <div class="container-fluid col-12 justify-content-center ">
                <div class=" container col-10" >
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
                                 <form method="post" action="salir">
                                    
                                <Button class="dropdown-item" name="opcion" value="salir" >Cerrar Sesion</Button>
                                </form>
                            </div>
                        </li>
                        
                    </ul>
                </div>
            </nav>
        <form method="post" action="Vehiculo"> 

                    
                <h1>Consultar</h1>
                <hr>
                        
                    <div class="form-inline my-2 my-lg-0 ">
                        <input class="form-control col-10" type="text" placeholder="Placa que deseas consultar" aria-label="Search" name="txtPlaca">
                        <button class="btn btn-outline-success  my-2 col-2" type="submit">
                            <img class="img-fluid" src="Bootstrap/buscar.png" alt=""/>
                        </button>
                    </div>
                    <input type="hidden" value="3" name="opcion">
                    <%if (request.getAttribute("mensajeError") != null) {%>
                    ${mensajeError}
                    <%} %>
                    <table class="table table-responsive-lg">
                        <tr>
                            <th>Placa</th>
                            <th>Datos</th>
                            <th>Categoria</th>
                            <th>Modelo</th>
                            <th>Marca</th>
                            <th>Estado</th>
                            <th>Precio</th>
                            <th>Opciones</th>
                        </tr>
                        <%
                            VehiculoVO vehVO = new VehiculoVO();
                            VehiculoDAO vehDAO = new VehiculoDAO();
                            ArrayList<VehiculoVO> listaVehiculos = vehDAO.lista(id);
                            for (int i = 0; i < listaVehiculos.size(); i++) {
                                vehVO = listaVehiculos.get(i);
                        %>
                        <tr>
                            <td><%=vehVO.getVehPlaca()%></td>
                            <td><%= vehVO.getDatId()%></td>
                            <td><%= vehVO.getCatId()%></td>
                            <td><%= vehVO.getVehModelo()%></td>
                            <td><%= vehVO.getVehMarca()%></td>
                            <td><%= vehVO.getVeEstado()%></td>
                            <td><%= vehVO.getVehPrecio()%></td>
                            <td><button value="<%=vehVO.getVehPlaca()%>" name="editar" class="btn btn-outline-primary">
                                    <img class="img-fluid" src="Bootstrap/editar.png" alt=""/>
                                </button>
                           
                            </td>
                        </tr>
                        <% }%>

                    </table>
        </form>
                </div>
            </div>

        <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
        <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
        <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
