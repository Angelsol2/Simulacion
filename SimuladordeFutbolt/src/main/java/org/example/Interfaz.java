package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame {
    JButton InicioSimulacion;
    JLabel Titulo;
    Image ImagenEstadio;
    JPanel centro;
    JPanel panel;

    public Interfaz() {
        FondoPanel fondo = new FondoPanel();
        this.setContentPane(fondo);
        this.setLayout(new BorderLayout());

        InicioSimulacion = new JButton("Iniciar");
        InicioSimulacion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        InicioSimulacion.setFocusPainted(false);
        InicioSimulacion.setBorderPainted(false);
        InicioSimulacion.setForeground(Color.WHITE);
        InicioSimulacion.setBackground(new Color(34, 139, 34));

        Titulo = new JLabel("Simulador de Futbolt");
        Titulo.setOpaque(true);
        Titulo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Titulo.setForeground(Color.WHITE);
        Titulo.setBackground(new Color(40, 40, 40));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createGlue());
        panel.add(Titulo);
        panel.add(Box.createVerticalStrut(15));
        panel.add(InicioSimulacion);
        panel.add(Box.createGlue());
        panel.setOpaque(false);
        Titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        InicioSimulacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(panel, BorderLayout.CENTER);


        class InicioOyente implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                Eventos Simulacion = new Eventos();
                Simulacion.setTitle("hola");
                Simulacion.setSize(800, 800);
                Simulacion.setLocationRelativeTo(null);
                Simulacion.setVisible(true);
                Simulacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Interfaz.this.dispose();
            }
        }
        InicioSimulacion.addActionListener(new InicioOyente());


    }

    class FondoPanel extends JPanel {
        private Image imagen;

        public FondoPanel() {
            try {
                imagen = new ImageIcon(getClass().getResource("/ImagenEsta.jpg")).getImage();
            } catch (Exception e) {
                System.out.println("No se encontró la imagen. Revisa la ruta.");
            }
            this.setOpaque(false);
            this.setLayout(new BorderLayout());
        }

        @Override
        public void paint(Graphics g) {
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
                this.setOpaque(false);
            }
            super.paint(g);
        }
    }
}
