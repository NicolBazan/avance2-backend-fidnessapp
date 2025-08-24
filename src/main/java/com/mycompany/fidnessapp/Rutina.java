package com.mycompany.fidnessapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Rutina implements Serializable {
    private String nombre;
    private ArrayList<Ejercicio> ejercicios;

    public Rutina(String nombre) {
        this.nombre = nombre;
        this.ejercicios = new ArrayList<>();
    }

    public void agregarEjercicio(Ejercicio e) {
        ejercicios.add(e);
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public String toString() {
        return "Rutina: " + nombre + " con " + ejercicios.size() + " ejercicios.";
    }
}
