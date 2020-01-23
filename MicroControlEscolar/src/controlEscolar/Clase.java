/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlEscolar;

import ficheros.*;

/**
 *
 * @author emman
 */
public class Clase {

    private Maestro maestro;
    private Asignatura asignatura;

    public Clase(Maestro maestro, Asignatura asignatura) {
        this.maestro = maestro;
        this.asignatura = asignatura;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String toString() {
        return maestro.getClave() + "," + asignatura.getClave();
    }

}
