/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.DatosPersonalesVO;
import Util.Conexion;
import Util.Crud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ortiz
 */
public class datosDAO extends Conexion implements Crud {

    private String dataId, usuId, datNombre, datApellido, dataTipoId, datNumeroID, daTelefono, datCorreo;
    boolean operacion = false;
    private ResultSet mensajero;

    public datosDAO(DatosPersonalesVO datos) {
        usuId = datos.getUsuId();
        datNombre = datos.getDatNombre();
        datApellido = datos.getDatApellido();
        daTelefono = datos.getDaTelefono();
        datCorreo = datos.getDatCorreo();
        dataId = datos.getDataId();
    }

    public datosDAO() {

    }

    @Override
    public boolean agregarRegistro() {
        try {
            String sql = "insert into datospersonales(USUID,datnombre,datapellido,datelefono,datcorreo) values(?,?,?,?,?)";
            PreparedStatement puente = null;
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuId);
            puente.setString(2, datNombre);
            puente.setString(3, datApellido);
            puente.setString(4, daTelefono);
            puente.setString(5, datCorreo);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(datosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            String sql = "UPDATE datospersonales SET datnombre=?,datapellido=?,datelefono=?,datcorreo=? where usuid=?";
            PreparedStatement puente = null;
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, datNombre);
            puente.setString(2, datApellido);
            puente.setString(3, daTelefono);
            puente.setString(4, datCorreo);
            puente.setString(5, usuId);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(datosDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return operacion;
    }

    public String traerDatId(String id) {
        String dataid = "";
        try {
            String sql="SELECT DATID FROM datospersonales where USUID=?";
             PreparedStatement puente = null;
             conexion = Conexion.getInstance().obtenerConexion();
             puente = conexion.prepareStatement(sql);
             puente.setString(1,id); 
             mensajero=puente.executeQuery();
            if (mensajero.next()) {
                dataid = mensajero.getString(1);
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return dataid;
    }

    public ArrayList<DatosPersonalesVO> lista(String id) {
        ArrayList<DatosPersonalesVO> listadatos = new ArrayList<DatosPersonalesVO>();
        try {
            PreparedStatement puente = null;
            String sql = "select * from datospersonales where USUID=?";
            conexion = Conexion.getInstance().obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, id);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                DatosPersonalesVO datos = new DatosPersonalesVO(mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(7), mensajero.getString(8));
                listadatos.add(datos);

            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listadatos;
    }

}
//
