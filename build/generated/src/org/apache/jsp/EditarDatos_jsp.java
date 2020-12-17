package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ModeloDAO.datosDAO;
import ModeloVO.DatosPersonalesVO;
import java.util.ArrayList;
import ModeloVO.UsuarioVO;

public final class EditarDatos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession miSession = (HttpSession)request.getSession();
    UsuarioVO usuVO = (UsuarioVO)miSession.getAttribute("nombre");
    ArrayList rol  = (ArrayList)miSession.getAttribute("rol");
    String rolS  = (String)miSession.getAttribute("rolSelec");
    String id = (String)miSession.getAttribute("id");
    if (usuVO == null) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link href=\"Bootstrap/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap-grid.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap-grid.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Datos personales</title>\n");
      out.write("    </head>\n");
      out.write("    <body> <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">VehiShop</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" \n");
      out.write("                        data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" \n");
      out.write("                        aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            \n");
      out.write("                            <a class=\"nav-link\" href=\"EditarDatos.jsp\">Tus Datos<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            ");

                                if (rolS.equalsIgnoreCase("2")) {
      out.write("\n");
      out.write("                            <a class=\"nav-link\" href=\"registrarVehiculo.jsp\">Registrar vehiculos</a>\n");
      out.write("                        </li>\n");
      out.write("                         <li>\n");
      out.write("                            \n");
      out.write("                            <a class=\"nav-link\" href=\"consultarVehiculo.jsp\">Tus vehiculos</a>\n");
      out.write("                            \n");
      out.write("                        </li>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" \n");
      out.write("                               data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                                Dropdown\n");
      out.write("                            </a>\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                ");

                                if (rol.size()!=1) {
      out.write("\n");
      out.write("                                <form  method=\"post\" action=\"Usuario\">\n");
      out.write("                                    <button class=\"dropdown-item\" value=\"8\" name=\"opcion\">Comprador</button>\n");
      out.write("                                <button type=\"submit\" class=\"dropdown-item\" value=\"6\" name=\"opcion\"/>Vendedor</button>  \n");
      out.write("                                </form>\n");
      out.write("                               \n");
      out.write("                                    \n");
      out.write("                                    ");
}else{
      out.write("\n");
      out.write("                                    <form method=\"post\" action=\"Usuario\">\n");
      out.write("                                        \n");
      out.write("                                    <button type=\"submit\" value=\"7\" name=\"opcion\" class=\"dropdown-item\" >Volverse vendedor</button> \n");
      out.write("                                    </form>\n");
      out.write("                                       \n");
      out.write("                               ");
}
      out.write("\n");
      out.write("                                <div class=\"dropdown-divider\"></div>\n");
      out.write("                                <a class=\"dropdown-item\" href=\"#\">Cerrar Sesion</a>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("         <div class=\"container-fluid\">\n");
      out.write("        \n");
      out.write("        <form method=\"post\" action=\"Usuario\">\n");
      out.write("            <div class=\"container-fluid col-12 align-content-center \" >\n");
      out.write("\n");
      out.write("                ");

                     DatosPersonalesVO daVO = new DatosPersonalesVO();
                            datosDAO datosDAO = new datosDAO();
                            ArrayList<DatosPersonalesVO> listadatos = datosDAO.lista(id);
                            daVO= listadatos.get(0);
                
                
      out.write("\n");
      out.write("                <div class=\"container col-8 \">\n");
      out.write("                    <h1>Tus datos personales!</h1>\n");
      out.write("                    <hr>\n");
      out.write("                    <input type=\"hidden\" value=\"");
      out.print(daVO.getDataId());
      out.write("\" name=\"datId\">\n");
      out.write("                  <div class=\"col\" > \n");
      out.write("                            <label>Nombre:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" value=\"");
      out.print(daVO.getDatNombre());
      out.write("\" name=\"textnombre\"><br>\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"col\" > \n");
      out.write("                            <label>Apellido:</label>\n");
      out.write("                            <input type=\"text\" name=\"textapellido\" value=\"");
      out.print(daVO.getDatApellido());
      out.write("\" class=\"form-control\"><br>\n");
      out.write("                        </div>  \n");
      out.write("\n");
      out.write("                     <div class=\"col\" > \n");
      out.write("                            <label>Correo:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" value=\"");
      out.print(daVO.getDatCorreo());
      out.write("\" name=\"textCorreo\">\n");
      out.write("                        </div> \n");
      out.write("                        <div class=\"col\" > \n");
      out.write("                            <label>Telefono:</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" value=\"");
      out.print(daVO.getDaTelefono());
      out.write("\" name=\"textTelefono\">\n");
      out.write("                        </div>  \n");
      out.write("                    \n");
      out.write("\n");
      out.write("                       \n");
      out.write("                    <br>\n");
      out.write("                    <div>\n");
      out.write("                        <button type=\"submit\" name=\"opcion\" value=\"9\" class=\"btn btn-primary col-12\">Guardar</button>\n");
      out.write("                    </div>\n");
      out.write("                </div> \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"Bootstrap/jquery-3.0.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.bundle.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.bundle.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
