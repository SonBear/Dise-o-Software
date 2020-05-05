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
public class FactoryAlgoritmosEncrip {

    public static AlgoritmoEncriptamiento generarAlgoritmo(String algo) {
        AlgoritmoEncriptamiento algoritmo;
        if (algo.equals("ghash")) {
            algoritmo = new GHash();
        } else {
            algoritmo = new KHash();
        }

        algoritmo.configurar();
        return algoritmo;
    }
}
