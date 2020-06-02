/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.factory;

import com.modelo.tiendas.Tienda;

/**
 *
 * @author emman
 */
public interface Factory {

    public Tienda crearTienda(String tipo);
}
