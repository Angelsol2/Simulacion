package org.example;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class JugadoresNombres {
    Equipos equipoLocal = new Equipos();
    Equipos equipoVisitante = new Equipos();
    private static final String[] JUGADORES = {
            "Lionel Messi", "Cristiano Ronaldo", "Kylian Mbappé", "Erling Haaland", "Jude Bellingham",
            "Vinícius Jr.", "Kevin De Bruyne", "Harry Kane", "Mohamed Salah", "Robert Lewandowski",
            "Rodri", "Luka Modrić", "Neymar Jr.", "Virgil van Dijk", "Manuel Neuer",
            "Antoine Griezmann", "Toni Kroos", "Son Heung-min", "Lautaro Martínez", "Lamine Yamal",
            "Pelé", "Diego Maradona", "Johan Cruyff", "Zinedine Zidane", "Ronaldo Nazário",
            "Ronaldinho", "Paolo Maldini", "Franz Beckenbauer", "Andrés Iniesta", "Gianluigi Buffon"
    };

    public static String[] getJugadores() {
        return Arrays.copyOf(JUGADORES, JUGADORES.length);
    }

    public JugadoresNombres() {
        String[] nombresJugadores = JugadoresNombres.getJugadores();
        List<String> nombresList = Arrays.asList(nombresJugadores);
        Collections.shuffle(nombresList);
        int mitad = nombresList.size() / 2;

        for (int i = 0; i < mitad; i++) {
            agregarJugador(equipoLocal, nombresList.get(i));
        }
        for (int i = mitad; i < nombresList.size(); i++) {
            agregarJugador(equipoVisitante, nombresList.get(i));
        }
        System.out.println("=".repeat(100) + "\n");
        System.out.println(equipoLocal);
        System.out.println("=".repeat(100) + "\n");
        System.out.println(equipoVisitante);

    }

    private static void agregarJugador(Equipos equipo, String nombre) {
        if (!equipo.isPortero()) {
            // Este equipo aún no tiene portero, crear uno
            Portero porteroTemp = new Portero(nombre);
            porteroTemp.setRandomStats();  // Stats aleatorias (incluyendo saque y reflejos)
            equipo.setPortero(porteroTemp);

        } else {
            // Ya hay portero, crear jugador de campo
            Jugador jugadorTemp = new Jugador(nombre);
            jugadorTemp.setRandomStats();  // Stats aleatorias (5 básicas)

            // Intentar agregar como titular
            if (!equipo.setJugador(jugadorTemp)) {
                // No se pudo agregar (ya hay 10 titulares), va a reserva
                equipo.setReserva(jugadorTemp);
            }
        }
    }

    public Equipos getEquipoLocal() {
        return equipoLocal;
    }

    public Equipos getEquipoVisitante() {
        return equipoVisitante;
    }

}
