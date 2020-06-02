/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emman
 */
public abstract class Observado {

    protected List<Observador> observadores = new ArrayList<>();

    public void añadirObservador(Observador ob) {
        observadores.add(ob);
    }

    public void eliminarObservador(Observador ob) {
        observadores.remove(ob);
    }

    public void notificar() {
        observadores.forEach((Observador observador) -> observador.actualizar());
    }
}
