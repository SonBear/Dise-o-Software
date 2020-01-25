/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controlEscolar.ControlEscolar;
import java.io.File;

/**
 *
 * @author SonBear
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File alumno = new File("archivos\\alumnos.cvs");
        File maestro = new File("archivos\\maestros.cvs");
        File asignatura = new File("archivos\\asignaturas.cvs");
        File clase = new File("archivos\\clase.cvs");
        File curso = new File("archivos\\cursos.cvs");
        ControlEscolar controlEscolar = new ControlEscolar();
        controlEscolar.iniciar();
    }

}
