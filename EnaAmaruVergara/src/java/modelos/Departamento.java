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
public class Departamento {
    private int idDepartamento;
    private String nombre;
    private boolean prestaServicio;
    private Gerencia gerencia;

    public Departamento() {
    }

    public Departamento(int iddepartamento, String nombre, boolean presta_servicio, Gerencia gerencia) {
        this.idDepartamento = iddepartamento;
        this.nombre = nombre;
        this.prestaServicio = presta_servicio;
        this.gerencia = gerencia;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrestaServicio() {
        return prestaServicio;
    }

    public void setPrestaServicio(boolean prestaServicio) {
        this.prestaServicio = prestaServicio;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
