package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimuladorFutbol extends JFrame {

    private JTextArea areaTexto;
    private JButton botonIniciar;
    private JComboBox<String> comboLocal, comboVisitante;
    private Timer timer;
    private int minuto;
    private int golesEquipo1, golesEquipo2;
    private int tarjetasAmarillasLocal, tarjetasAmarillasVisitante;
    private int tarjetasRojasLocal, tarjetasRojasVisitante;
    private Random random;

    public SimuladorFutbol() {
        setTitle("Simulador de Fútbol");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Lista de equipos mexicanos
        String[] equipos = {"América", "Chivas", "Cruz Azul", "Pumas", "Monterrey", "Tigres", "León", "Toluca"};

        // Panel superior para seleccionar los equipos
        JPanel panelEquipos = new JPanel();
        panelEquipos.setLayout(new GridLayout(2, 2));

        JLabel labelLocal = new JLabel("Equipo Local:");
        comboLocal = new JComboBox<>(equipos);
        JLabel labelVisitante = new JLabel("Equipo Visitante:");
        comboVisitante = new JComboBox<>(equipos);

        panelEquipos.add(labelLocal);
        panelEquipos.add(comboLocal);
        panelEquipos.add(labelVisitante);
        panelEquipos.add(comboVisitante);

        add(panelEquipos, BorderLayout.NORTH);

        // Configurar el área de texto para mostrar los eventos
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para iniciar el partido
        botonIniciar = new JButton("Iniciar Partido");
        add(botonIniciar, BorderLayout.SOUTH);

        random = new Random();

        // Acción al presionar el botón "Iniciar Partido"
        botonIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarPartido();
            }
        });
    }

    // Método para iniciar el partido
    private void iniciarPartido() {
        // Obtener los nombres de los equipos seleccionados
        String equipoLocal = (String) comboLocal.getSelectedItem();
        String equipoVisitante = (String) comboVisitante.getSelectedItem();

        // Verificar que los equipos no sean iguales
        if (equipoLocal.equals(equipoVisitante)) {
            areaTexto.setText("Los equipos local y visitante no pueden ser el mismo.\n");
            return;
        }

        areaTexto.setText("Inicia el partido entre " + equipoLocal + " y " + equipoVisitante + "...\n");
        minuto = 0;
        golesEquipo1 = 0;
        golesEquipo2 = 0;
        tarjetasAmarillasLocal = 0;
        tarjetasAmarillasVisitante = 0;
        tarjetasRojasLocal = 0;
        tarjetasRojasVisitante = 0;
        botonIniciar.setEnabled(false);

        // Configurar el temporizador para simular minuto a minuto
        timer = new Timer(500, new ActionListener() { // 500 ms representa un minuto simulado
            @Override
            public void actionPerformed(ActionEvent e) {
                simularMinuto();
            }
        });
        timer.start(); // Iniciar el temporizador para simular el partido
    }

    // Método para simular minuto a minuto
    private void simularMinuto() {
        minuto++;
        areaTexto.append("Minuto " + minuto + "...\n");

        // Simular un evento aleatorio en un minuto
        int evento = random.nextInt(100);
        if (evento < 5) { // 5% de probabilidad de gol normal
            if (random.nextBoolean()) {
                golesEquipo1++;
                areaTexto.append("¡Gol del equipo local! (Total: " + golesEquipo1 + ")\n");
            } else {
                golesEquipo2++;
                areaTexto.append("¡Gol del equipo visitante! (Total: " + golesEquipo2 + ")\n");
            }
        } else if (evento < 8) { // 3% de probabilidad de penal
            if (random.nextBoolean()) {
                areaTexto.append("¡Penal a favor del equipo local!\n");
                if (random.nextBoolean()) {
                    golesEquipo1++;
                    areaTexto.append("¡Gol de penal del equipo local! (Total: " + golesEquipo1 + ")\n");
                } else {
                    areaTexto.append("¡El portero visitante ataja el penal!\n");
                }
            } else {
                areaTexto.append("¡Penal a favor del equipo visitante!\n");
                if (random.nextBoolean()) {
                    golesEquipo2++;
                    areaTexto.append("¡Gol de penal del equipo visitante! (Total: " + golesEquipo2 + ")\n");
                } else {
                    areaTexto.append("¡El portero local ataja el penal!\n");
                }
            }
        } else if (evento < 12) { // 4% de probabilidad de tarjeta amarilla
            if (random.nextBoolean()) {
                tarjetasAmarillasLocal++;
                areaTexto.append("Tarjeta amarilla para un jugador del equipo local. (Total: " + tarjetasAmarillasLocal + ")\n");
            } else {
                tarjetasAmarillasVisitante++;
                areaTexto.append("Tarjeta amarilla para un jugador del equipo visitante. (Total: " + tarjetasAmarillasVisitante + ")\n");
            }
        } else if (evento < 14) { // 2% de probabilidad de tarjeta roja
            if (random.nextBoolean()) {
                tarjetasRojasLocal++;
                areaTexto.append("Tarjeta roja para un jugador del equipo local. (Total: " + tarjetasRojasLocal + ")\n");
            } else {
                tarjetasRojasVisitante++;
                areaTexto.append("Tarjeta roja para un jugador del equipo visitante. (Total: " + tarjetasRojasVisitante + ")\n");
            }
        } else if (evento < 16) { // 2% de probabilidad de gol de tiro libre
            if (random.nextBoolean()) {
                golesEquipo1++;
                areaTexto.append("¡Gol de tiro libre del equipo local! (Total: " + golesEquipo1 + ")\n");
            } else {
                golesEquipo2++;
                areaTexto.append("¡Gol de tiro libre del equipo visitante! (Total: " + golesEquipo2 + ")\n");
            }
        }

        // Finalizar el partido a los 90 minutos
        if (minuto == 90) {
            timer.stop();
            areaTexto.append("\n¡Final del partido!\n");
            String equipoLocal = (String) comboLocal.getSelectedItem();
            String equipoVisitante = (String) comboVisitante.getSelectedItem();

            areaTexto.append("Resultado Final: " + equipoLocal + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipoVisitante + "\n");
            areaTexto.append("Tarjetas amarillas - " + equipoLocal + ": " + tarjetasAmarillasLocal + ", " + equipoVisitante + ": " + tarjetasAmarillasVisitante + "\n");
            areaTexto.append("Tarjetas rojas - " + equipoLocal + ": " + tarjetasRojasLocal + ", " + equipoVisitante + ": " + tarjetasRojasVisitante + "\n");

            if (golesEquipo1 > golesEquipo2) {
                areaTexto.append("¡" + equipoLocal + " gana el partido!\n");
            } else if (golesEquipo1 < golesEquipo2) {
                areaTexto.append("¡" + equipoVisitante + " gana el partido!\n");
            } else {
                areaTexto.append("El partido termina en empate.\n");
            }
            botonIniciar.setEnabled(true); // Habilitar el botón para jugar otra vez
        }
    }

    public static void main(String[] args) {
        // Crear la ventana del simulador
        SimuladorFutbol simulador = new SimuladorFutbol();
        simulador.setVisible(true);
    }
}