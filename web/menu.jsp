<%-- 
    Document   : menu
    Created on : 28-abr-2020, 15:48:23
    Author     : ortiz
--%>
<%@page import="ModeloDAO.VehiculoDAO"%>
<%@page import="ModeloVO.VehiculoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioRolVO"%>
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
        <title> Menu</title>
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
            <h1>Hola <%=usuVO.getUsuLogin()%></h1>
            <%
            if (rolS.equalsIgnoreCase("1")) {%>
            <p>Esta es la variedad de carros que tenemos para ti</p>
                      <table class="table table-responsive-lg">
                        <tr>
                            <th>Placa</th>
                            <th>Datos</th>
                            <th>Categoria</th>
                            <th>Modelo</th>
                            <th>Marca</th>
                            <th>Estado</th>
                            <th>Precio</th>
                    
                        </tr>
                        <%
                            VehiculoVO vehVO = new VehiculoVO();
                            VehiculoDAO vehDAO = new VehiculoDAO();
                            ArrayList<VehiculoVO> listaVehiculos = vehDAO.lista();
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
                           
                        </tr>
                        <% }%>

                    </table>   
                <%}else{%>
                
                <img class="img-fluid" src="Bootstrap/VendeTuCarro_1.png" alt=""/>


<%}
            %>
            </div>
            <script src="Bootstrap/jquery-3.0.0.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.min.js" type="text/javascript"></script>
            <script src="Bootstrap/popper.min.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.js" type="text/javascript"></script>
            <script src="Bootstrap/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
