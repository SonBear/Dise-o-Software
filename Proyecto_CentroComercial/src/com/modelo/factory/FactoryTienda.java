/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.factory;

import com.modelo.tiendas.Libreria;
import com.modelo.tiendas.Tienda;
import com.modelo.tiendas.Zapateria;

/**
 *
 * @author emman
 */
public class FactoryTienda implements Factory {

    private Tienda libreria;
    private Tienda zapateria;

    @Override
    public Tienda crearTienda(String tipo) {
        switch (tipo) {
            case "Libreria":
                if (libreria == null) {
                    libreria = new Libreria();
                    return libreria;
                } else {
                    return libreria;
                }

            case "Zapateria":
                if (zapateria == null) {
                    zapateria = new Zapateria();
                    return zapateria;

                } else {
                    return zapateria;
                }

            default:
                throw new AssertionError();
        }

    }

}
