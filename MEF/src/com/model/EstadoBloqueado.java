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
public class EstadoBloqueado implements Estado {

    @Override
    public void moneda(MEF mef) {
        mef.getDispositivo().desbloquear();
        mef.setEstado(new EstadoDesbloqueado());
    }

    @Override
    public void pasar(MEF mef) {
        mef.getDispositivo().alarma();
        mef.setEstado(new EstadoViolacion());
    }

    @Override
    public void reset(MEF mef) {
    }

    @Override
    public void listo(MEF mef) {
    }

}
