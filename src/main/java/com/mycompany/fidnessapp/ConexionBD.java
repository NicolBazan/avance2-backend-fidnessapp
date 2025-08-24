package com.mycompany.fidnessapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:fidness.db"; // archivo de BD en el proyecto

    public static Connection conectar() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión a SQLite exitosa.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return conn;
    }
}
