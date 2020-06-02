/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Enumeration;

/**
 *
 * @author emman
 */
public enum ArticulosZapateria {

    Refill("zapato masculino marca refill", 1200),
    Nike("zapato femenino marca nike", 1800),
    Adidas("zapato masculino marca adidas", 1300),
    Converse("zapato masculino marca converse", 1100),
    Fila("Zapato femenino marca Fila", 1900);

    private final String desc;
    private final double precio;

    private ArticulosZapateria(String descripcion, double precio) {
        this.desc = descripcion;
        this.precio = precio;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrecio() {
        return precio;
    }
}
