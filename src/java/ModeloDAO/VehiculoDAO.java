/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.VehiculoVO;
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
public class VehiculoDAO extends Conexion implements Crud {

    private Connection conexion;
    private PreparedStatement puente = null;
    private ResultSet mensajero;
    private String vehPlaca = "", datId = "", catId = "", vehModelo = "",
            vehMarca = "", veEstado = "", vehPrecio = "";
    boolean operacion = false;
    private String sql;

    public VehiculoDAO() {
    }

    public VehiculoDAO(VehiculoVO vehVO) {
        super();
        try {
            conexion = this.obtenerConexion();

            vehPlaca = vehVO.getVehPlaca();
            datId = vehVO.getDatId();
            catId = vehVO.getCatId();
            vehModelo = vehVO.getVehModelo();
            vehMarca = vehVO.getVehMarca();
            veEstado = vehVO.getVeEstado();
            vehPrecio = vehVO.getVehPrecio();
        } catch (Exception e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            sql = "insert into vehiculo values(?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, vehPlaca);
            puente.setString(2, datId);
            puente.setString(3, catId);
            puente.setString(4, vehModelo);
            puente.setString(5, vehMarca);
            puente.setString(6, veEstado);
            puente.setString(7, vehPrecio);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "update vehiculo set DATID=?,CATID=?,VEHMODELO=?,VEHMARCA=?,VEHESTADO=?,VEHPRECIO=? WHERE VEHPLACA=?;";
            puente = conexion.prepareStatement(sql);

            puente.setString(1, datId);
            puente.setString(2, catId);
            puente.setString(3, vehModelo);
            puente.setString(4, vehMarca);
            puente.setString(5, veEstado);
            puente.setString(6, vehPrecio);
            puente.setString(7, vehPlaca);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public static VehiculoVO consultarPlaca(String placa) {
        VehiculoVO vehVO = null;
        Conexion con = new Conexion();
        try {
            Connection conexion = con.obtenerConexion();
            PreparedStatement puente = null;
            String sql = "Select* From vehiculo where VEHPLACA=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, placa);
            ResultSet mensajero = puente.executeQuery();
            while (mensajero.next()) {
                vehVO = new VehiculoVO(placa, mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
            }
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                con.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return vehVO;
    }

    public ArrayList<VehiculoVO> lista() {
        ArrayList<VehiculoVO> listaVehiculos = new ArrayList<VehiculoVO>();
        try {
            conexion = this.obtenerConexion();
            sql = "select vehplaca,d.`DATNOMBRE`,c.catipo,vehmodelo,vehmarca,vehestado,vehprecio From Vehiculo v inner join datospersonales d on d.`DATID`=v.`DATID` inner join categoria c on v.catid=c.catid";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VehiculoVO vehVO = new VehiculoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
                listaVehiculos.add(vehVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaVehiculos;
    }
    public ArrayList<VehiculoVO> lista(String id) {
        ArrayList<VehiculoVO> listaVehiculos = new ArrayList<VehiculoVO>();
        try {
            conexion = this.obtenerConexion();
            sql = "select vehplaca,d.`DATNOMBRE`,catid,vehmodelo,vehmarca,vehestado,vehprecio From Vehiculo v inner join datospersonales d on d.`DATID`=v.`DATID` where d.USUID="+id;
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                VehiculoVO vehVO = new VehiculoVO(mensajero.getString(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7));
                listaVehiculos.add(vehVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaVehiculos;
    }
}
