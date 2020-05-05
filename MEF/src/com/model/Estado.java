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
public interface Estado {

    public void moneda(MEF mef);

    public void pasar(MEF mef);

    public void reset(MEF mef);

    public void listo(MEF mef);

}
