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
public class Paquete1 extends PaqueteArticulo {

    public Paquete1(List<Articulo> articulos) {
        super(articulos);
    }

    @Override
    public String descripcion() {
        return "Articulos: " + getArticulos().toString();
    }

    private double sumar() {
        List<Articulo> ar = getArticulos();
        double total = 0;
        for (int i = 0; i < ar.size(); i++) {
            total += ar.get(i).precio();
        }
        return total;
    }

    //Por cada total de los articulos se resta un 15% del total
    @Override
    public double precio() {
        double suma = sumar();
        return suma - (0.15 * suma);
    }

    @Override
    public String toString() {
        return "Paquete1{" + descripcion() + "TOTAL: " + precio();
    }

}
