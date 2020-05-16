/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import modelo.commandMemento.CareTaker;
import modelo.commandMemento.CommandVoto;
import modelo.commandMemento.ICommand;
import modelo.commandMemento.Originator;
import modelo.commandMemento.OriginatorVotos;

/**
 * oRIGINATOR
 *
 * @author emman
 */
public class SistemaVotos implements Observado {

    private List<Observador> observadores = new ArrayList<>();

    private List<Candidato> candidatos; //Estado originator

    private CareTaker<List<Candidato>> careTaker = new CareTaker<>();

    private ICommand votar = new CommandVoto();

    private Originator ori = new OriginatorVotos();

    public SistemaVotos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
        votar.setEstado(candidatos);
    }

    public SistemaVotos() {
        candidatos = new ArrayList<>();
        votar.setEstado(candidatos);
    }

    public void addVotoCandidato(Candidato candidato) throws CloneNotSupportedException {
        List<Candidato> anterior = new ArrayList<>();
        for (int i = 0; i < candidatos.size(); i++) {
            anterior.add((Candidato) candidatos.get(i).clone());
        }

        ori.setElemento(anterior);
        careTaker.addCommandMemento(ori.save());

        votar.ejecutar(candidato);

    }

    public void restaurar() throws EmptyStackException {
        candidatos = careTaker.getICommand().getEstado();
        //Restaura la lista del commando votar
        votar.setEstado(candidatos);
        System.out.println("Sistema Votos: Elementos restaurados a " + candidatos);
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(List<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    @Override
    public void añadirObservador(Observador ob) {
        observadores.add(ob);
    }

    @Override
    public void eliminarObservador(Observador ob) {
        observadores.remove(ob);
    }

    @Override
    public void notificar() {
        observadores.forEach((Observador observador) -> observador.actualizar());
    }

    @Override
    public String toString() {
        return "SistemaVotos{" + "candidatos=" + candidatos + '}';
    }

}
