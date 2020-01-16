/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ficheros.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import utilidades.*;
import vista.Interfaz;

/**
 *
 * @author emman
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*---------------------------------------------------------*/
        File archivoMaestro = new File("archivos\\maestros.cvs");
        ArrayList<Maestro> listaMaestros = new ArrayList<>();
        AccesoArchivo accesoArchivoMaestro = new AccesoArchivo(archivoMaestro);
        /*---------------------------------------------------------*/
        File archivoAlumno = new File("archivos\\alumnos.cvs");
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        AccesoArchivo accesoArchivoAlumno = new AccesoArchivo(archivoAlumno);
        /*---------------------------------------------------------*/
        File archivoAsignatura = new File("archivos\\asignaturas.cvs");
        ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
        AccesoArchivo accesoArchivoAsignatura = new AccesoArchivo(archivoAsignatura);
        /*---------------------------------------------------------*/
        File archivoMaestroAsignatura = new File("archivos\\maestroAsignatura.cvs");
        AccesoArchivo accesoArchivoMaestroAsignatura = new AccesoArchivo(archivoMaestroAsignatura);
        /*---------------------------------------------------------*/
        Relacion relacion = new Relacion(listaAlumnos, listaMaestros, listaAsignaturas);

        Scanner leerOp = new Scanner(System.in);
        Scanner leerStr = new Scanner(System.in);
        Interfaz menu = new Interfaz();
        menu.imprimirInterfaz();
        int op = leerOp.nextInt();
        while (op != 6) {

            switch (op) {
                case 1:
                    System.out.println("---Ingrese el nuevo alumno:---");
                    System.out.print("Matricula: ");
                    String matricula = leerStr.next();
                    System.out.print("Nombre: ");
                    String nombre = leerStr.next();
                    System.out.print("Apellido: ");
                    String apellido = leerStr.next();
                    accesoArchivoAlumno.agregarContenido(matricula + "," + nombre + "," + apellido);
                    break;
                case 2:
                    System.out.println("---Ingrese el nuevo Maestro:---");
                    System.out.print("Clave: ");
                    String clave = leerStr.next();
                    System.out.print("Nombre: ");
                    String nombreM = leerStr.next();
                    System.out.print("Apellido: ");
                    String apellidoM = leerStr.next();
                    accesoArchivoMaestro.agregarContenido(clave + "," + nombreM + "," + apellidoM);
                    break;
                case 3:
                    System.out.println("---Ingrese la nueva asignatura:---");
                    System.out.print("Clave: ");
                    String claveA = leerStr.nextLine();
                    System.out.print("Licenciatura: ");
                    String licenciatura = leerStr.nextLine();
                    System.out.print("Nombre: ");
                    String nombreA = leerStr.nextLine();
                    accesoArchivoAsignatura.agregarContenido(claveA + "," + licenciatura + "," + nombreA);
                    break;
                case 4:
                    System.out.println("---Relacion Maestro Asignatura:---");
                    relacion.insertarDatosAsignaturasArrayList(accesoArchivoAsignatura);
                    relacion.insertarDatosMaestrosArrayList(accesoArchivoMaestro);
                    relacion.imprimirRelacionMaestroAsignatura(accesoArchivoMaestroAsignatura);
                    listaAsignaturas.clear();
                    listaMaestros.clear();
                    break;
                case 5:
                    System.out.println("-------------ALUMNOS----------");
                    accesoArchivoAlumno.imprimirArchivo();
                    System.out.println("-------------MAESTROS----------");
                    accesoArchivoMaestro.imprimirArchivo();
                    System.out.println("-------------ASIGNATURAS----------");
                    accesoArchivoAsignatura.imprimirArchivo();

                    break;
            }
            menu.imprimirInterfaz();
            op = leerOp.nextInt();
        }
    }

}
