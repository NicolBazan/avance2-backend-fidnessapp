package com.mycompany.fidnessapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EjerciciosFrame extends JFrame {
    public EjerciciosFrame(SistemaFidness sistema) {
        setTitle("Ejercicios Disponibles");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JComboBox<String> comboMusculos = new JComboBox<>(new String[]{"Todos", "Pecho", "Piernas", "Brazos"});
        JTextArea area = new JTextArea();

        panel.add(comboMusculos, BorderLayout.NORTH);
        panel.add(new JScrollPane(area), BorderLayout.CENTER);
        add(panel);

        comboMusculos.addActionListener(e -> {
            String musculo = (String) comboMusculos.getSelectedItem();
            ArrayList<Ejercicio> lista = musculo.equals("Todos")
                    ? sistema.getEjercicios()
                    : sistema.getEjerciciosPorMusculo(musculo);
            area.setText("");
            for (Ejercicio ex : lista) {
                area.append(ex.toString() + "\n");
            }
        });
        comboMusculos.setSelectedIndex(0);
    }
}
