/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.Decorator;

import java.util.List;

/**
 *
 * @author emman
 */
public abstract class PaqueteArticulo implements Articulo {

    private List<Articulo> articulos;

    public PaqueteArticulo(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

}
