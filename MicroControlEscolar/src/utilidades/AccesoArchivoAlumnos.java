/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import controlEscolar.Clase;
import ficheros.Alumno;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class AccesoArchivoAlumnos extends AccesoArchivo {

    public AccesoArchivoAlumnos(File archivo) {
        super(archivo);
    }

    @Override
    public void imprimirArchivo() {
        System.out.println("---------------Lista   Alumnos--------------------");

        for (int i = 0; i < leerArchivo().size(); i++) {
            String variables[] = leerArchivo().get(i).split(",");
            System.out.println(String.format("%-2d %10s %10s %10s", i + 1, variables[0], variables[1], variables[2]));
        }

        System.out.println("-------------------------------------------\n");
    }

    @Override
    public <T> ArrayList<T> obtenerObjectos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<String> datos = leerArchivo();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            Alumno unAlumno = new Alumno(Integer.parseInt(variables[0]), variables[1], variables[2]);
            alumnos.add(unAlumno);
        }
        return (ArrayList<T>) alumnos;
    }

    public ArrayList<Alumno> recuperarDatosArrayAlumno(ArrayList<Clase> listaClases, AccesoArchivoCursos archivo) {
        ArrayList<String> datos = archivo.leerArchivo();
        ArrayList<Alumno> listaAlumnos = obtenerObjectos();
        for (int i = 0; i < datos.size(); i++) {
            String variables[] = datos.get(i).split(",");
            for (int j = 0; j < listaAlumnos.size(); j++) {
                if (variables[0].equals(listaAlumnos.get(j).getMatricula() + "")) {
                    for (int k = 0; k < listaClases.size(); k++) {
                        if (variables[3].equals(listaClases.get(k).getMaestro().getClave() + "")
                                && variables[4].equals(listaClases.get(k).getAsignatura().getClave())) {
                            listaAlumnos.get(j).getClases().add(listaClases.get(k));
                        }
                    }
                }
            }
        }
        return listaAlumnos;

    }

    public void imprimirClasesAlumno(ArrayList<Clase> listaClases, AccesoArchivoCursos archivo) {
        ArrayList<Alumno> listaAlumnos = recuperarDatosArrayAlumno(listaClases, archivo);
        for (int i = 0; i < listaAlumnos.size(); i++) {
            System.out.println("-----------" + listaAlumnos.get(i) + "-----------");
            System.out.println("----------------Lista clases----------------");
            for (int j = 0; j < listaAlumnos.get(i).getClases().size(); j++) {
                System.out.println((j + 1) + ".- " + listaAlumnos.get(i).getClases().get(j).toString());
            }
        }
    }

}
