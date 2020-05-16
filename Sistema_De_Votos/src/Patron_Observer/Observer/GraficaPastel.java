/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_Observer.Observer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author emman
 */
public class GraficaPastel extends JFrame implements Observador {

    private int votos_1;
    private int votos_2;
    private int votos_3;
    private int TOTAL_VOTOS;

    public GraficaPastel() {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        setLocation(50, 100);
        votos_1 = 0;
        votos_2 = 0;
        votos_3 = 0;
        TOTAL_VOTOS = 0;
    }

    public GraficaPastel(int votos_1, int votos_2, int votos_3) {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        setLocation(50, 100);
        this.votos_1 = votos_1;
        this.votos_2 = votos_2;
        this.votos_3 = votos_3;
        TOTAL_VOTOS = 0;
    }

    public void setVotos_1(int votos_1) {
        this.votos_1 = votos_1;
    }

    public void setVotos_2(int votos_2) {
        this.votos_2 = votos_2;
    }

    public void setVotos_3(int votos_3) {
        this.votos_3 = votos_3;
    }

    public void añadirVoto_1() {
        votos_1++;

    }

    public void añadirVoto_2() {
        votos_2++;
    }

    public void añadirVoto_3() {
        votos_3++;
    }

    public void actualizarDatos(int votos_1, int votos_2, int votos_3) {
        this.votos_1 = votos_1;
        this.votos_2 = votos_2;
        this.votos_3 = votos_3;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int grados_votos_1 = 0;
        int grados_votos_2 = 0;
        int grados_votos_3 = 0;
        TOTAL_VOTOS = votos_1 + votos_2 + votos_3;
        if (TOTAL_VOTOS > 0) {
            grados_votos_1 = votos_1 * 360 / TOTAL_VOTOS;
            grados_votos_2 = votos_2 * 360 / TOTAL_VOTOS;
            grados_votos_3 = votos_3 * 360 / TOTAL_VOTOS;
        }

        int width = this.getWidth() / 4 - 30;
        int height = this.getHeight() / 4 - 35;
        g.setColor(new Color(255, 0, 0));
        g.fillArc(width, height, 300, 300, 0, grados_votos_1);
        g.drawString("Candidato 1: " + votos_1, 20, 50);

        g.setColor(new Color(0, 243, 0));
        g.fillArc(width, height, 300, 300, grados_votos_1, grados_votos_2);
        g.drawString("Candidato 2: " + votos_2, 20, 70);

        g.setColor(new Color(0, 0, 240));
        g.fillArc(width, height, 300, 300, grados_votos_2 + grados_votos_1, grados_votos_3);
        g.drawString("Candidato 3: " + votos_3, 20, 90);
    }

    @Override
    public void actualizar() {
        repaint();
    }

}
