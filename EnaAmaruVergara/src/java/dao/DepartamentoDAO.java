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
import modelos.Departamento;

/**
 *
 * @author amaru
 */
public class DepartamentoDAO extends Conexion{
    public Departamento obtenerDepartamento(int idDepartamento) throws SQLException{
        String sentencia = "select * from departamento where iddepartamento=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, idDepartamento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return (new Departamento(rs.getInt("iddepartamento"),rs.getString("nombre"), rs.getInt("presta_servicio") == 1, null));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Departamento> obtenerDepartamentos() throws SQLException{
        String sentencia = "select * from departamento";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Departamento> departamentos = new ArrayList();
            while(rs.next()){
                departamentos.add(new Departamento(rs.getInt("iddepartamento"),rs.getString("nombre"), rs.getInt("presta_servicio") == 1, null));
            }
            return departamentos;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }


}
