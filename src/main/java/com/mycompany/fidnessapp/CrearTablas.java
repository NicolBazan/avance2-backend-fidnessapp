package com.mycompany.fidnessapp;

import java.sql.Connection;
import java.sql.Statement;

public class CrearTablas {
    public static void crear() {
        String sqlUsuarios = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "usuario TEXT NOT NULL UNIQUE," +
                "password TEXT NOT NULL);";

        String sqlRutinas = "CREATE TABLE IF NOT EXISTS rutinas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario_id INTEGER," +
                "descripcion TEXT," +
                "FOREIGN KEY(usuario_id) REFERENCES usuarios(id));";

        try (Connection conn = ConexionBD.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlUsuarios);
            stmt.execute(sqlRutinas);
            System.out.println("✅ Tablas creadas correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al crear tablas: " + e.getMessage());
        }
    }
}
