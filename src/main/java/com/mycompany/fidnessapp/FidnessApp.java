package com.mycompany.fidnessapp;

import javax.swing.SwingUtilities;

public class FidnessApp {
    public static void main(String[] args) {
        // ✅ Crear tablas en la base de datos al iniciar
        CrearTablas.crear();

        // ✅ Registrar usuario por defecto en la base de datos
        UsuarioDAO.registrarUsuario("Nicol Bazán", "nicol@fidness.com", "1234");

        // Iniciar la interfaz gráfica
        SwingUtilities.invokeLater(() -> new LoginFrame(new SistemaFidness()).setVisible(true));
    }
}
