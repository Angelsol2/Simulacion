package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class infoJugadores extends JFrame {
    JPanel SubPanelV;
    JPanel SubPanel;
    JugadoresNombres Jugador;
    Equipos equipoLocal;
    Equipos equipoVisitante;
    FormacionEquipos Formacion;
    Equipos Equipo;

    JLabel FormacionLocal;
    JLabel FormacionVisitante;
    JLabel ManagerL;
    JLabel ManagerV;
    String[] nombresJugadores;
    Jugador[] nombresListLocal;
    Jugador[] nombresListVisitante;
    Jugador[] SuplentesLocal;
    Jugador[] SuplentesVisitantes;
    DefaultTableModel modeloLocal;
    DefaultTableModel modeLoVisitante;
    DefaultTableModel SustitucionesLocales;
    DefaultTableModel SustitucionesVisitante;
    DefaultTableModel modeloVisitante;
    JTable TablaLocalC;
    static JTable TablaLocalV;
    JTable TablaLocal;
    JTable TablaVisitante;
    JPanel unionArriba;
    JPanel unionVisitantes;
    JPanel PanelHijoIzquierdo;
    JPanel PanelHijoIDerecho;
    JPanel PanelPrincipal;
    JLabel EquipoLocal;
    JLabel EquipoVisitante;
    JButton CambioModo;
    JFrame ventanaAnterior;

    private void ajustarAlturaTabla(JTable tabla) {

        int filas = tabla.getRowCount();
        int altoFila = tabla.getRowHeight();
        int altoHeader = tabla.getTableHeader().getPreferredSize().height;

        int alturaExacta = (filas * altoFila) + altoHeader + 5;


    }


    public infoJugadores(JFrame anterior) {
        this.ventanaAnterior = anterior;
        this.setLayout(new BorderLayout());


        Jugador = new JugadoresNombres();
        equipoLocal = Jugador.getEquipoLocal();
        equipoVisitante = Jugador.getEquipoVisitante();

        Formacion = new FormacionEquipos();
        Equipo = new Equipos();
        CambioModo = new JButton("CambioModo");
        CambioModo.addActionListener(new BotonRegreso());

        EquipoLocal = new JLabel(Eventos.NombreGuardadoL);
        EquipoVisitante = new JLabel(Eventos.NombreGuardadoV);


        FormacionLocal = new JLabel(Formacion.getFormacionActualLocal());
        FormacionLocal.setFont(new Font("Arial", Font.BOLD, 72));

        FormacionVisitante = new JLabel(Formacion.getFormacionActualVisitante());
        FormacionVisitante.setFont(new Font("Arial", Font.BOLD, 72));

        ManagerL = new JLabel("Manager");
        ManagerV = new JLabel("Manager");

        nombresJugadores = JugadoresNombres.getJugadores();
        nombresListLocal = equipoLocal.getJugadores();
        nombresListVisitante = equipoVisitante.getJugadores();
        SuplentesLocal = equipoLocal.getReserva();
        SuplentesVisitantes = equipoVisitante.getReserva();


        modeloLocal = new DefaultTableModel();
        modeLoVisitante = new DefaultTableModel();

        SustitucionesLocales = new DefaultTableModel(0, 0);
        TablaLocalC = new JTable(SustitucionesLocales);
        TablaLocalC.setShowGrid(false);
        TablaLocalC.setRowHeight(30);
        SustitucionesLocales.addColumn("Suplentes");
        for (int i = 0; i < SuplentesLocal.length; i++) {
            Jugador j = SuplentesLocal[i];
            Object[] fila = {
                    j.getNombre()
            };
            SustitucionesLocales.addRow(fila);
        }
        ajustarAlturaTabla(TablaLocalC);

        SustitucionesVisitante = new DefaultTableModel(0, 0);
        TablaLocalV = new JTable(SustitucionesVisitante);
        TablaLocalV.setRowHeight(30);
        TablaLocalV.setShowGrid(false);
        SustitucionesVisitante.addColumn("Suplentes");
        for (int i = 0; i < SuplentesVisitantes.length; i++) {
            Jugador j = SuplentesVisitantes[i];
            Object[] fila = {
                    j.getNombre()
            };

            SustitucionesVisitante.addRow(fila);
        }
        ajustarAlturaTabla(TablaLocalV);


        modeloLocal.addColumn("Nombre");
        modeloLocal.addColumn("Vel");
        modeloLocal.addColumn("Tiro");
        modeloLocal.addColumn("Pase");
        modeloLocal.addColumn("Def");
        modeloLocal.addColumn("Fis");
        modeloLocal.addColumn("Dorsal");
        modeloLocal.addColumn("Posición");

        TablaLocal = new JTable(modeloLocal);
        TablaLocal.setShowGrid(false);
        for (int i = 0; i < nombresListLocal.length; i++) {
            Jugador j = nombresListLocal[i];
            Object[] fila = {
                    j.getNombre(),
                    j.getVelocidad(),
                    j.getTiro(),
                    j.getPase(),
                    j.getDefensa(),
                    j.getFisico(),
                    j.getDorsal(),
                    j.getPosicion() != null ? j.getPosicion().toString() : "N/A"


            };
            modeloLocal.addRow(fila);
        }
        ajustarAlturaTabla(TablaLocal);
        modeloVisitante = new DefaultTableModel();


        modeloVisitante.addColumn("Nombre");
        modeloVisitante.addColumn("Vel");
        modeloVisitante.addColumn("Tiro");
        modeloVisitante.addColumn("Pase");
        modeloVisitante.addColumn("Def");
        modeloVisitante.addColumn("Fis");
        modeloVisitante.addColumn("Dorsal");
        modeloVisitante.addColumn("Posición");

        TablaVisitante = new JTable(modeloVisitante);
        TablaVisitante.setShowGrid(false);

        for (int i = 0; i < nombresListVisitante.length; i++) {
            Jugador j = nombresListVisitante[i];
            Object[] fila = {
                    j.getNombre(),
                    j.getVelocidad(),
                    j.getTiro(),
                    j.getPase(),
                    j.getDefensa(),
                    j.getFisico(),
                    j.getDorsal(),
                    j.getPosicion() != null ? j.getPosicion().toString() : "N/A"

            };
            modeloVisitante.addRow(fila);

        }
        ajustarAlturaTabla(TablaVisitante);

        unionArriba = new JPanel();
        unionVisitantes = new JPanel();
        PanelHijoIzquierdo = new JPanel();
        PanelHijoIDerecho = new JPanel();
        PanelPrincipal = new JPanel();
        SubPanel = new JPanel();
        SubPanelV = new JPanel();


        unionArriba.setLayout(new BoxLayout(unionArriba, BoxLayout.X_AXIS));
        unionVisitantes.setLayout(new BoxLayout(unionVisitantes, BoxLayout.X_AXIS));
        PanelHijoIzquierdo.setLayout(new BoxLayout(PanelHijoIzquierdo, BoxLayout.Y_AXIS));
        PanelHijoIDerecho.setLayout(new BoxLayout(PanelHijoIDerecho, BoxLayout.Y_AXIS));
        PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal, BoxLayout.X_AXIS));
        SubPanel.setLayout(new BoxLayout(SubPanel, BoxLayout.Y_AXIS));
        SubPanelV.setLayout(new BoxLayout(SubPanelV, BoxLayout.Y_AXIS));

        PanelHijoIzquierdo.add(EquipoLocal);
        PanelHijoIzquierdo.add(FormacionLocal);
        PanelHijoIzquierdo.add(Box.createVerticalStrut(15));
        PanelHijoIzquierdo.add(TablaLocal.getTableHeader());
        PanelHijoIzquierdo.add(Box.createVerticalStrut(15));
        PanelHijoIzquierdo.add(TablaLocal);
        PanelHijoIzquierdo.add(Box.createVerticalStrut(50));
        PanelHijoIzquierdo.add(TablaLocalC.getTableHeader());
        PanelHijoIzquierdo.add(Box.createVerticalStrut(15));
        PanelHijoIzquierdo.add(TablaLocalC);
        PanelHijoIzquierdo.add(Box.createVerticalStrut(15));
        ;
        PanelHijoIzquierdo.add(ManagerL);


        PanelHijoIDerecho.add(EquipoVisitante);
        PanelHijoIDerecho.add(FormacionVisitante);
        PanelHijoIDerecho.add(Box.createVerticalStrut(15));
        PanelHijoIDerecho.add(TablaVisitante.getTableHeader());
        PanelHijoIDerecho.add(Box.createVerticalStrut(15));
        PanelHijoIDerecho.add(TablaVisitante);
        PanelHijoIDerecho.add(Box.createVerticalStrut(50));
        PanelHijoIDerecho.add(TablaLocalV.getTableHeader());
        PanelHijoIDerecho.add(Box.createVerticalStrut(15));
        PanelHijoIDerecho.add(TablaLocalV);
        PanelHijoIDerecho.add(Box.createVerticalStrut(15));
        ;
        PanelHijoIDerecho.add(ManagerV);


        PanelPrincipal.add(PanelHijoIzquierdo);
        PanelPrincipal.add(CambioModo);
        PanelPrincipal.add(Box.createHorizontalStrut(80));
        PanelPrincipal.add(PanelHijoIDerecho);
        this.add(PanelPrincipal, BorderLayout.CENTER);


    }

    class BotonRegreso implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            infoJugadores.this.dispose();

            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);

            }
        }


    }
}