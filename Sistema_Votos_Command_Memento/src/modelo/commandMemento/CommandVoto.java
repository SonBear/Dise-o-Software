/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.commandMemento;

import java.util.List;
import modelo.Candidato;

/**
 *
 * @author emman
 */
public class CommandVoto extends ICommand<List<Candidato>> {

    public CommandVoto() {

    }

    public CommandVoto(List<Candidato> estado) {
        super(estado);
    }

    @Override
    public void ejecutar(Candidato elemento) {
        List<Candidato> candidatos = getEstado();
        for (Candidato candidato : candidatos) {
            if (candidato.equals(elemento)) {
                int votoAnterior = candidato.getVotos();
                candidato.setVotos(votoAnterior + 1);
            }
        }

    }

    @Override
    public String toString() {
        return "CommandVoto{" + estado.toString() + '}';
    }

}
