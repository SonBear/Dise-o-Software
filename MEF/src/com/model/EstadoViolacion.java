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
public class EstadoViolacion implements Estado {

    @Override
    public void moneda(MEF mef) {
        mef.setEstado(new EstadoViolacion());
    }

    @Override
    public void pasar(MEF mef) {
        mef.setEstado(new EstadoViolacion());
    }

    @Override
    public void reset(MEF mef) {
        mef.getDispositivo().resetAlarma();
    }

    @Override
    public void listo(MEF mef) {
        mef.getDispositivo().resetAlarma();
        mef.getDispositivo().bloquear();
        mef.setEstado(new EstadoBloqueado());
    }

}
