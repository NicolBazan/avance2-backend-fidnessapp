package com.mycompany.fidnessapp;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LoginFrame extends JFrame {
    public LoginFrame(SistemaFidness sistema) {
        setTitle("Fidness - Inicio de Sesión");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField correoField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Ingresar");

        panel.add(new JLabel("Usuario:"));  // puedes dejar "Correo" si quieres
        panel.add(correoField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passField);
        panel.add(new JLabel());
        panel.add(loginBtn);

        add(panel);

        // Acción del botón de login usando UsuarioDAO
        loginBtn.addActionListener(e -> {
            String usuario = correoField.getText();
            String pass = new String(passField.getPassword());

            if (UsuarioDAO.validarLogin(usuario, pass)) {
                JOptionPane.showMessageDialog(this, "✅ Bienvenido " + usuario);
                new MenuPrincipalFrame(sistema).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Usuario o contraseña incorrectos");
            }
        });
    }
}
