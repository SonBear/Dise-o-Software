/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlEscolar;

import ficheros.Alumno;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class Curso {

    private Clase clase;
    private ArrayList<Alumno> listaAlumnosInscritos;

    public Curso(Clase clase, ArrayList<Alumno> listaAlumnosInscritos) {
        this.clase = clase;
        this.listaAlumnosInscritos = alumnosInscritos(listaAlumnosInscritos);
    }

    public void imprimirLita() {
        System.out.println(clase.getAsignatura());
        System.out.println(clase.getAsignatura());
        for (int i = 0; i < listaAlumnosInscritos.size(); i++) {
            System.out.println((i + 1) + ".- " + listaAlumnosInscritos.get(i));
        }
    }

    public ArrayList<Alumno> alumnosInscritos(ArrayList<Alumno> alumnos) {
        ArrayList<Alumno> alumnosInscritos = new ArrayList();
        for (int i = 0; i < alumnos.size(); i++) {
            for (int j = 0; j < alumnos.get(i).getClases().size(); j++) {
                if (alumnos.get(i).getClases().get(j).equals(clase)) {
                    alumnosInscritos.add(alumnos.get(i));
                }
            }
        }

        return alumnosInscritos;
    }

    public Clase getClase() {
        return clase;
    }

    public ArrayList<Alumno> getListaAlumnosInscritos() {
        return listaAlumnosInscritos;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public void setListaAlumnosInscritos(ArrayList<Alumno> listaAlumnosInscritos) {
        this.listaAlumnosInscritos = listaAlumnosInscritos;
    }

}
