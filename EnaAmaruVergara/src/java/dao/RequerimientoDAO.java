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
import modelos.Encargado;
import modelos.Gerencia;
import modelos.Requerimiento;

/**
 *
 * @author amaru
 */
public class RequerimientoDAO extends Conexion {
        public Requerimiento obtenerRequerimiento(int idRequerimiento) throws SQLException{
        String sentencia = "select * from v_requerimiento where idRequerimiento=?";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, idRequerimiento);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Gerencia gerenciaOrigen = new Gerencia(rs.getInt("idgerencia_origen"), rs.getString("gerencia_origen"));
                Departamento departamentoOrigen = new Departamento(rs.getInt("id_depto_origen"), rs.getString("departamento_origen"),
                        rs.getInt("presta_servicio_origen") == 1, gerenciaOrigen);
                
                Gerencia gerenciaAsignado = new Gerencia(rs.getInt("idgerencia_asignado"), rs.getString("gerencia_asignado"));
                Departamento departamentoAsignado = new Departamento(rs.getInt("id_depto_asignado"), rs.getString("departamento_asignado"),
                        rs.getInt("presta_servicio_asignado") == 1, gerenciaAsignado);
                Encargado encargado = new Encargado(rs.getInt("id_encargado"), rs.getString("nombre_encargado"), rs.getString("apellido_encargado"), departamentoAsignado);
                
                return (new Requerimiento(rs.getInt("idRequerimiento"),rs.getString("descripcion"), rs.getInt("estado") == 1, departamentoOrigen, departamentoAsignado, encargado));
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Requerimiento> obtenerRequerimientos() throws SQLException{
        String sentencia = "select * from v_requerimiento";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Requerimiento> requerimientos = new ArrayList();
            while(rs.next()){
                Gerencia gerenciaOrigen = new Gerencia(rs.getInt("idgerencia_origen"), rs.getString("gerencia_origen"));
                Departamento departamentoOrigen = new Departamento(rs.getInt("id_depto_origen"), rs.getString("departamento_origen"),
                        rs.getInt("presta_servicio_origen") == 1, gerenciaOrigen);
                
                Gerencia gerenciaAsignado = new Gerencia(rs.getInt("idgerencia_asignado"), rs.getString("gerencia_asignado"));
                Departamento departamentoAsignado = new Departamento(rs.getInt("id_depto_asignado"), rs.getString("departamento_asignado"),
                        rs.getInt("presta_servicio_asignado") == 1, gerenciaAsignado);
                Encargado encargado = new Encargado(rs.getInt("id_encargado"), rs.getString("nombre_encargado"), rs.getString("apellido_encargado"), departamentoAsignado);
                
                requerimientos.add(new Requerimiento(rs.getInt("idRequerimiento"),rs.getString("descripcion"), rs.getInt("estado") == 1, departamentoOrigen, departamentoAsignado, encargado));
            }
            return requerimientos;
        }catch(Exception e ){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
    
    public int registrar(Requerimiento requerimiento) throws SQLException{
        String sentencia = "insert into requerimiento (idrequerimiento, descripcion, estado, id_depto_origen, id_depto_asignado, id_encargado) values (?, ?, ?, ?, ?, ?)";
        try{
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, requerimiento.getIdRequerimiento());
            ps.setString(2, requerimiento.getDescripcion());
            ps.setInt(3, requerimiento.isEstado() ? 1 : 0);
            ps.setInt(4, requerimiento.getDeptoOrigen().getIdDepartamento());
            ps.setInt(5, requerimiento.getDeptoAsignado().getIdDepartamento());
            ps.setInt(6, requerimiento.getEncargado().getIdEncargado());
            
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }  
    
    public int modificarRequerimiento(Requerimiento requerimiento) throws SQLException {
        try {
            String sentencia = "update requerimiento set estado=? where idrequerimiento=?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, requerimiento.isEstado() ? 1 : 0);
            ps.setInt(2, requerimiento.getIdRequerimiento());
            return ps.executeUpdate();
        } catch(Exception e) {
            return -1;
        } finally {
            desconectar();
        }
    }
}
