/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import java.util.List;
import modelo.Candidato;
import modelo.SistemaVotos;
import vista.GeneradorCSV;
import vista.GraficaBarras;
import vista.GraficaPastel;

/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        Candidato a = new Candidato("FF", 0);
        Candidato b = new Candidato("DDD", 0);
        Candidato c = new Candidato("VVV", 0);
        Candidato d = new Candidato("RRR", 0);
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(a);
        candidatos.add(b);
        GraficaPastel gr = new GraficaPastel(candidatos);
        GraficaBarras gr2 = new GraficaBarras(candidatos);
        GeneradorCSV csv = new GeneradorCSV(candidatos);
        gr.setVisible(true);
        gr2.setVisible(true);
        SistemaVotos si = new SistemaVotos(candidatos);
        si.añadirObservador(gr);
        si.añadirObservador(gr2);
        si.añadirObservador(csv);

        si.addVotoCandidato(a);
        System.out.println(si);
        si.restaurar();
        System.out.println(si);
        si.addVotoCandidato(b);
        si.addVotoCandidato(b);
        System.out.println(si);

        //Siempre se tiene que actualizar los datos
        gr.setCandidatos(si.getCandidatos());
        gr2.setCandidatos(si.getCandidatos());
        si.notificar();

        si.adicionarCandidato(d);
        si.addVotoCandidato(d);
        gr.setCandidatos(si.getCandidatos());
        gr2.setCandidatos(si.getCandidatos());
        csv.actualizarDatos(si.getCandidatos());
        si.notificar();
        //Cambia esta mierda a que busque el objeto correcto dentro de un arrayList Cualquiera FFFFFF
        System.out.println(si);

        //care.getICommand();
    }

}
