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
public class FactoryKHash implements FactoryAlgoritmos {

    @Override
    public AlgoritmoEncriptamiento crearAlgoritmo() {
        AlgoritmoEncriptamiento algoritmo = new KHash();
        algoritmo.configurar();
        return algoritmo;
    }

}
