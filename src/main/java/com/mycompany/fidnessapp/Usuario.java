package com.mycompany.fidnessapp;

import java.io.Serializable;

public class Usuario extends Persona implements Serializable {
    private String contrasena;

    public Usuario(String nombre, String apellido, String correo, String contrasena) {
        super(nombre, apellido, correo);
        this.contrasena = contrasena;
    }

    public boolean validarCredenciales(String correo, String contrasena) {
        return this.correo.equals(correo) && this.contrasena.equals(contrasena);
    }

    @Override
    public void mostrarPerfil() {
        System.out.println(nombre + " " + apellido + " - " + correo);
    }
}
