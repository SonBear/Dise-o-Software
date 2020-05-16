/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import modelo.Candidato;
import modelo.SistemaVotos;
import vista.GeneradorCSV;
import vista.GraficaBarras;
import vista.GraficaPastel;
import vista.MenuPrincipal;

/**
 *
 * @author emman
 */
public class SistemaPrincipal implements ActionListener {

    private GeneradorCSV generadorCSV;
    private GraficaBarras graficaBarras;
    private GraficaPastel graficaPastel;
    private MenuPrincipal menuPrincipal;
    private SistemaVotos sistemaVotos;

    public void añadirCandidato(Candidato candidato) {
        sistemaVotos.adicionarCandidato(candidato);
    }

    public SistemaPrincipal() {
        sistemaVotos = new SistemaVotos();
        generadorCSV = new GeneradorCSV(sistemaVotos.getCandidatos());
        graficaPastel = new GraficaPastel(sistemaVotos.getCandidatos());
        graficaBarras = new GraficaBarras(sistemaVotos.getCandidatos());
        menuPrincipal = new MenuPrincipal();

        initComponents();

    }

    public void iniciar() {
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        graficaBarras.setVisible(true);
        graficaPastel.setVisible(true);
        actualizarLista();
        sistemaVotos.notificar();

    }

    private void initComponents() {
        menuPrincipal.getBtnVotar().addActionListener(this);
        graficaBarras.setTitle("Grafica Barras");
        graficaPastel.setTitle("Grafica Pastel");
        menuPrincipal.setTitle("Votos");
        sistemaVotos.añadirObservador(generadorCSV);
        sistemaVotos.añadirObservador(graficaBarras);
        sistemaVotos.añadirObservador(graficaPastel);
        undo();
    }

    private void actualizarLista() {
        List<Candidato> candidatos = sistemaVotos.getCandidatos();
        JList list = menuPrincipal.getListCandidatos();
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < candidatos.size(); i++) {
            model.add(i, candidatos.get(i));
        }
        list.setModel(model);

    }

    private Candidato getCandidato() {
        JList list = menuPrincipal.getListCandidatos();
        JLabel nombre = menuPrincipal.getLabelCandidato();
        JLabel votos = menuPrincipal.getLabelVotos();
        JPanel foto = menuPrincipal.getPanelFoto();
        Candidato candidato = (Candidato) list.getSelectedValue();
        foto.getGraphics().drawImage(candidato.getFoto().getImage(), 0, 0, null);
        foto.getGraphics().dispose();
        nombre.setText("Nombre: " + candidato.getNombre());
        //Como esto funciona antes de agregar un voto le sumo uno para que los datos esten actualizados
        votos.setText("Votos: " + (candidato.getVotos() + 1));
        return candidato;
    }

    private void undo() {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());

    }

    private void actualizarListas() {
        List<Candidato> candidatos = sistemaVotos.getCandidatos();
        graficaBarras.setCandidatos(candidatos);
        graficaPastel.setCandidatos(candidatos);
        generadorCSV.setCandidatos(candidatos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sistemaVotos.addVotoCandidato(getCandidato());
            actualizarListas();
            sistemaVotos.notificar();
        } catch (Exception ex) {
            Logger.getLogger(SistemaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class MyDispatcher implements KeyEventDispatcher {

        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_RELEASED && (e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                try {
                    sistemaVotos.restaurar();
                    actualizarListas();
                    sistemaVotos.notificar();
                    actualizarLista();

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
            return true;
        }

    }

}
