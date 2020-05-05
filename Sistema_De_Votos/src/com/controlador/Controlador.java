/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.vista.MenuDeVotos;
import com.vista.VentanaBarras;
import com.vista.VentanaPastel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener, Observer {

    private MenuDeVotos menu;
    private VentanaPastel grafiPastel;
    private VentanaBarras grafiBarra;
    private Cliente cliente;

    public Controlador() {
        menu = new MenuDeVotos();
        cliente = new Cliente();
        grafiPastel = new VentanaPastel();
        grafiBarra = new VentanaBarras();
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        grafiPastel.setLocation(50, 100);
        grafiBarra.setLocation(910, 100);
        grafiBarra.setVisible(true);
        grafiPastel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "voto1":
                cliente.addVoto1();
                break;

            case "voto2":
                cliente.addVoto2();
                break;
            case "voto3":
                cliente.addVoto3();
                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        grafiPastel.actualizar(cliente.getVotos_candidato_1(), cliente.getVotos_candidato_2(), cliente.getVotos_candidato_3());
        grafiBarra.actualizar(cliente.getVotos_candidato_1(), cliente.getVotos_candidato_2(), cliente.getVotos_candidato_3());
    }

    private void initComponents() {
        menu.getVotar1().addActionListener(this);
        menu.getVotar2().addActionListener(this);
        menu.getVotar3().addActionListener(this);
        cliente.addObserver(this);
    }

}
