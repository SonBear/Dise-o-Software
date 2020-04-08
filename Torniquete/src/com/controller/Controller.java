/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.CoinException;
import com.model.PassException;
import com.model.Status;
import com.model.Torniquete;
import com.view.MenuPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class Controller implements ActionListener {

    private MenuPrincipal menu;
    private Torniquete torn;

    public Controller() {

        initComponents();
        run();
    }

    public void run() {
        menu.setLocationRelativeTo(null);

        menu.setVisible(true);
    }

    private void initComponents() {
        menu = new MenuPrincipal();
        torn = new Torniquete();
        menu.getPass().addActionListener(this);
        menu.getCoin().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "pass":
                    torn.pass();
                    break;
                case "insertCoin":
                    torn.insertCoin();
                    break;
                default:
                    throw new AssertionError();
            }
            updatePanel(torn.getStatus());
        } catch (PassException ex) {
            infoMessage(ex.getMessage());
        } catch (CoinException ex) {
            infoMessage(ex.getMessage());
        }
    }

    private void infoMessage(String message) {
        JOptionPane.showMessageDialog(menu, message, "Info", 2);
    }

    private void updatePanel(Status status) {
        JPanel panel = menu.getPanelStatus();
        JLabel label = menu.getLabelPanel();
        switch (status) {
            case LOCKED:
                panel.setBackground(Color.RED);
                label.setText("BLOQUEADO");

                break;
            case UNLOCKED:
                panel.setBackground(Color.GREEN);
                label.setText("DESBLOQUEADO");
                break;
            default:
                throw new AssertionError();
        }
    }

}
