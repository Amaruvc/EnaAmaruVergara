/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Usuario;

/**
 *
 * @author amaru
 */
public class UsuarioDAO extends Conexion {
    public Usuario obtenerUsuario(String run) throws ClassNotFoundException, SQLException{
        String sentencia = "select * from usuario where run = ?";
        try{
        conectar();
        PreparedStatement ps= obtenerPS(sentencia);
        ps.setString(1, run);
        ResultSet rs = ps.executeQuery();
        Usuario u = null;
        if(rs.next()){
           u = new Usuario(rs.getString("run"), rs.getString("password"));
        }
        return u;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
}
