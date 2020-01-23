/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import controlEscolar.*;
import ficheros.Alumno;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class AccesoArchivoCursos extends AccesoArchivo {

    private ArrayList<Clase> listaClases;
    private ArrayList<Alumno> listaAlumnos;

    public AccesoArchivoCursos(ArrayList<Clase> listaClases, ArrayList<Alumno> listaAlumnos, File archivo) {
        super(archivo);
        this.listaClases = listaClases;
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public void imprimirArchivo() {
        ArrayList<Curso> listaCursos = obtenerObjectos();
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println("------------Clase: " + listaCursos.get(i).getClase().getAsignatura() + listaCursos.get(i).getClase().getMaestro().toString() + "--------------");
            System.out.println("-------------Lista de alumnos inscritos--------------------");
            for (int j = 0; j < listaCursos.get(i).getListaAlumnosInscritos().size(); j++) {
                System.out.println((j + 1) + ".- " + listaCursos.get(i).getListaAlumnosInscritos().get(j).toString());
            }
        }
    }

    public void imprimirClases() {
        ArrayList<Curso> listaCursos = obtenerObjectos();
        System.out.println("------------Cursos Disponibles-------------");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println((i + 1) + ".- Clase: " + listaCursos.get(i).getClase().getAsignatura() + " Maestro: " + listaCursos.get(i).getClase().getMaestro().toString());

        }
        System.out.println("------------------------------------------");
    }

    @Override
    public <T> ArrayList<T> obtenerObjectos() {
        ArrayList<Curso> listaCursos = new ArrayList<>();
        for (int i = 0; i < listaClases.size(); i++) {
            listaCursos.add(new Curso(listaClases.get(i), listaAlumnos));

        }

        return (ArrayList<T>) listaCursos;
    }

    public void setListaClases(ArrayList<Clase> listaClases) {
        this.listaClases = listaClases;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

}
