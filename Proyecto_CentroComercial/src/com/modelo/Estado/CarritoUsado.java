/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.Estado;

/**
 *
 * @author emman
 */
public class CarritoUsado implements CarritoEstado {

    @Override
    public String manejar() {
        return "Carrito en uso";
    }

}
