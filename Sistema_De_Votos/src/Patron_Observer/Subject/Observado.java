/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_Observer.Subject;

import Patron_Observer.Observer.Observador;

/**
 *
 * @author emman
 */
public interface Observado {

    public void añadirObservador(Observador ob);

    public void eliminarObservador(Observador ob);

    public void notificar();

}
