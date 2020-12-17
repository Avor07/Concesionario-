/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ModeloDAO.VehiculoDAO;
import ModeloDAO.datosDAO;
import ModeloVO.VehiculoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ortiz
 */
@WebServlet(name = "VehiculoControlador", urlPatterns = {"/Vehiculo"})
public class VehiculoControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String placa = request.getParameter("txtPlaca");
          String editar= request.getParameter("editar");
        String categoria = request.getParameter("txtCategoria");
        String modelo = request.getParameter("txtModelo");
        String marca = request.getParameter("txtmarca");
        String estado = request.getParameter("txtEstado");
        String precio = request.getParameter("txtPrecio");
         HttpSession miSession = null;
        miSession = request.getSession(true);
        datosDAO dato =new datosDAO();
        String id = (String)miSession.getAttribute("id");
        String datos= dato.traerDatId(id);
        VehiculoVO vehVO = new VehiculoVO(placa, datos, categoria, modelo, marca, estado, precio);
        VehiculoDAO vehDAO = new VehiculoDAO(vehVO);
        switch (opcion) {
            case 1:
                if (vehDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "<div class=\"alert alert-success\">El Vehiculo se registro correctamente</div>");
                } else {
                    request.setAttribute("mensajeError", "<div class=\"alert alert-danger\" >El Vehiculo no se registro correctamente</div>");

                }
                request.getRequestDispatcher("registrarVehiculo.jsp").forward(request, response);
                break;
            case 2:
                if (vehDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "El Vehiculo se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El Vehiculo no se actualizo correctamente");

                }
                request.getRequestDispatcher("ActualizarVehiculo.jsp").forward(request, response);
                break;

            case 3:
                if (editar!= null && editar!="") {
                    placa=editar;
                }
                vehVO = VehiculoDAO.consultarPlaca(placa);
                if (vehVO != null) {
                    request.setAttribute("vehiculoConsultado", vehVO);
                    request.getRequestDispatcher("ActualizarVehiculo.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El Vehiculo no existe");
                    request.getRequestDispatcher("consultarVehiculo.jsp").forward(request, response);
                }
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
