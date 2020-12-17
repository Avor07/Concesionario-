<%-- 
    Document   : EditarDatos
    Created on : 14-jun-2020, 22:00:36
    Author     : ortiz
--%>

<%@page import="ModeloDAO.datosDAO"%>
<%@page import="ModeloVO.DatosPersonalesVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloVO.UsuarioVO"%>
<%
    HttpSession miSession = (HttpSession)request.getSession();
    UsuarioVO usuVO = (UsuarioVO)miSession.getAttribute("nombre");
    ArrayList rol  = (ArrayList)miSession.getAttribute("rol");
    String rolS  = (String)miSession.getAttribute("rolSelec");
    String id = (String)miSession.getAttribute("id");
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
    <body> <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
         <div class="container-fluid">
        
        <form method="post" action="Usuario">
            <div class="container-fluid col-12 align-content-center " >

                <%
                     DatosPersonalesVO daVO = new DatosPersonalesVO();
                            datosDAO datosDAO = new datosDAO();
                            ArrayList<DatosPersonalesVO> listadatos = datosDAO.lista(id);
                            daVO= listadatos.get(0);
                
                %>
                <div class="container col-8 ">
                    <h1>Tus datos personales!</h1>
                    <hr>
                    <input type="hidden" value="<%=daVO.getDataId()%>" name="datId1">
                  <div class="col" > 
                            <label>Nombre:</label>
                            <input type="text" class="form-control" value="<%=daVO.getDatNombre()%>" name="textnombre"><br>
                        </div> 
                        <div class="col" > 
                            <label>Apellido:</label>
                            <input type="text" name="textapellido" value="<%=daVO.getDatApellido()%>" class="form-control"><br>
                        </div>  

                     <div class="col" > 
                            <label>Correo:</label>
                            <input type="text" class="form-control" value="<%=daVO.getDatCorreo()%>" name="textCorreo">
                        </div> 
                        <div class="col" > 
                            <label>Telefono:</label>
                            <input type="text" class="form-control" value="<%=daVO.getDaTelefono()%>" name="textTelefono">
                        </div>  
                    

                       
                    <br>
                    <div>
                        <button type="submit" name="opcion" value="9" class="btn btn-primary col-12">Guardar</button>
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
