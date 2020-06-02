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
public enum Personas {

    Juan("Julio chow", "02/06/2020"),
    Manuel("Manuel Rodriguez", "03/07/2020"),
    Julia("Julia Deewers", " 04/06/2020");

    private final String nombreP;
    private final String fechaP;

    Personas(String nombre, String fecha) {
        nombreP = nombre;
        fechaP = fecha;
    }

    public String getNombreP() {
        return nombreP;
    }

    public String getFechaP() {
        return fechaP;
    }

}
