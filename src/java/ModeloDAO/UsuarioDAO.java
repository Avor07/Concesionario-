/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioRolVO;
import ModeloVO.UsuarioVO;
import Util.Conexion;
import Util.Crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ortiz
 */
public class UsuarioDAO extends Conexion implements Crud {

    private Connection conexion;
    private Statement puente;
    private ResultSet mensajero;

    public String usuId = "";
    public String usuLogin = "";
    public String usuPassword = "";

    public boolean operacion = false;

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            puente.executeUpdate("insert into usuario(usulogin,usupassword) values('" + usuLogin + "','" + usuPassword + "')");
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean inicioSesion(String usuario, String clave) {
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
            mensajero = puente.executeQuery("select* from usuario where usulogin='" + usuario + "' and usupassword='" + clave + "'");
            if (mensajero.next()) {
                operacion = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public String TraerId(String usuario) {
        String id = "";
        try {
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.createStatement();
            mensajero = puente.executeQuery("select USUID from usuario where usulogin='" + usuario + "'");
            if (mensajero.next()) {
                id = mensajero.getString(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return id;
    }

    public String obtenerCorreo(String usuario) {
        String correo = "";
        try {
            PreparedStatement puente = null;
            String sql = "select DATCORREO from datospersonales where USUID=?";
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1,usuario);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
               correo=mensajero.getString(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return correo;
    }
    public boolean cambiarContraseña(String id,String contraseña) {
        try {
            PreparedStatement puente = null;
            String sql = "Update Usuario set USUPASSWORD=? WHERE USUID=?;";
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1,contraseña);
            puente.setString(2,id);
            puente.executeUpdate();
            if (mensajero.next()) {
               operacion=true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }
    

}
