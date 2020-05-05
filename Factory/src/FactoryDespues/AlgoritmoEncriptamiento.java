/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryDespues;

/**
 *
 * @author emman
 */
public abstract class AlgoritmoEncriptamiento {

    public abstract void configurar();

    public abstract String encriptar(String str);

    public abstract String desencriptar(String str);
}
