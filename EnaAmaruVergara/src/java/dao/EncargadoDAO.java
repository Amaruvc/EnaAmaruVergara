/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Encargado;

/**
 *
 * @author amaru
 */
public class EncargadoDAO extends Conexion{
        public Encargado obtenerEncargado(int idEncargado) throws SQLException{
        String sentencia = "select * from encargado where idEncargado=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, idEncargado);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Encargado(rs.getInt("idEncargado"),rs.getString("nombre"), rs.getString("apellido"), null));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Encargado> obtenerEncargados() throws SQLException{
        String sentencia = "select * from encargado";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Encargado> encargados = new ArrayList();
            while(rs.next()){
                encargados.add(new Encargado(rs.getInt("idEncargado"),rs.getString("nombre"), rs.getString("apellido"), null));
            }
            return encargados;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
