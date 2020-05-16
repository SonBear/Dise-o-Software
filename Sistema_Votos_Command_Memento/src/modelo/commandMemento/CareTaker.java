/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.commandMemento;

import java.util.Stack;

/**
 *
 * @author emman
 */
public class CareTaker<T> {

    private Stack<ICommand<T>> mementos = new Stack<>();

    public void addCommandMemento(ICommand memento) {
        mementos.add(memento);
    }

    public void getMementos() {
        System.out.println("F---" + mementos.toString());
    }

    public ICommand<T> getICommand() {
        return mementos.pop();
    }

}
