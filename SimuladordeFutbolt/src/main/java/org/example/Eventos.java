package org.example;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Eventos extends JFrame {
    class EquipoLocal implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NombreGuardadoL = (String) EquiposLocales.getSelectedItem();
        }
    }

    class EquipoVisitante implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NombreGuardadoV = (String) EquiposVisitantes.getSelectedItem();
        }
    }

    class Activar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            iniciarPartido();
        }
    }

    private void estilizarLabel(JLabel label) {
        label.setForeground(new Color(255, 215, 0)); // dorado
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    JComboBox<String> EquiposLocales;
    JComboBox<String> EquiposVisitantes;

    JPanel PanelPadre;
    JPanel PanelHijoVisitantes;
    JPanel PanelHijoLocales;
    JPanel InformacionEquiposVisitantes;
    JPanel InformacionEquiposLocales;

    JLabel VelocidadVisitante;
    JLabel TiroVisitante;
    JLabel PaseVisitante;
    JLabel DefensaVisitante;
    JLabel FisicoVisitante;
    JLabel SaquesVisitante;
    JLabel DatoVelocidadVisitante;
    JLabel DatoTiroVisitante;
    JLabel DatoPaseVisitante;
    JLabel DatoDefensaVisitante;
    JLabel DatoFisicoVisitante;
    JLabel DatoSaquesVisitante;
    JLabel VelocidadLocal;
    JLabel TiroLocal;
    JLabel PaseLocal;
    JLabel DefensaLocal;
    JLabel FisicoLocal;
    JLabel SaquesLocal;

    JLabel GolesLocal;
    JLabel GolesVisitante;
    JLabel AmarrillasLocal;
    JLabel AmarillasVisitante;
    JLabel RojasLocal;
    JLabel RojasVisitante;

    JLabel DatoGolesLocal;
    JLabel DatoGolesVisitante;
    JLabel DatoAmarrillasLocal;
    JLabel DatoAmarillasVisitante;
    JLabel DatoRojasLocal;
    JLabel DatoRojasVisitante;

    JLabel DatoVelocidadLocal;
    JLabel DatoTiroLocal;
    JLabel DatoPaseLocal;
    JLabel DatoDefensaLocal;
    JLabel DatoFisicoLocal;
    JLabel DatoSaquesLocal;
    JLabel PenalLocal;
    JLabel DatoPenalLocal;

    JLabel PenalVisitante;
    JLabel DatoPenalVisitante;

    JLabel TirosLibresLocal;
    JLabel DatoTirosLibresLocal;

    JLabel TirosLibresVisitante;
    JLabel DatoTirosLibresVisitantes;

    public static String NombreGuardadoL;
    public static String NombreGuardadoV;

    JTextArea AreaEventos;
    JTextArea areaTexto;

    int golesEquipo1;
    int golesEquipo2;
    int tarjetasAmarillasLocal;
    int tarjetasAmarillasVisitante;
    int tarjetasRojasLocal;
    int tarjetasRojasVisitante;
    int TiroDeEsquinaLocal;
    int TiroDeEsquinaVisitane;
    int PenalesLocal;
    int PenalesVisitanes;
    int GolTiroLibreLocal;
    int GolTiroLibreVisitane;

    private int minuto;
    private Timer timer;
    private Random random;
    private JButton botonIniciar;

    int VelocidadL, TiroL, PaseL, DefensaL, ResistenciaL, SaqueL;
    int VelocidadV = 0, TiroV = 0, PaseV = 0, DefensaV = 0, ResistenciaV = 0, SaqueV = 0;

    JButton InfoJugadorL;
    JPanel panelSuperior;
    JPanel PanelIzquierda;
    JPanel PanelDerecho;
    JPanel PanelAbajo;

    class BotonInfo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NombreGuardadoL = (String) EquiposLocales.getSelectedItem();
            NombreGuardadoV = (String) EquiposVisitantes.getSelectedItem();
            if (NombreGuardadoL == null) NombreGuardadoL = "América";
            if (NombreGuardadoV == null) NombreGuardadoV = "Chivas";
            infoJugadores Jugadores = new infoJugadores(Eventos.this);
            Jugadores.setSize(1200, 600);
            Jugadores.setLocationRelativeTo(null);
            Jugadores.setVisible(true);
            Jugadores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Eventos.this.setVisible(false);
        }
    }

    public Eventos() {

        minuto = 0;
        golesEquipo1 = 0;
        golesEquipo2 = 0;
        tarjetasAmarillasLocal = 0;
        tarjetasAmarillasVisitante = 0;
        tarjetasRojasLocal = 0;
        tarjetasRojasVisitante = 0;
        TiroDeEsquinaLocal = 0;
        TiroDeEsquinaVisitane = 0;
        PenalesLocal = 0;
        PenalesVisitanes = 0;
        GolTiroLibreLocal = 0;
        GolTiroLibreVisitane = 0;

        Color fondoOscuro = new Color(33, 33, 33);
        Color textoClaro = new Color(236, 240, 241);
        Color textoDorado = new Color(255, 215, 0);

        this.setLayout(new BorderLayout());

        String[] equipos = {"América", "Chivas", "Cruz Azul", "Pumas", "Monterrey", "Tigres", "León", "Toluca"};

        JLabel Local = new JLabel("Equipo Local");
        Local.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Local.setForeground(new Color(230, 230, 230));
        Local.setBackground(new Color(40, 40, 40));
        Local.setOpaque(false);

        JLabel Visitante = new JLabel("EquipoVisitante");
        Visitante.setFont(new Font("Segoe UI", Font.BOLD, 14));
        Visitante.setForeground(new Color(230, 230, 230));
        Visitante.setBackground(new Color(40, 40, 40));
        Visitante.setOpaque(false);

        EquiposLocales = new JComboBox<>(equipos);
        EquiposLocales.setBorder(null);
        EquiposLocales.setPreferredSize(new Dimension(350, 55));
        EquiposLocales.setMaximumSize(new Dimension(350, 55));
        EquiposLocales.setFont(new Font("Arial", Font.BOLD, 18));
        EquiposLocales.setForeground(Color.WHITE);
        EquiposLocales.setBackground(new Color(0, 120, 255));
        EquiposLocales.setFocusable(false);
        EquiposLocales.addActionListener(new EquipoLocal());

        EquiposVisitantes = new JComboBox<>(equipos);
        EquiposVisitantes.setMaximumSize(new Dimension(350, 55));
        EquiposVisitantes.setPreferredSize(new Dimension(350, 55));
        EquiposVisitantes.setFont(new Font("Arial", Font.BOLD, 18));
        EquiposVisitantes.setForeground(Color.WHITE);
        EquiposVisitantes.setBackground(new Color(0, 120, 255));
        EquiposVisitantes.setFocusable(false);
        EquiposVisitantes.setBorder(null);
        EquiposVisitantes.addActionListener(new EquipoVisitante());

        AreaEventos = new JTextArea();

        PanelHijoLocales = new JPanel();
        PanelHijoLocales.setLayout(new BoxLayout(PanelHijoLocales, BoxLayout.Y_AXIS));
        PanelHijoLocales.setOpaque(false);

        PanelHijoVisitantes = new JPanel();
        PanelHijoVisitantes.setLayout(new BoxLayout(PanelHijoVisitantes, BoxLayout.Y_AXIS));
        PanelHijoVisitantes.setOpaque(false);

        InformacionEquiposVisitantes = new JPanel();
        InformacionEquiposVisitantes.setOpaque(false);
        InformacionEquiposVisitantes.setLayout(new GridLayout(0, 6));

        InformacionEquiposLocales = new JPanel();
        InformacionEquiposLocales.setLayout(new BoxLayout(InformacionEquiposLocales, BoxLayout.Y_AXIS));
        InformacionEquiposLocales.setOpaque(false);

        panelSuperior = new JPanel(new GridLayout(1, 3));
        panelSuperior.setOpaque(false);

        PanelPadre = new PanelConImagen("/ImagenEquipo.jpg");
        PanelPadre.setLayout(new BorderLayout());


        VelocidadVisitante = new JLabel("Velocidad");
        TiroVisitante = new JLabel("Tiro");
        PaseVisitante = new JLabel("Pase");
        DefensaVisitante = new JLabel("Defensa");
        FisicoVisitante = new JLabel("Resistencia");
        SaquesVisitante = new JLabel("Saques");

        DatoVelocidadVisitante = new JLabel(String.valueOf(VelocidadV));
        DatoTiroVisitante = new JLabel(String.valueOf(TiroV));
        DatoPaseVisitante = new JLabel(String.valueOf(PaseV));
        DatoDefensaVisitante = new JLabel(String.valueOf(DefensaV));
        DatoFisicoVisitante = new JLabel(String.valueOf(ResistenciaV));
        DatoSaquesVisitante = new JLabel(String.valueOf(SaqueV));

        // Inicialización Labels Local
        VelocidadLocal = new JLabel("Velocidad");
        TiroLocal = new JLabel("Tiro");
        PaseLocal = new JLabel("Pase");
        DefensaLocal = new JLabel("Defensa");
        FisicoLocal = new JLabel("Resistencia");
        SaquesLocal = new JLabel("Saques");

        VelocidadLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        TiroLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        PaseLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        DefensaLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        FisicoLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        SaquesLocal.setAlignmentX(Component.CENTER_ALIGNMENT);
        estilizarLabel(VelocidadLocal);
        estilizarLabel(TiroLocal);
        estilizarLabel(PaseLocal);
        estilizarLabel(DefensaLocal);
        estilizarLabel(FisicoLocal);
        estilizarLabel(SaquesLocal);

        DatoVelocidadLocal = new JLabel(String.valueOf(VelocidadL));
        DatoTiroLocal = new JLabel(String.valueOf(TiroL));
        DatoPaseLocal = new JLabel(String.valueOf(PaseL));
        DatoDefensaLocal = new JLabel(String.valueOf(DefensaL));
        DatoFisicoLocal = new JLabel(String.valueOf(ResistenciaL));
        DatoSaquesLocal = new JLabel(String.valueOf(SaqueL));

        InfoJugadorL = new JButton("Cambiar Modo");
        InfoJugadorL.addActionListener(new BotonInfo() {});

        PanelHijoLocales.add(Local);
        PanelHijoLocales.add(Box.createVerticalStrut(5));
        PanelHijoLocales.add(EquiposLocales);
        PanelHijoLocales.add(Box.createVerticalStrut(20));
        PanelHijoLocales.add(Box.createVerticalGlue());
        PanelHijoLocales.setOpaque(false);

        PanelHijoVisitantes.add(Visitante);
        PanelHijoVisitantes.add(Box.createVerticalStrut(5));
        PanelHijoVisitantes.add(EquiposVisitantes);
        PanelHijoVisitantes.add(Box.createGlue());
        PanelHijoVisitantes.add(Box.createVerticalStrut(20));

        panelSuperior.add(PanelHijoLocales);
        panelSuperior.add(InformacionEquiposLocales);
        panelSuperior.add(PanelHijoVisitantes);

        PanelPadre.setPreferredSize(new Dimension(800, 200));
        PanelPadre.add(panelSuperior);
        PanelPadre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        PanelPadre.setOpaque(false);

        this.add(PanelPadre, BorderLayout.NORTH);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        botonIniciar = new JButton("Iniciar Partido");
        botonIniciar.addActionListener(new Activar());


        PanelIzquierda = new JPanel();
        PanelIzquierda.setLayout(new GridLayout(0, 2));
        PanelIzquierda.setBackground(fondoOscuro);

        GolesLocal = new JLabel("Goles");
        GolesLocal.setForeground(textoClaro);
        DatoGolesLocal = new JLabel(String.valueOf(golesEquipo1));
        DatoGolesLocal.setForeground(textoDorado);

        AmarrillasLocal = new JLabel("Amarillas");
        AmarrillasLocal.setForeground(textoClaro);
        DatoAmarrillasLocal = new JLabel(String.valueOf(tarjetasAmarillasLocal));
        DatoAmarrillasLocal.setForeground(new Color(241, 196, 15));

        RojasLocal = new JLabel("Rojas");
        RojasLocal.setForeground(textoClaro);
        DatoRojasLocal = new JLabel(String.valueOf(tarjetasRojasLocal));
        DatoRojasLocal.setForeground(new Color(231, 76, 60));

        PenalLocal = new JLabel("Penales");
        PenalLocal.setForeground(textoClaro);
        DatoPenalLocal = new JLabel(String.valueOf(PenalesLocal));
        DatoPenalLocal.setForeground(new Color(0, 255, 255)); // Cian

        TirosLibresLocal = new JLabel("TirosLibres");
        TirosLibresLocal.setForeground(textoClaro);
        DatoTirosLibresLocal = new JLabel(String.valueOf(TiroDeEsquinaLocal));
        DatoTirosLibresLocal.setForeground(new Color(46, 204, 113));

        PanelIzquierda.add(GolesLocal);
        PanelIzquierda.add(DatoGolesLocal);
        PanelIzquierda.add(AmarrillasLocal);
        PanelIzquierda.add(DatoAmarrillasLocal);
        PanelIzquierda.add(RojasLocal);
        PanelIzquierda.add(DatoRojasLocal);
        PanelIzquierda.add(PenalLocal);
        PanelIzquierda.add(DatoPenalLocal);
        PanelIzquierda.add(TirosLibresLocal);
        PanelIzquierda.add(DatoTirosLibresLocal);

        this.add(PanelIzquierda, BorderLayout.WEST);


        PanelDerecho = new JPanel();
        PanelDerecho.setLayout(new GridLayout(0, 2));
        PanelDerecho.setBackground(fondoOscuro);

        GolesVisitante = new JLabel("Goles");
        GolesVisitante.setForeground(textoClaro);
        DatoGolesVisitante = new JLabel(String.valueOf(golesEquipo2));
        DatoGolesVisitante.setForeground(textoDorado);

        AmarillasVisitante = new JLabel("Amarillas");
        AmarillasVisitante.setForeground(textoClaro);
        DatoAmarillasVisitante = new JLabel(String.valueOf(tarjetasAmarillasVisitante));
        DatoAmarillasVisitante.setForeground(new Color(241, 196, 15));

        RojasVisitante = new JLabel("Rojas");
        RojasVisitante.setForeground(textoClaro);
        DatoRojasVisitante = new JLabel(String.valueOf(tarjetasRojasVisitante));
        DatoRojasVisitante.setForeground(new Color(231, 76, 60));

        PenalVisitante = new JLabel("Penales");
        PenalVisitante.setForeground(textoClaro);
        DatoPenalVisitante = new JLabel(String.valueOf(PenalesVisitanes));
        DatoPenalVisitante.setForeground(new Color(0, 255, 255));

        TirosLibresVisitante = new JLabel("TirosLibres");
        TirosLibresVisitante.setForeground(textoClaro);
        DatoTirosLibresVisitantes = new JLabel(String.valueOf(TiroDeEsquinaVisitane));
        DatoTirosLibresVisitantes.setForeground(new Color(46, 204, 113));

        PanelDerecho.add(GolesVisitante);
        PanelDerecho.add(DatoGolesVisitante);
        PanelDerecho.add(AmarillasVisitante);
        PanelDerecho.add(DatoAmarillasVisitante);
        PanelDerecho.add(RojasVisitante);
        PanelDerecho.add(DatoRojasVisitante);
        PanelDerecho.add(PenalVisitante);
        PanelDerecho.add(DatoPenalVisitante);
        PanelDerecho.add(TirosLibresVisitante);
        PanelDerecho.add(DatoTirosLibresVisitantes);

        this.add(PanelDerecho, BorderLayout.EAST);

        PanelAbajo = new JPanel(new BorderLayout());
        PanelAbajo.setBackground(fondoOscuro);
        PanelAbajo.setPreferredSize(new Dimension(800, 280));
        PanelAbajo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel PanelStats = new JPanel(new GridLayout(0, 3, 10, 8));
        PanelStats.setBackground(fondoOscuro);


        TitledBorder bordeStats = BorderFactory.createTitledBorder("Comparativa de Equipos");
        bordeStats.setTitleColor(textoDorado);
        bordeStats.setTitleFont(new Font("Segoe UI", Font.BOLD, 14));
        bordeStats.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
        PanelStats.setBorder(bordeStats);


        Font fuenteNombre = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteNumero = new Font("Segoe UI", Font.BOLD, 14);


        DatoVelocidadLocal.setForeground(textoDorado);
        DatoVelocidadLocal.setFont(fuenteNumero);
        DatoVelocidadLocal.setHorizontalAlignment(SwingConstants.CENTER);

        VelocidadLocal.setText("Velocidad");
        VelocidadLocal.setForeground(textoClaro);
        VelocidadLocal.setFont(fuenteNombre);
        VelocidadLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoVelocidadVisitante.setForeground(textoDorado);
        DatoVelocidadVisitante.setFont(fuenteNumero);
        DatoVelocidadVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoVelocidadLocal);
        PanelStats.add(VelocidadLocal);
        PanelStats.add(DatoVelocidadVisitante);


        DatoTiroLocal.setForeground(textoDorado);
        DatoTiroLocal.setFont(fuenteNumero);
        DatoTiroLocal.setHorizontalAlignment(SwingConstants.CENTER);

        TiroLocal.setText("Tiro");
        TiroLocal.setForeground(textoClaro);
        TiroLocal.setFont(fuenteNombre);
        TiroLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoTiroVisitante.setForeground(textoDorado);
        DatoTiroVisitante.setFont(fuenteNumero);
        DatoTiroVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoTiroLocal);
        PanelStats.add(TiroLocal);
        PanelStats.add(DatoTiroVisitante);


        DatoPaseLocal.setForeground(textoDorado);
        DatoPaseLocal.setFont(fuenteNumero);
        DatoPaseLocal.setHorizontalAlignment(SwingConstants.CENTER);

        PaseLocal.setText("Pase");
        PaseLocal.setForeground(textoClaro);
        PaseLocal.setFont(fuenteNombre);
        PaseLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoPaseVisitante.setForeground(textoDorado);
        DatoPaseVisitante.setFont(fuenteNumero);
        DatoPaseVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoPaseLocal);
        PanelStats.add(PaseLocal);
        PanelStats.add(DatoPaseVisitante);

        DatoDefensaLocal.setForeground(textoDorado);
        DatoDefensaLocal.setFont(fuenteNumero);
        DatoDefensaLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DefensaLocal.setText("Defensa");
        DefensaLocal.setForeground(textoClaro);
        DefensaLocal.setFont(fuenteNombre);
        DefensaLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoDefensaVisitante.setForeground(textoDorado);
        DatoDefensaVisitante.setFont(fuenteNumero);
        DatoDefensaVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoDefensaLocal);
        PanelStats.add(DefensaLocal);
        PanelStats.add(DatoDefensaVisitante);


        DatoFisicoLocal.setForeground(textoDorado);
        DatoFisicoLocal.setFont(fuenteNumero);
        DatoFisicoLocal.setHorizontalAlignment(SwingConstants.CENTER);

        FisicoLocal.setText("Resistencia");
        FisicoLocal.setForeground(textoClaro);
        FisicoLocal.setFont(fuenteNombre);
        FisicoLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoFisicoVisitante.setForeground(textoDorado);
        DatoFisicoVisitante.setFont(fuenteNumero);
        DatoFisicoVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoFisicoLocal);
        PanelStats.add(FisicoLocal);
        PanelStats.add(DatoFisicoVisitante);

        DatoSaquesLocal.setForeground(textoDorado);
        DatoSaquesLocal.setFont(fuenteNumero);
        DatoSaquesLocal.setHorizontalAlignment(SwingConstants.CENTER);

        SaquesLocal.setText("Saques");
        SaquesLocal.setForeground(textoClaro);
        SaquesLocal.setFont(fuenteNombre);
        SaquesLocal.setHorizontalAlignment(SwingConstants.CENTER);

        DatoSaquesVisitante.setForeground(textoDorado);
        DatoSaquesVisitante.setFont(fuenteNumero);
        DatoSaquesVisitante.setHorizontalAlignment(SwingConstants.CENTER);

        PanelStats.add(DatoSaquesLocal);
        PanelStats.add(SaquesLocal);
        PanelStats.add(DatoSaquesVisitante);


        JPanel Botones = new JPanel();
        Botones.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 10));
        Botones.setBackground(fondoOscuro);


        botonIniciar.setBackground(new Color(46, 204, 113));
        botonIniciar.setForeground(Color.WHITE);
        botonIniciar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonIniciar.setFocusPainted(false);
        botonIniciar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        InfoJugadorL.setBackground(new Color(52, 152, 219));
        InfoJugadorL.setForeground(Color.WHITE);
        InfoJugadorL.setFont(new Font("Segoe UI", Font.BOLD, 14));
        InfoJugadorL.setFocusPainted(false);
        InfoJugadorL.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        Botones.add(botonIniciar);
        Botones.add(InfoJugadorL);

        PanelAbajo.add(PanelStats, BorderLayout.CENTER);
        PanelAbajo.add(Botones, BorderLayout.SOUTH);

        this.add(PanelAbajo, BorderLayout.SOUTH);
    }

    private void iniciarPartido() {
        String equipoLocal = (String) EquiposLocales.getSelectedItem();
        String equipoVisitante = (String) EquiposVisitantes.getSelectedItem();

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
        random = new Random();
        botonIniciar.setEnabled(false);

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simularMinuto();
            }
        });
        timer.start();
    }

    private void simularMinuto() {
        minuto++;
        areaTexto.append("Minuto " + minuto + "...\n");
        int evento = random.nextInt(100);

        if (evento < 5) {
            if (random.nextBoolean()) {
                golesEquipo1++;
                DatoGolesLocal.setText(String.valueOf(golesEquipo1));
                areaTexto.append("¡Gol del equipo local! (Total: " + golesEquipo1 + ")\n");
            } else {
                golesEquipo2++;
                DatoGolesVisitante.setText(String.valueOf(golesEquipo2));
                areaTexto.append("¡Gol del equipo visitante! (Total: " + golesEquipo2 + ")\n");
            }
        } else if (evento < 8) {
            if (random.nextBoolean()) {
                areaTexto.append("¡Penal a favor del equipo local!\n");
                if (random.nextBoolean()) {
                    golesEquipo1++;
                    PenalesLocal++;
                    DatoPenalLocal.setText(String.valueOf(PenalesLocal));
                    areaTexto.append("¡Gol de penal del equipo local! (Total: " + golesEquipo1 + ")\n");
                } else {
                    areaTexto.append("¡El portero visitante ataja el penal!\n");
                }
            } else {
                areaTexto.append("¡Penal a favor del equipo visitante!\n");
                if (random.nextBoolean()) {
                    golesEquipo2++;
                    PenalesVisitanes++;
                    DatoPenalVisitante.setText(String.valueOf(PenalesVisitanes));
                    DatoGolesVisitante.setText(String.valueOf(golesEquipo2));
                    areaTexto.append("¡Gol de penal del equipo visitante! (Total: " + golesEquipo2 + ")\n");
                } else {
                    areaTexto.append("¡El portero local ataja el penal!\n");
                }
            }
        } else if (evento < 12) {
            if (random.nextBoolean()) {
                tarjetasAmarillasLocal++;
                DatoAmarrillasLocal.setText(String.valueOf(tarjetasAmarillasLocal));
                areaTexto.append("Tarjeta amarilla para un jugador del equipo local. (Total: " + tarjetasAmarillasLocal + ")\n");
            } else {
                tarjetasAmarillasVisitante++;
                DatoAmarillasVisitante.setText(String.valueOf(tarjetasAmarillasVisitante));
                areaTexto.append("Tarjeta amarilla para un jugador del equipo visitante. (Total: " + tarjetasAmarillasVisitante + ")\n");
            }
        } else if (evento < 14) {
            if (random.nextBoolean()) {
                tarjetasRojasLocal++;
                DatoRojasLocal.setText(String.valueOf(tarjetasRojasLocal));
                areaTexto.append("Tarjeta roja para un jugador del equipo local. (Total: " + tarjetasRojasLocal + ")\n");
            } else {
                tarjetasRojasVisitante++;
                DatoRojasVisitante.setText(String.valueOf(tarjetasRojasVisitante));
                areaTexto.append("Tarjeta roja para un jugador del equipo visitante. (Total: " + tarjetasRojasVisitante + ")\n");
            }
        } else if (evento < 16) {
            if (random.nextBoolean()) {
                golesEquipo1++;
                TiroDeEsquinaLocal++;
                DatoGolesLocal.setText(String.valueOf(golesEquipo1));
                DatoTirosLibresLocal.setText(String.valueOf(TiroDeEsquinaLocal));
                areaTexto.append("¡Gol de tiro libre del equipo local! (Total: " + golesEquipo1 + ")\n");
            } else {
                golesEquipo2++;
                TiroDeEsquinaVisitane++;
                DatoGolesVisitante.setText(String.valueOf(golesEquipo2));
                DatoTirosLibresVisitantes.setText(String.valueOf(TiroDeEsquinaVisitane));
                areaTexto.append("¡Gol de tiro libre del equipo visitante! (Total: " + golesEquipo2 + ")\n");
            }
        }

        if (minuto == 90) {
            timer.stop();
            areaTexto.append("\n¡Final del partido!\n");
            String equipoLocal = (String) EquiposLocales.getSelectedItem();
            String equipoVisitante = (String) EquiposVisitantes.getSelectedItem();

            areaTexto.append("Resultado Final: " + equipoLocal + " " + golesEquipo1 + " - " + golesEquipo2 + " " + equipoVisitante + "\n");
            if (golesEquipo1 > golesEquipo2) {
                areaTexto.append("¡" + equipoLocal + " gana el partido!\n");
            } else if (golesEquipo1 < golesEquipo2) {
                areaTexto.append("¡" + equipoVisitante + " gana el partido!\n");
            } else {
                areaTexto.append("El partido termina en empate.\n");
            }
            botonIniciar.setEnabled(true);
        }
    }

    class PanelConImagen extends JPanel {
        private Image imagen;

        public PanelConImagen(String ruta) {
            try {
                imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
            } catch (Exception e) {
                System.out.println("Imagen no encontrada: " + ruta);
            }
            this.setLayout(new BorderLayout());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}