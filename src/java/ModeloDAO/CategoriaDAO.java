/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CategoriaVO;
import Util.Conexion;
import java.sql.Connection;
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
public class CategoriaDAO extends Conexion {

    String catId,catTip;

    public static ArrayList<CategoriaVO> lista() {
        ArrayList<CategoriaVO> listaCategoria = new ArrayList<CategoriaVO>();
        try {
            Conexion con =new Conexion();
            Connection conBd = con.obtenerConexion();
            String sql = "select * From Categoria";
            PreparedStatement puente = conBd.prepareStatement(sql);
            ResultSet mensajero = puente.executeQuery();
            while (mensajero.next()) {
                CategoriaVO caVO = new CategoriaVO(mensajero.getString(1), mensajero.getString(2));
                listaCategoria.add(caVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaCategoria;
    }
}
