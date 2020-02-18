/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Objetos.Curso;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class DAOCursos implements DAOFicheros<Curso> {

    public DAOCursos() {
        File fileCursos = new File("archivos/Cursos.cvs");
        if (!fileCursos.exists()) {
            try {
                fileCursos.createNewFile();
            } catch (IOException ex) {
            }
        }
    }

    @Override
    public void agregar(Curso e) {
    }

    @Override
    public void modificar(Curso e) {
    }

    @Override
    public void eliminar(Curso e) {
    }

    @Override
    public ArrayList<Curso> listar() {
        ArrayList<Curso> listaCursos = new ArrayList<>();

        return listaCursos;
    }

}
