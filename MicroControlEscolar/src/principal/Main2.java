/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import com.itextpdf.text.DocumentException;
import controlEscolar.ControlEscolar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import vista.Interfaz;

/**
 *
 * @author emman
 */
public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        File alumno = new File("archivos\\alumnos.cvs");
        File maestro = new File("archivos\\maestros.cvs");
        File asignatura = new File("archivos\\asignaturas.cvs");
        File clase = new File("archivos\\clase.cvs");
        File curso = new File("archivos\\cursos.cvs");
        ControlEscolar controlEscolar = new ControlEscolar(alumno, maestro, asignatura, clase, curso);
        Interfaz menu = new Interfaz();
        Scanner leerOP = new Scanner(System.in);
        int op;
        do {
            menu.imprimirInterfaz();
            op = leerOP.nextInt();
            controlEscolar.actualizarArrays();
            switch (op) {
                case 1:
                    controlEscolar.ingresarAlumno();
                    break;
                case 2:
                    controlEscolar.ingresarMaestro();
                    break;
                case 3:
                    controlEscolar.ingresarAsignatura();
                    break;
                case 4:
                    controlEscolar.crearClase();
                    break;
                case 5:
                    controlEscolar.sececionarAlumnoClase();
                    break;
                case 6:
                    controlEscolar.imprimirCursosConAlumnos();
                    break;
                case 7:
                    controlEscolar.imprimirAlumnosClases();
                    break;
                case 8:
                    controlEscolar.GenerarPdfCurso();
                    break;
                default:
                    throw new AssertionError();
            }
            controlEscolar.limpiarArrays();
        } while (op != 0);
    }

}
