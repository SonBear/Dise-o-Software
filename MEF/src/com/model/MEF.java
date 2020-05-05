/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/**
 *
 * @author emman
 */
public class MEF {

    private Dispositivo dispositivo;
    private Estado estadoActual;

    public MEF(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void moneda() {
        estadoActual.moneda(this);
    }

    public void pasar() {
        estadoActual.pasar(this);

    }

    public void reset() {
        estadoActual.reset(this);
    }

    public void listo() {
        estadoActual.listo(this);
    }

    public void setEstado(Estado estado) {
        this.estadoActual = estado;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public Estado getEstado() {
        return estadoActual;
    }

}
