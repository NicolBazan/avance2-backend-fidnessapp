package com.mycompany.fidnessapp;

import java.io.Serializable;

public class Ejercicio implements Serializable {
    private String nombre;
    private String descripcion;
    private String musculoTrabajado;

    public Ejercicio(String nombre, String descripcion, String musculo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoTrabajado = musculo;
    }

    public String getMusculoTrabajado() {
        return musculoTrabajado;
    }

    public String toString() {
        return nombre + " - " + musculoTrabajado;
    }
}