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
public class EstadoDesbloqueado implements Estado {

    @Override
    public void moneda(MEF mef) {
        mef.getDispositivo().gracias();

    }

    @Override
    public void pasar(MEF mef) {
        mef.getDispositivo().bloquear();
        mef.setEstado(new EstadoBloqueado());
    }

    @Override
    public void reset(MEF mef) {
    }

    @Override
    public void listo(MEF mef) {
    }

}
