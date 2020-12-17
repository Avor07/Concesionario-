package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CompraDeVehiculos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link href=\"Bootstrap/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap-grid.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap-grid.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"Bootstrap/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>VehiShop</title>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"bg-light\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"Usuario\" method=\"post\"   >\n");
      out.write("            <center>\n");
      out.write("                \n");
      out.write("                        <h1 style=\"color:black;\">Bienvenido a Vehishop!</h1>\n");
      out.write("                        <hr style=\"background-color: white; \">\n");
      out.write("                        <div  style=\"height:50px; \"></div>\n");
      out.write("            </center>\n");
      out.write("                <div class=\"container col-6 bg-info \" style=\"height: 250px;\" >\n");
      out.write("                    <center>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("\n");
      out.write("                            <label style=\"color: white;\" class=\"float-left\">\n");
      out.write("                                Usuario:\n");
      out.write("                            </label>\n");
      out.write("                            <div class=\"Row\">\n");
      out.write("                                <input class=\"Col form-control\" name=\"textUsuario\" placeholder=\"Usuario\" type=\"text\"autocomplete=\"off\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <label style=\"color: white;\" class=\"float-left\">\n");
      out.write("                                Contraseña:\n");
      out.write("                            </label>\n");
      out.write("                            <div class=\"Row\">\n");
      out.write("                                <input class=\"Col form-control\" placeholder=\"Contraseña\" name=\"textClave\" type=\"password\" autocomplete=\"off\"/>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-light col\" name=\"opcion\" value=\"3\" />Entrar</button>\n");
      out.write("\n");
      out.write("                    <a href=\"registrarUsuario.jsp\" style=\"color:white;\" >Registrarse</a>\n");
      out.write("                    <a href=\"recuperarContraseña.jsp\" style=\"color:white;\" >Recuperar Contraseña</a>\n");
      out.write("                    </center>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            <!-- tab-content -->\n");
      out.write("\n");
      out.write("            <!-- /form -->\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <script src=\"Bootstrap/jquery-3.0.0.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.bundle.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Bootstrap/bootstrap.bundle.min.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
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
