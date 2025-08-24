package com.mycompany.fidnessapp;

import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuPrincipalFrame extends JFrame {
    public MenuPrincipalFrame(SistemaFidness sistema) {
        setTitle("Fidness - Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnEjercicios = new JButton("Consultar Ejercicios");
        add(btnEjercicios);

        btnEjercicios.addActionListener(e -> {
            new EjerciciosFrame(sistema).setVisible(true);
        });
    }
}
