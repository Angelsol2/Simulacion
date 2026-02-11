package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Interfaz Simulacion = new Interfaz();
        Simulacion.setTitle("hola");
        Simulacion.setSize(800, 600);
        Simulacion.setLocationRelativeTo(null);
        Simulacion.setVisible(true);
        Simulacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
