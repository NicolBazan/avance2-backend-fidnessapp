package com.mycompany.fidnessapp;

import java.sql.*;

public class UsuarioDAO {

    public static boolean registrarUsuario(String nombre, String usuario, String password) {
        String sql = "INSERT INTO usuarios(nombre, usuario, password) VALUES(?,?,?)";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, usuario);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error registrando usuario: " + e.getMessage());
            return false;
        }
    }

    public static boolean validarLogin(String usuario, String password) {
        String sql = "SELECT * FROM usuarios WHERE usuario=? AND password=?";
        try (Connection conn = ConexionBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("❌ Error validando login: " + e.getMessage());
            return false;
        }
    }
}
