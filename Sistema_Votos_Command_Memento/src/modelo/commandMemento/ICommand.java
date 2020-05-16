/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.commandMemento;

import modelo.Candidato;

/**
 *
 * @author emman
 * @param <T>
 */
public abstract class ICommand<T> {

    protected T estado;

    public ICommand(T estado) {
        this.estado = estado;
    }

    public ICommand() {

    }

    public T getEstado() {
        return estado;
    }

    public void setEstado(T estado) {
        this.estado = estado;
    }

    public abstract void ejecutar(Candidato elemento);

}
