/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import ModeloDAO.UsuarioDAO;
import ModeloDAO.UsuarioRolDAO;
import ModeloDAO.datosDAO;
import ModeloVO.DatosPersonalesVO;
import ModeloVO.UsuarioRolVO;
import ModeloVO.UsuarioVO;
import Util.GenaradorDeContraseña;
import Util.Correo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
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
@WebServlet(name = "ControladorUsuario", urlPatterns = {"/Usuario"})
public class ControladorUsuario extends HttpServlet {

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
            throws ServletException, IOException, MessagingException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String usuid = request.getParameter("textId");
        String usuLogin = request.getParameter("textUsuario");
        String usuPassword = request.getParameter("textClave");
        UsuarioVO usuVO = new UsuarioVO(usuid, usuLogin, usuPassword);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        HttpSession miSession = null;
        ArrayList rol = null;

        switch (opcion) {
            case 1://agregar registro
                if (usuDAO.agregarRegistro()) {
                    miSession = request.getSession(true);
                    String id = usuDAO.TraerId(usuVO.getUsuLogin());
                    miSession.setAttribute("id", id);
                    UsuarioRolVO rolVo = new UsuarioRolVO("", id);
                    UsuarioRolDAO usuRolDAO = new UsuarioRolDAO(rolVo);
                    usuRolDAO.agregarRegistro();
                    rol = usuRolDAO.TraerRol(id);
                    miSession.setAttribute("nombre", usuVO);
                    miSession.setAttribute("rol", rol);
                    request.getRequestDispatcher("Datos.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El usuario no se registro correctamente");
                }
                request.getRequestDispatcher("registrarUsuario.jsp").forward(request, response);
                break;
            case 3:
                if (usuDAO.inicioSesion(usuLogin, usuPassword)) {
                    miSession = request.getSession(true);
                    usuVO = new UsuarioVO(usuLogin);
                    String id = usuDAO.TraerId(usuLogin);
                    miSession.setAttribute("id", id);
                    UsuarioRolDAO usuRolDAO = new UsuarioRolDAO();
                    rol = usuRolDAO.TraerRol(id);
                    miSession.setAttribute("nombre", usuVO);
                    miSession.setAttribute("rol", rol);
                    String r = rol.get(0).toString();
                    miSession.setAttribute("rolSelec", r);
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                } else {
                    request.setAttribute("mensajeError", "El usuario y/o la contraseña son incorrectos");
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                }
                break;
            case 4:
                String id = usuDAO.TraerId(usuLogin);
                String contra = GenaradorDeContraseña.getPassword(GenaradorDeContraseña.numeros + GenaradorDeContraseña.mayusculas + GenaradorDeContraseña.minusculas, 8);
                usuDAO.cambiarContraseña(id, contra);
                String correo = usuDAO.obtenerCorreo(id);
                request.setAttribute("contra", contra);
                Correo.EnviarCorreo(contra, correo);
                request.getRequestDispatcher("CompraDeVehiculos.jsp").forward(request, response);
                break;
            case 5:
                miSession = request.getSession(true);
                String iD = (String) miSession.getAttribute("id");
                String nombre = request.getParameter("textnombre");
                String apellido = request.getParameter("textapellido");
                String email = request.getParameter("textCorreo");
                String telefono = request.getParameter("textTelefono");
                DatosPersonalesVO datos = new DatosPersonalesVO(iD, nombre, apellido, telefono, email);
                datosDAO datosDAO = new datosDAO(datos);

                if (datosDAO.agregarRegistro()) {
                     UsuarioRolVO rolVo = new UsuarioRolVO(null, iD);
                    UsuarioRolDAO usRolDAO = new UsuarioRolDAO();
                    usRolDAO.agregarRegistro();
                    rol = usRolDAO.TraerRol(iD);
                    miSession.setAttribute("rol", rol);
                    miSession.setAttribute("rolSelec", rol.get(0).toString());
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("Datos.jsp").forward(request, response);
                }
                break;
            case 6:
                UsuarioRolDAO usRolDAO = new UsuarioRolDAO();
                miSession = request.getSession(true);
                String identifi = (String) miSession.getAttribute("id");
                rol = usRolDAO.TraerRol(identifi);
                miSession.setAttribute("rolSelec", rol.get(1).toString());
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
            case 7:
                miSession = request.getSession(true);
                String identificador = (String) miSession.getAttribute("id");
                UsuarioRolVO rolVo = new UsuarioRolVO("2", identificador);
                UsuarioRolDAO usuRolDAO = new UsuarioRolDAO(rolVo);
                usuRolDAO.agregarRegistro();
                rol = usuRolDAO.TraerRol(identificador);
                miSession.setAttribute("rol", rol);
                miSession.setAttribute("rolSelec", rol.get(1).toString());
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
            case 8:
                UsuarioRolDAO uRolDAO = new UsuarioRolDAO();
                miSession = request.getSession(true);
                String ident = (String) miSession.getAttribute("id");
                rol = uRolDAO.TraerRol(ident);
                miSession.setAttribute("rolSelec", rol.get(0).toString());
                request.getRequestDispatcher("menu.jsp").forward(request, response);
                break;
            case 9:
                 miSession = request.getSession(true);
                String identi = (String) miSession.getAttribute("id");
                String nbre = request.getParameter("textnombre");
                String ape = request.getParameter("textapellido");
                String mail = request.getParameter("textCorreo");
                String tele = request.getParameter("textTelefono");
                String dataid = request.getParameter("datId");
                DatosPersonalesVO datosVo = new DatosPersonalesVO(dataid,identi, nbre, ape, tele, mail);
                
                datosDAO datoDAO = new datosDAO(datosVo);
                
                if (datoDAO.actualizarRegistro()) {
                    
                    UsuarioRolDAO urolDAO = new UsuarioRolDAO();
                   
                    rol = urolDAO.TraerRol(identi);
                    miSession.setAttribute("rol", rol);
                    miSession.setAttribute("rolSelec", rol.get(0).toString());
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("EditarDatos.jsp").forward(request, response);
                }

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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (MessagingException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
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
