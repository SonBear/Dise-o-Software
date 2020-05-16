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
public class GraficaBarras extends JFrame implements Observador {

    private int votos_1;
    private int votos_2;
    private int votos_3;

    public GraficaBarras() {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        votos_1 = 0;
        votos_2 = 0;
        votos_3 = 0;
        setLocation(910, 100);
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

    public GraficaBarras(int votos_1, int votos_2, int votos_3) {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        this.votos_1 = votos_1;
        this.votos_2 = votos_2;
        this.votos_3 = votos_3;
        setLocation(910, 100);
    }

    public void actualizarDatos(int votos_1, int votos_2, int votos_3) {
        this.votos_1 = votos_1;
        this.votos_2 = votos_2;
        this.votos_3 = votos_3;
    }

    private int encontrarMayorDato(int v1, int v2, int v3) {
        if (v1 > v2 && v1 > v3) {
            return v1;
        } else if (v2 > v3) {

            return v2;
        } else {
            return v3;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        int mayor = encontrarMayorDato(votos_1, votos_2, votos_3);
        int largo_voto_1 = 0;
        int largo_voto_2 = 0;
        int largo_voto_3 = 0;
        if (mayor > 0) {
            largo_voto_1 = votos_1 * 350 / mayor;
            largo_voto_2 = votos_2 * 350 / mayor;
            largo_voto_3 = votos_3 * 350 / mayor;
        }

        g.setColor(new Color(255, 0, 0));
        g.drawString("Canditado 1: " + votos_1, 10, 50);
        g.fillRect(40, 60, largo_voto_1, 30);
        g.setColor(new Color(0, 240, 0));
        g.drawString("Canditado 2: " + votos_2, 10, 105);
        g.fillRect(40, 110, largo_voto_2, 30);
        g.setColor(new Color(0, 0, 240));
        g.drawString("Canditado 3: " + votos_3, 10, 155);
        g.fillRect(40, 160, largo_voto_3, 30);

    }

    @Override
    public void actualizar() {
        repaint();
    }
}
