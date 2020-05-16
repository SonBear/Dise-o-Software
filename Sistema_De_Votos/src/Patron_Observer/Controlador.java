/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_Observer;

import Patron_Observer.Observer.GeneradorCSV;
import Patron_Observer.Observer.GraficaBarras;
import Patron_Observer.Observer.GraficaPastel;
import Patron_Observer.Subject.MenuDeVotos;
import Patron_Observer.Subject.SistemaVotos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener {

    private MenuDeVotos menu;
    private GraficaBarras graficaBarras;
    private GraficaPastel graficaPastel;
    private GeneradorCSV generadorCSV;

    public Controlador() {
        menu = new MenuDeVotos();
        graficaBarras = new GraficaBarras();
        graficaPastel = new GraficaPastel();
        generadorCSV = new GeneradorCSV();
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        menu.getVotar1().addActionListener(this);
        menu.getVotar2().addActionListener(this);
        menu.getVotar3().addActionListener(this);

        menu.getSistemaVotos().añadirObservador(generadorCSV);
        menu.getSistemaVotos().añadirObservador(graficaBarras);
        menu.getSistemaVotos().añadirObservador(graficaPastel);
        graficaBarras.setTitle("Grafica Barras");
        graficaPastel.setTitle("Grafica Pastel");
    }

    public void iniciar() {

        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        graficaBarras.setVisible(true);
        graficaPastel.setVisible(true);

    }

    public void actualizarDatos(int votos_1, int votos_2, int votos_3) {
        graficaBarras.actualizarDatos(votos_1, votos_2, votos_3);
        graficaPastel.actualizarDatos(votos_1, votos_2, votos_3);
        generadorCSV.actualizarDatos(votos_1, votos_2, votos_3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SistemaVotos si = menu.getSistemaVotos();
        switch (e.getActionCommand()) {
            case "voto1":

                si.addVoto1();
                actualizarDatos(si.getVotos_candidato_1(), si.getVotos_candidato_2(), si.getVotos_candidato_3());

                si.notificar();

                break;

            case "voto2":
                si.addVoto2();
                actualizarDatos(si.getVotos_candidato_1(), si.getVotos_candidato_2(), si.getVotos_candidato_3());

                si.notificar();
                break;
            case "voto3":
                si.addVoto3();
                actualizarDatos(si.getVotos_candidato_1(), si.getVotos_candidato_2(), si.getVotos_candidato_3());

                si.notificar();
                break;
            default:
                throw new AssertionError();
        }
    }

}
