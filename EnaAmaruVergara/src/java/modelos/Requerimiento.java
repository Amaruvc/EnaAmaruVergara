/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author amaru
 */
public class Requerimiento {
    private int idRequerimiento;
    private String descripcion;
    private boolean estado;
    private Departamento deptoOrigen;
    private Departamento deptoAsignado;
    private Encargado encargado;

    public Requerimiento() {
    }

    public Requerimiento(String descripcion, boolean estado, Departamento depto_origen, Departamento depto_asignado, Encargado encargado) {
    this.descripcion = descripcion;
    this.estado = estado;
    this.deptoOrigen = depto_origen;
    this.deptoAsignado = depto_asignado;
    this.encargado = encargado;
    }
    
    public Requerimiento(int idrequerimiento, String descripcion, boolean estado, Departamento depto_origen, Departamento depto_asignado, Encargado encargado) {
        this.idRequerimiento = idrequerimiento;
        this.descripcion = descripcion;
        this.estado = estado;
        this.deptoOrigen = depto_origen;
        this.deptoAsignado = depto_asignado;
        this.encargado = encargado;
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Departamento getDeptoOrigen() {
        return deptoOrigen;
    }

    public void setDeptoOrigen(Departamento deptoOrigen) {
        this.deptoOrigen = deptoOrigen;
    }

    public Departamento getDeptoAsignado() {
        return deptoAsignado;
    }

    public void setDeptoAsignado(Departamento deptoAsignado) {
        this.deptoAsignado = deptoAsignado;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }
    
}
