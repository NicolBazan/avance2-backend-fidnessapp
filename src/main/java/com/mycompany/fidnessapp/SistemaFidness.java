package com.mycompany.fidnessapp;

import java.util.*;

public class SistemaFidness {
    private HashMap<String, Usuario> usuarios;
    private ArrayList<Ejercicio> ejercicios;

    public SistemaFidness() {
        usuarios = new HashMap<>();
        ejercicios = new ArrayList<>();
        cargarEjercicios();
    }

    public void registrarUsuario(Usuario u) {
        usuarios.put(u.getCorreo(), u);
    }

    public Usuario autenticar(String correo, String contrasena) throws CredencialesInvalidasException {
        Usuario u = usuarios.get(correo);
        if (u != null && u.validarCredenciales(correo, contrasena)) {
            return u;
        } else {
            throw new CredencialesInvalidasException("Credenciales inválidas.");
        }
    }

    public ArrayList<Ejercicio> getEjerciciosPorMusculo(String musculo) {
        ArrayList<Ejercicio> filtrados = new ArrayList<>();
        for (Ejercicio e : ejercicios) {
            if (e.getMusculoTrabajado().equalsIgnoreCase(musculo)) {
                filtrados.add(e);
            }
        }
        return filtrados;
    }

    private void cargarEjercicios() {
        ejercicios.add(new Ejercicio("Press banca", "Ejercicio de pecho", "Pecho"));
        ejercicios.add(new Ejercicio("Sentadilla", "Ejercicio de piernas", "Piernas"));
        ejercicios.add(new Ejercicio("Curl biceps", "Ejercicio de brazos", "Brazos"));
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}
