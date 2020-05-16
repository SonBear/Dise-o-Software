/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patron_Observer.Subject;

import Patron_Observer.Observer.Observador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emman
 */
public class SistemaVotos implements Observado {

    private List<Observador> observadores = new ArrayList<>();
    private int votos_candidato_1;
    private int votos_candidato_2;
    private int votos_candidato_3;

    public SistemaVotos() {
        votos_candidato_1 = 0;
        votos_candidato_2 = 0;
        votos_candidato_3 = 0;
    }

    public void addVoto1() {
        votos_candidato_1++;

    }

    public void addVoto2() {
        votos_candidato_2++;
    }

    public void addVoto3() {
        votos_candidato_3++;
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

    @Override
    public void añadirObservador(Observador ob) {
        observadores.add(ob);
    }

    @Override
    public void eliminarObservador(Observador ob) {
        observadores.remove(ob);
    }

    @Override
    public void notificar() {
        observadores.forEach((Observador observador) -> observador.actualizar());
    }

}
