/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Dispositivo;
import com.model.EstadoBloqueado;
import com.model.MEF;
import com.view.MenuPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author emman
 */
public class Controller implements ActionListener {

    private MenuPrincipal menu;
    private MEF mef;

    public Controller() {

        initComponents();
        run();
    }

    private void run() {
        menu.setLocationRelativeTo(null);

        menu.setVisible(true);
    }

    private void initComponents() {
        menu = new MenuPrincipal();
        menu.getPanelStatus().setBackground(Color.red);
        Dispositivo dispositivo = new Dispositivo(menu.getPanelStatus(), menu.getLabelPanel());
        mef = new MEF(dispositivo);
        mef.setEstado(new EstadoBloqueado());
        menu.getPass().addActionListener(this);
        menu.getCoin().addActionListener(this);
        menu.getBtnReset().addActionListener(this);
        menu.getBtnListo().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "pass":
                mef.pasar();
                break;
            case "insertCoin":
                mef.moneda();
                break;
            case "reset":
                mef.reset();
                break;
            case "listo":
                mef.listo();
                break;
            default:
                throw new AssertionError();
        }

    }

}
