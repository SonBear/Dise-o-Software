/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class Dispositivo {

    private JPanel panel;
    private JLabel label;

    public Dispositivo(JPanel panel, JLabel label) {
        this.panel = panel;
        this.label = label;
    }

    public Dispositivo() {

    }

    public void bloquear() {
        System.out.println("Dispositivo bloqueado");

        panel.setBackground(Color.red);
        label.setText("Bloqueado");

    }

    public void desbloquear() {
        System.out.println("Dispositivo desbloqueado");
        panel.setBackground(Color.green);
        label.setText("Desbloqueado");
    }

    public void gracias() {
        System.out.println("Gracias :)");
        JOptionPane.showMessageDialog(panel, "Gracias :)");
    }

    public void alarma() {
        System.out.println("Alarma sonando.....");

        panel.setBackground(Color.yellow);
        label.setText("Alarma sonando....");
    }

    public void resetAlarma() {
        System.out.println("Alarma reseteada");
        JOptionPane.showMessageDialog(panel, "Alarma restaurada");

    }

}
