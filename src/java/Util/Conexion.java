package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ortiz
 */
public class Conexion {

    public String driver, urlBd, userBd, pass, bd;

    public Connection conexion;
    private static Conexion instance;

    public Conexion() {
        driver = "com.mysql.jdbc.Driver";
        userBd = "root";
        pass = "";
        bd = "consecionario";
        urlBd = "jdbc:mysql://localhost:3306/" + bd;

        try {
            Class.forName(driver).newInstance();
            this.conexion = DriverManager.getConnection(urlBd, userBd, pass);

            System.out.println("conect ok");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public static Conexion getInstance() {

        if (instance == null) {

            instance = new Conexion();

        }

        return instance;

    }

    public Connection cerrarConexion() throws SQLException {

        conexion.close();
        conexion = null;
        return conexion;
    }

    //public static void main(String[] args) {
    //  new Conexion();
    //}
}
