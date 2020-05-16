/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.commandMemento;

/**
 *
 * @author emman
 * @param <T>
 */
public abstract class Originator<T> {

    protected T estado;

    public abstract ICommand save();

    public abstract void restore(ICommand<T> memento);

    public abstract void setElemento(T estado);

}
