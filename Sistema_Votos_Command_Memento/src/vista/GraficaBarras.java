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
public class GraficaBarras extends JFrame implements Observador {

    private List<Candidato> candidatos;

    public GraficaBarras() {
        this.setBackground(Color.WHITE);
        this.setSize(new Dimension(400, 400));

        setLocation(910, 100);
    }

    public GraficaBarras(List<Candidato> candidatos) {
        this.setBackground(Color.WHITE);
        this.candidatos = candidatos;
        this.setSize(new Dimension(400, 400));
        setLocation(910, 100);
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    private int encontrarMayorDato() {
        int mayor = 0;
        for (int i = 0; i < candidatos.size(); i++) {

            if (mayor < candidatos.get(i).getVotos()) {
                mayor = candidatos.get(i).getVotos();
            }

        }
        return mayor;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        int mayor = encontrarMayorDato();
        System.out.println(mayor);
        int numeroCandidatos = candidatos.size();
        int[] largo_votos = new int[numeroCandidatos];
        for (int i = 0; i < numeroCandidatos; i++) {
            if (mayor > 0) {

                largo_votos[i] = candidatos.get(i).getVotos() * 350 / mayor;
            }
        }

        for (int i = 0; i < numeroCandidatos; i++) {
            g.setColor(new Color(200, (i * 50) % 255, (i * 100) % 255));
            g.drawString("Candidato  " + (i + 1) + " " + candidatos.get(i).getNombre() + " "
                    + candidatos.get(i).getVotos(), 10, 50 + (i * 55));
            g.fillRect(40, 60 + (i * 55), largo_votos[i], 30);

        }

    }

    @Override
    public void actualizar() {
        repaint();
    }
}
