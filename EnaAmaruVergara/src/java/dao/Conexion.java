/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author amaru
 */
public class Conexion {
    Connection conexion;
    String url = "jdbc:mysql://localhost:3306/";
    String bd = "requerimiento";
    String driver = "com.mysql.jdbc.Driver";
    String usuario = "root";
    String password = "12345678";
    
    // este metodo permite conectar con la base de datos
    public void conectar() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url+bd,usuario,password);
    }
    //este metodo permite desconectar la base de datos
    public void desconectar() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
    
    public Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url+bd,usuario,password);
    }
    
    //este metodo obtiene un statemet a partir de la conexion
    //el statement permite ejecutar sentencias en la base de datos
    public Statement obtenerStatement() throws SQLException{
        return conexion.createStatement();
    }
    //este metodo obteiene un preparedStatement con una sentencia pre configurada
    //para ejecutar una sentencia con parametros en la base de datos
    public PreparedStatement obtenerPS(String sentencia) throws SQLException{
        return conexion.prepareStatement(sentencia);
    }
            
    
}
