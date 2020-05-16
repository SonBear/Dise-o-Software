/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import javax.swing.ImageIcon;
import modelo.Candidato;

/**
 *
 * @author emman
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaPrincipal si = new SistemaPrincipal();
        Candidato a = new Candidato("Juan", 0);
        Candidato b = new Candidato("Luis", 0);
        Candidato c = new Candidato("Pedro", 0);

        a.setFoto(new ImageIcon("Archivos\\a.jpg"));
        b.setFoto(new ImageIcon("Archivos\\b.jpg"));
        c.setFoto(new ImageIcon("Archivos\\c.jpg"));
        si.añadirCandidato(a);
        si.añadirCandidato(b);
        si.añadirCandidato(c);
        si.iniciar();
    }

}
