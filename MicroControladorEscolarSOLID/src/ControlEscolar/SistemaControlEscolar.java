/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlEscolar;

import DAO.DAOAlumnos;
import DAO.DAOAsignaturas;
import DAO.DAOClases;
import DAO.DAOCursos;
import DAO.DAOFicheros;
import DAO.DAOMaestros;
import Objetos.Alumno;
import Objetos.Asignatura;
import Objetos.Clase;
import Objetos.Curso;
import Objetos.Maestro;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class SistemaControlEscolar {

    private DAOFicheros<Alumno> fileAlumnos;
    private DAOFicheros<Maestro> fileMaestros;
    private DAOFicheros<Asignatura> fileAsisgnatua;
    private DAOFicheros<Clase> fileClases;
    private DAOFicheros<Curso> fileCursos;

    public SistemaControlEscolar() {
        fileAlumnos = new DAOAlumnos();
        fileMaestros = new DAOMaestros();
        fileAsisgnatua = new DAOAsignaturas();
        fileClases = new DAOClases();
        fileCursos = new DAOCursos();
    }

    public void agregarAlumno(Alumno alumno) {
        fileAlumnos.agregar(alumno);
    }

    public void imprimirListaAlumnos() {
        for (int i = 0; i < fileAlumnos.listar().size(); i++) {
            System.out.println(fileAlumnos.listar().get(i));
        }
    }

    public void limpiar(DAOFicheros d) {
        ArrayList array = d.listar();
        for (int i = 0; i < array.size(); i++) {
            d.eliminar(array.get(i));
        }
    }

}
