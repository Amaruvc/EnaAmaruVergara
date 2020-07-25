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
public class Gerencia {
    private int idGerencia;
    private String nombre;

    public Gerencia() {
    }

    public Gerencia(int idgerencia, String nombre) {
        this.idGerencia = idgerencia;
        this.nombre = nombre;
    }

    public int getIdGerencia() {
        return idGerencia;
    }

    public void setIdGerencia(int idGerencia) {
        this.idGerencia = idGerencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
