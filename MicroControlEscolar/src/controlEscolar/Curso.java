/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlEscolar;

import ficheros.Alumno;
import java.util.ArrayList;
import utilidades.AccesoArchivoCursos;

/**
 *
 * @author SonBear
 */
public class Curso {

    private Clase clase;
    private ArrayList<Alumno> listaAlumnosInscritos;

    public Curso(Clase clase, AccesoArchivoCursos archivo) {
        this.clase = clase;
        this.listaAlumnosInscritos = obtenerAlumnosInscritos(archivo);
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

    private ArrayList<Alumno> obtenerAlumnosInscritos(AccesoArchivoCursos archivoCurso) {
        ArrayList<Alumno> alumnosInscritos = new ArrayList<>();
        for (int i = 0; i < archivoCurso.leerArchivo().size(); i++) {
            String datos[] = archivoCurso.leerArchivo().get(i).split(",");
            String clase = datos[3] + "," + datos[4];
            if (clase.equals(this.clase.toString())) {
                alumnosInscritos.add(new Alumno(Integer.parseInt(datos[0]), datos[1], datos[2]));
            }
        }
        return alumnosInscritos;
    }

}
