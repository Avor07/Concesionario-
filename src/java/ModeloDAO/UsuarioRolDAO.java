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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ortiz
 */
public class UsuarioRolDAO extends Conexion implements Crud {
  private Connection conexion;
    private Statement puente;
    private ResultSet mensajero;

     private String rolId,usuId;
    public boolean operacion = false;
    public UsuarioRolDAO() {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
           
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    public UsuarioRolDAO(UsuarioRolVO rol) {
        super();
        try {
            rolId=rol.getRolId();
            usuId=rol.getUsuId();
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();
           
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    
     public ArrayList TraerRol(String Id){
          ArrayList lista= new ArrayList();  
        try {
            conexion=this.obtenerConexion();
            puente= conexion.createStatement();
            mensajero=puente.executeQuery("select ROLID from usuario_rol where USUID='"+Id+"'");
        
        while(mensajero.next()){
            lista.add(mensajero.getString(1));
         
        }
       } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        }
        finally{
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    return lista;
    }

    @Override
    public boolean agregarRegistro() {
        try{
         String sql="insert into usuario_rol(ROLID,USUID) values(?,?)";
             PreparedStatement puente = null;
             conexion = Conexion.getInstance().obtenerConexion();
             puente = conexion.prepareStatement(sql);
             if (rolId!="" && rolId!=null) {
               puente.setString(1,rolId); 
            }else{
             
            puente.setString(1,"1");
             }
            puente.setString(2,usuId);
            puente.executeUpdate();
             operacion= true;
        } catch (SQLException e) {
            Logger.getLogger(datosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
