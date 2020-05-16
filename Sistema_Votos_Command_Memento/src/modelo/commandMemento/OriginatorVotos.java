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
public class OriginatorVotos extends Originator<List<Candidato>> {

    @Override
    public ICommand save() {
        System.out.println("Originator: Estado candidato guardado");
        return new CommandVoto(estado);
    }

    @Override
    public void restore(ICommand<List<Candidato>> memento) {
        estado = memento.getEstado();
        System.out.println("Originator: Candidato Restaurado a " + estado);
    }

    @Override
    public void setElemento(List<Candidato> estado) {
        System.out.println("Originator: Actualizando estado candidato a " + estado);
        this.estado = estado;
    }

    public void est() {
        System.out.println("Originator: " + estado);
    }

}
