/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form menuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coin = new javax.swing.JButton();
        pass = new javax.swing.JButton();
        panelStatus = new javax.swing.JPanel();
        labelPanel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maquina estados");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        coin.setText("Insertar Moneda");
        coin.setActionCommand("insertCoin");

        pass.setText("Pasar");
        pass.setActionCommand("pass");

        panelStatus.setBackground(new java.awt.Color(255, 255, 255));
        panelStatus.setFocusable(false);
        panelStatus.setLayout(new java.awt.BorderLayout());

        labelPanel.setFont(new java.awt.Font("Tahoma", 0, 48));
        labelPanel.setForeground(new java.awt.Color(153, 153, 153));
        labelPanel.setText("INICIO");
        panelStatus.add(labelPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(coin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coin)
                    .addComponent(pass))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getCoin() {
        return coin;
    }

    public JLabel getLabelPanel() {
        return labelPanel;
    }

    public JPanel getPanelStatus() {
        return panelStatus;
    }

    public JButton getPass() {
        return pass;
    }

    public void setCoin(JButton coin) {
        this.coin = coin;
    }

    public void setLabelPanel(JLabel labelPanel) {
        this.labelPanel = labelPanel;
    }

    public void setPanelStatus(JPanel panelStatus) {
        this.panelStatus = panelStatus;
    }

    public void setPass(JButton pass) {
        this.pass = pass;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coin;
    private javax.swing.JLabel labelPanel;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JButton pass;
    // End of variables declaration//GEN-END:variables
}
