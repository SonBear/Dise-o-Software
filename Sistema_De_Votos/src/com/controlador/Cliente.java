/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.util.Observable;

/**
 *
 * @author emman
 */
public class Cliente extends Observable {

    private int votos_candidato_1;
    private int votos_candidato_2;
    private int votos_candidato_3;

    public Cliente() {
        votos_candidato_1 = 0;
        votos_candidato_2 = 0;
        votos_candidato_3 = 0;
    }

    public void addVoto1() {
        votos_candidato_1++;
        setChanged();
        notifyObservers(votos_candidato_1);
    }

    public void addVoto2() {
        votos_candidato_2++;
        setChanged();
        notifyObservers(votos_candidato_2);
    }

    public void addVoto3() {
        votos_candidato_3++;
        setChanged();
        notifyObservers(votos_candidato_3);
    }

    public int getVotos_candidato_1() {
        return votos_candidato_1;
    }

    public int getVotos_candidato_2() {
        return votos_candidato_2;
    }

    public int getVotos_candidato_3() {
        return votos_candidato_3;
    }

}
