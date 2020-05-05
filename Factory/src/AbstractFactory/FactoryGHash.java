/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author emman
 */
public class FactoryGHash implements FactoryAlgoritmos {

    @Override
    public AlgoritmoEncriptamiento crearAlgoritmo() {
        AlgoritmoEncriptamiento algoritmo = new GHash();
        algoritmo.configurar();
        return algoritmo;
    }
}
