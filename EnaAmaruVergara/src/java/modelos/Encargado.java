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
public class Encargado {
    private int idEncargado;
    private String nombre;
    private String apellido;
    private Departamento departamento;

    public Encargado() {
    }

    public Encargado(int idencargado, String nombre, String apellido, Departamento departamento) {
        this.idEncargado = idencargado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.departamento = departamento;
    }

    public int getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(int idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    @Override
    public String toString() {
        return nombre+" "+apellido;
    }
    
}
