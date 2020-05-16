/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import javax.swing.JFrame;
import modelo.Candidato;
import modelo.Observador;

/**
 *
 * @author emman
 */
public class GraficaPastel extends JFrame implements Observador {

    private int TOTAL_VOTOS;
    List<Candidato> candidatos;

    public GraficaPastel() {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        setLocation(50, 100);

        TOTAL_VOTOS = 0;
    }

    public GraficaPastel(List<Candidato> candidatos) {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));
        setLocation(50, 100);
        this.candidatos = candidatos;
        TOTAL_VOTOS = 0;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    private int getTotalVotos() {

        int total = 0;
        for (Candidato candidato : candidatos) {
            total += candidato.getVotos();
        }

        return total;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int total_Candidatos = candidatos.size();
        int[] grados_Candidato = new int[total_Candidatos];
        TOTAL_VOTOS = getTotalVotos();
        for (int i = 0; i < total_Candidatos; i++) {
            if (TOTAL_VOTOS > 0) {
                grados_Candidato[i] = candidatos.get(i).getVotos() * 360 / TOTAL_VOTOS;
            }

        }

        int width = this.getWidth() / 4 - 30;
        int height = this.getHeight() / 4 - 35;
        g.setColor(new Color(255, 0, 0));

        int grados = 0;
        for (int i = 0; i < total_Candidatos; i++) {

            grados += grados_Candidato[i];
            g.setColor(new Color(200, (i * 50) % 255, (i * 100) % 255));

            g.fillArc(width, height, 300, 300, grados - grados_Candidato[i], grados_Candidato[i]);
            g.setColor(Color.BLACK);
            g.drawString("Candidato  " + (i + 1) + " " + candidatos.get(i).getNombre() + " "
                    + " Votos: " + candidatos.get(i).getVotos(), 20, 45 + (i * 25));
        }

    }

    @Override
    public void actualizar() {
        repaint();
    }

}
